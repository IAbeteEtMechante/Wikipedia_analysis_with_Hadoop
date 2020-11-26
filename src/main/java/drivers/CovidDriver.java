/* MapReduce Program - file CovidDriver.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

package drivers;

import java.io.IOException;
import java.util.Arrays;
import mappers.CovidMap;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import reducers.CovidReduce;

/** MapReduce program for Total Views of Covid Related Articles.
 * This will output the date and the total views of Covid
 * related articles from Wikipedia per day.
 */

public class CovidDriver {

    /** Setting up the job for total views of Covid related articles.
     *
     * @param args an array of command-line arguments for the application.
     * @throws IOException if main cannot be closed.
     * @throws ClassNotFoundException if tries to load in a class through its string name.
     * @throws InterruptedException if interrupted while processing.
     */

    public static void main(String[] args)
            throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length != 2) {
            System.out.println(Arrays.toString(args));
            System.exit(-1);
        }

        /* Create a configuration for the job
         */

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "CountWiki");

        /* Set relevant jar were class specified as it's
         * parameter is present as part of that jar.
         */

        job.setJarByClass(CovidDriver.class);

        /* Set name of Mapper to CovidMap.class
         * and Reducer class to CovidReduce.class.
         */

        job.setMapperClass(CovidMap.class);
        job.setReducerClass(CovidReduce.class);

        /* Specify the data type of of output key and value
         */

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputValueClass(LongWritable.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        /* Setting input and output directories using command line arguments.
         * arg[0] = name of input directory on HDFS
         * arg[1] =  name of output directory to be created to store the output file
         */

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
