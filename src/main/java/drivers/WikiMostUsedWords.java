/* MapReduce Program - file WikiMostUsedWords.java
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
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/** MapReduce program for Most Used Words in Wikipedia articles.
 * This will output the total count of a word from
 * Wikipedia articles.
 */

public class WikiMostUsedWords {

    /** Setting up the job for most used words in Wikipedia.
     *
     * @param args an array of command-line arguments for the application.
     * @throws IOException if main cannot be closed.
     * @throws ClassNotFoundException if tries to load in a class through its string name.
     * @throws InterruptedException if interrupted while processing.
     */

    public static void main(String[] args) throws Exception {

        /* Create a configuration for the job
         */

        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length != 2) {
            System.err.println("Usage: WikiMostUsedWords <in> <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf);
        job.setJobName("wikimostused");

        /* Set relevant jar were class specified as it's
         * parameter is present as part of that jar.
         */

        job.setJarByClass(WikiMostUsedWords.class);

        /* Set name of Mapper and Reducer class to
         * AveragePageViews.class
         */

        job.setMapperClass(mappers.WikiDumpMapper.class);
        job.setReducerClass(reducers.TopValuesReducer.class);

        /* Specify the data type of of output key and value
         */

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        /* Setting input and output directories using command line arguments.
         * arg[0] = name of input directory on HDFS
         * arg[1] =  name of output directory to be created to store the output file
         */

        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
