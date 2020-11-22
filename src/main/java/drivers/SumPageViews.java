package drivers;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SumPageViews {
    public static class SumPageViewsMap extends Mapper<LongWritable, Text, Text, LongWritable> {

        @Override
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String delims = ",";
            String[] wikiData = StringUtils.split(value.toString(), delims);
            Text article = new Text();
            LongWritable views = new LongWritable(Long.parseLong(wikiData[2]));
            context.write(article, views);
        }

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
        }
    }

    public static class SumPageViewsReduce extends
            Reducer<Text, LongWritable, Text, DoubleWritable> {
        public void reduce(Text key, Iterable<LongWritable> values, Context context)
                throws IOException, InterruptedException {
            Long views = (long) 0;
            for (LongWritable t : values) {
                views += t.get();

            }
            context.write(key, new DoubleWritable(views));
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException,
            InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "countWikipedia");
        job.setJarByClass(SumPageViews.class);
        job.setMapperClass(SumPageViewsMap.class);
        job.setReducerClass(SumPageViewsReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputValueClass(LongWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
    }
}