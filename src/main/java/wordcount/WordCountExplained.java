package wordcount;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path; //to manage the HDFS files
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient; //to run the reduce job
import org.apache.hadoop.mapred.JobConf; //to run the reduce job
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner; //to run the reduce job


public class WordCountExplained extends Configured implements Tool {

    @Override
    public int run(String[] args) throws Exception {

        if (args.length != 2) {
            ToolRunner.printGenericCommandUsage(System.out);
            return -1;
        }

        //instantiate the job and name it
        JobConf conf = new JobConf(getConf(), wordcount.WordCountExplained.class);
        conf.setJobName(this.getClass().getName());

        //define files for input and output
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        //chose the maooer and the reducer
        conf.setMapperClass((WordMapper.class));
        conf.setReducerClass(SumReducer.class);

        //set key value for Map
        conf.setMapOutputKeyClass(Text.class);
        conf.setMapOutputValueClass(IntWritable.class);

        //set key value for Reduce
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        JobClient.runJob(conf);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new WordCountExplained(), args);
        System.exit(exitCode);
    }

}

