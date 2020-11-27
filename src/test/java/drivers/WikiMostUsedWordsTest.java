package drivers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mappers.WikiDumpMapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;
import reducers.TopValuesReducer;

public class WikiMostUsedWordsTest {
    MapReduceDriver<Object, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;
    MapDriver<Object, Text, Text, IntWritable> mapDriver;
    ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;

    @Before
    public void setUp() {
        WikiDumpMapper mapper = new WikiDumpMapper();
        TopValuesReducer reducer = new TopValuesReducer();
        mapDriver = MapDriver.newMapDriver(mapper);
        reduceDriver = ReduceDriver.newReduceDriver(reducer);
        mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
    }

    //add some xml tags and "'s"

    //add some xml tags and "'s"
    @Test
    public void testMapReduce() throws IOException {
        mapReduceDriver.withInput(new LongWritable(),
                new Text("<page> hello my name is bonjour"
                        + " this is a wordcount program "
                        + "we try to find the top 20 words "
                        + "in this document it should be "
                        + "words like words hello how are "
                        + "you you you you hello how are "
                        + "you document should try find find "
                        + "word1 word2 word3 word4 word5 "
                        + "word6 word7 word8 word9 word10 "
                        + "word11 word12 word13 word14 word15 "
                        + "word16 word17 word18 word19 word20 "
                        + "you find hello words try this should"
                        + " is how are document a newword newword"
                        + " be name we the program like's bonjour"));

        mapReduceDriver.withOutput(new Text("you"), new IntWritable(6));
        mapReduceDriver.withOutput(new Text("find"), new IntWritable(4));
        mapReduceDriver.withOutput(new Text("hello"), new IntWritable(4));
        mapReduceDriver.withOutput(new Text("words"), new IntWritable(4));
        mapReduceDriver.withOutput(new Text("try"), new IntWritable(3));
        mapReduceDriver.withOutput(new Text("this"), new IntWritable(3));
        mapReduceDriver.withOutput(new Text("should"), new IntWritable(3));
        mapReduceDriver.withOutput(new Text("is"), new IntWritable(3));
        mapReduceDriver.withOutput(new Text("how"), new IntWritable(3));
        mapReduceDriver.withOutput(new Text("are"), new IntWritable(3));
        mapReduceDriver.withOutput(new Text("document"), new IntWritable(3));
        mapReduceDriver.withOutput(new Text("a"), new IntWritable(2));
        mapReduceDriver.withOutput(new Text("be"), new IntWritable(2));
        mapReduceDriver.withOutput(new Text("name"), new IntWritable(2));
        mapReduceDriver.withOutput(new Text("we"), new IntWritable(2));
        mapReduceDriver.withOutput(new Text("the"), new IntWritable(2));
        mapReduceDriver.withOutput(new Text("program"), new IntWritable(2));
        mapReduceDriver.withOutput(new Text("like"), new IntWritable(2));
        mapReduceDriver.withOutput(new Text("newword"), new IntWritable(2));
        mapReduceDriver.withOutput(new Text("bonjour"), new IntWritable(2));
        mapReduceDriver.runTest();
    }
}