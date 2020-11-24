/* MapReduce Program - file MostPopularArticles.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

package drivers;

import java.io.IOException;
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

/** MapReduce program for Most Popular Articles in Wikipedia articles.
 * This will output the articles that have the highest number of page views.
 */

public class MostPopularArticles {
    public static class MostPopularArticlesMap
            extends Mapper<LongWritable, Text, Text, LongWritable> {

        /** Map Function of the program.
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
        }

        /** Read and setup the parameters.
         *
         * @param context
         * @throws IOException if setup cannot be closed.
         * @throws InterruptedException if interrupted while processing.
         */

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
        }
    }

    public static class MostPopularArticlesReduce extends
            Reducer<Text, LongWritable, Text, DoubleWritable> {

        /** Reduce Function of the program.
         * Aggregate articles with highest views.
         *
         * @param key
         * @param values
         * @param context
         * @throws IOException if reduce cannot be written or closed.
         * @throws InterruptedException if interrupted while processing.
         */

        public void reduce(Text key, Iterable<LongWritable> values, Context context)
                throws IOException, InterruptedException {
        }
    }

    /** Setting up the job for most popular articles.
     *
     * @param args
     * @throws IOException if main cannot be closed.
     * @throws ClassNotFoundException
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

        job.setJarByClass(MostPopularArticles.class);

        /* Set name of Mapper and Reducer class to
         * MostPopularArticles.class
         */

        job.setMapperClass(MostPopularArticlesMap.class);
        job.setReducerClass(MostPopularArticlesReduce.class);

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