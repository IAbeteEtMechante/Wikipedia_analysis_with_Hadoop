/**
 * MapReduce Program - file MostUsedWords.java
 *
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 *
 * copyright (c) 2020
 *
 */

package drivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import utils.MiscUtils;

/** MapReduce program for Most Used Words in Wikipedia articles.
 * This will output the words with highest count of use.
 */

public class MostUsedWords {

    /** Setting up the job for most used words.
     *
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        /** Create a configuration for the job
         */

        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length != 2) {
            System.err.println("Usage: EnhancedTopN <in> <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf);
        job.setJobName("Top N Enhanced");

        /**Set relevant jar were class specified as it's
         * parameter is present as part of that jar.
         */

        job.setJarByClass(MostUsedWords.class);

        /** Set name of Mapper and Reducer class to
         * MostUsedWords.class
         */

        job.setMapperClass(mappers.WordCountMapper.class);
        job.setReducerClass(reducers.TopValuesReducer.class);

        /** Specify the data type of of output key and value
         */

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        /** Setting input and output directories using command line arguments.
         * arg[0] = name of input directory on HDFS
         * arg[1] =  name of output directory to be created to store the output file
         */

        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
