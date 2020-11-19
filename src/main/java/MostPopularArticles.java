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

public class MostPopularArticles {
    public static class MostPopularArticlesMap
            extends Mapper<LongWritable, Text, Text, LongWritable> {

        @Override
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {

        }

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
        }
    }

    public static class MostPopularArticlesReduce extends
            Reducer<Text, LongWritable, Text, DoubleWritable> {
        public void reduce(Text key, Iterable<LongWritable> values, Context context)
                throws IOException, InterruptedException {

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException,
            InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "countWikipedia");
        job.setJarByClass(MostPopularArticles.class);
        job.setMapperClass(MostPopularArticlesMap.class);
        job.setReducerClass(MostPopularArticlesReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputValueClass(LongWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
    }
}