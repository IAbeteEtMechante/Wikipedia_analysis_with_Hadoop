/* MapReduce Program - file AveragePageViews.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

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

/** MapReduce program for Average Page Views of Wikipedia articles.
 * This will output the average page views per articles.
 */

public class AveragePageViews {
    public static class AveragePageViewsMap extends Mapper<LongWritable, Text, Text, LongWritable> {

        /** Map Function of the program.
         * Maps input to article title and views.
         *
         * @param key
         * @param value
         * @param context
         * @throws IOException if map cannot be written or closed.
         * @throws InterruptedException if interrupted while processing.
         */

        @Override
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String delims = ",";
            String[] wikiData = StringUtils.split(value.toString(), delims);
            Text article = new Text();
            LongWritable views = new LongWritable(Long.parseLong(wikiData[2]));
            context.write(article, views);
        }

        /** Read and setup the parameters.
         *
         * @param context
         * @throws IOException if setup cannot be closed.
         * @throws InterruptedException
         */

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
        }
    }

    public static class AveragePageViewsReduce extends
            Reducer<Text, LongWritable, Text, DoubleWritable> {

        /** Reduce Function of the program.
         * Overwriting the views with average views.
         * Aggregation of results.
         *
         * @param key
         * @param values
         * @param context
         * @throws IOException if reduce cannot be written or closed.
         * @throws InterruptedException if interrupted while processing.
         */

        public void reduce(Text key, Iterable<LongWritable> values, Context context)
                throws IOException, InterruptedException {
            Long views = (long) 0;
            Long count = (long) 0;
            for (LongWritable t : values) {
                views += t.get();
                count++;
            }
            Double average = ((double) views / (double) count);
            context.write(key, new DoubleWritable(average));
        }
    }

    /** Setting up the job for average page views.
     *
     * @param args an array of command-line arguments for the application.
     * @throws IOException if main cannot be closed.
     * @throws ClassNotFoundException if tries to load in a class through its string name.
     * @throws InterruptedException if interrupted while processing.
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException,
            InterruptedException {

        /* Create a configuration for the job
         */

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "countWikipedia");

        /* Set relevant jar were class specified as it's
         * parameter is present as part of that jar.
         */

        job.setJarByClass(AveragePageViews.class);

        /* Set name of Mapper and Reducer class to
         * AveragePageViews.class
         */

        job.setMapperClass(AveragePageViewsMap.class);
        job.setReducerClass(AveragePageViewsReduce.class);

        /* Specify the data type of of output key and value
         */

        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputValueClass(LongWritable.class);

        /* Setting input and output directories using command line arguments.
         * arg[0] = name of input directory on HDFS
         * arg[1] =  name of output directory to be created to store the output file
         */

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
    }
}