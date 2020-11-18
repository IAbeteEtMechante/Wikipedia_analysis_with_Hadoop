package wordcount;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class WordMapper extends MapReduceBase
        implements Mapper<LongWritable, Text, Text, IntWritable> {

    /*
    Longwritable is the offset address
    Text is the data
    Text and IntWritable is the key value pair output
    In the case of a word coutn, the output is just (word, 1)
     */

    //below the Outputcollector is the output of map, that will become the input of Reduce

    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text,
            IntWritable> output, Reporter reporter) throws IOException {

        //first thing to do is to convert the input into string
        String inputString = value.toString();

        //then we break it into words
        for (String word : inputString.split("\\W+")) {
            if (word.length() > 0) {
                output.collect(new Text(word), new IntWritable(1));
            }
        }


    }
}
