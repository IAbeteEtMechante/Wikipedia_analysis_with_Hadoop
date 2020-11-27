/* MapReduce Program - file LatestArticlesViewed.java
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

/** MapReduce program for Latest Articles Viewed in Wikipedia.
 * This will output the recent articles viewed by users
 */

public class LatestArticlesViewed {
    public static class LatestArticlesViewedMap
            extends Mapper<LongWritable, Text, Text, LongWritable> {

        /** Map Function of the program.
         * Maps input to recently article title.
         *
         * @param key is the title of an article from Wikipedia.
         * @param value is the sum of page views of an article.
         * @param context is the map containing articles recently
         *                viewed by the users.
         * @throws IOException if map cannot be written or closed.
         * @throws InterruptedException if interrupted while processing.
         */

        @Override
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
        }

        /** Read and setup the parameters.
         *
         * @param context is the map containing the title of Wikipedia
         *                articles and its corresponding page views.
         * @throws IOException if setup cannot be closed.
         * @throws InterruptedException if interrupted while processing.
         */

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
        }
    }

    public static class LatestArticlesViewedReduce extends
            Reducer<Text, LongWritable, Text, DoubleWritable> {

        /** Reduce Function of the program.
         * Overwriting the views with average views.
         * Aggregation of results.
         *
         * @param key is the title of article from Wikipedia.
         * @param values is the sum of page views of an article.
         * @param context is the map containing articles recently
         *                viewed by the users.
         * @throws IOException if reduce cannot be written or closed.
         * @throws InterruptedException if interrupted while processing.
         */

        public void reduce(Text key, Iterable<LongWritable> values, Context context)
                throws IOException, InterruptedException {
        }
    }

    /** Setting up the job for latest articles viewed.
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

        job.setJarByClass(MostPopularArticles.class);

        /* Set name of Mapper and LatestArticlesViewedMap.class
         * and Reducer class to LatestArticlesViewedReduce.class.
         */

        job.setMapperClass(LatestArticlesViewedMap.class);
        job.setReducerClass(LatestArticlesViewedReduce.class);

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