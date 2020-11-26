/* MapReduce Program - file WordCount.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

package drivers;

import mappers.WordCountMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import reducers.WordCountReducer;

/** MapReduce program for Word Count in a Wikipedia article.
 * This will output the total word count in a Wikipedia article.
 */

public class WordCount {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage:<inputpath><outputpath>");
            System.exit(-1);
        }

        /* Create a configuration for the job
         */

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "wordcount");

        /* Set relevant jar were class specified as it's
         * parameter is present as part of that jar.
         */

        job.setJarByClass(WordCount.class);

        /* Set name of Mapper to WordCountMapper.class
         * and Reducer class to WordCountReducer.class.
         */

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        /* Specify the data type of of output key and value
         */

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        /* Setting input and output directories using command line arguments.
         * arg[0] = name of input directory on HDFS
         * arg[1] =  name of output directory to be created to store the output file
         */

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
