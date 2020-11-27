package drivers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mappers.WordCountMapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;
import reducers.TopValuesReducer;

public class MostUsedWordsTest {
    MapReduceDriver<Object, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;
    MapDriver<Object, Text, Text, IntWritable> mapDriver;
    ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;

    @Before
    public void setUp() {
        WordCountMapper mapper = new WordCountMapper();
        TopValuesReducer reducer = new TopValuesReducer();
        mapDriver = MapDriver.newMapDriver(mapper);
        reduceDriver = ReduceDriver.newReduceDriver(reducer);
        mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
    }

    @Test
    public void testMapper() throws IOException {
        mapDriver.withInput(new LongWritable(),
                new Text("hello my name is bonjour"
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
                        + " be name we the program like bonjour"));

        // example input
        mapDriver.withOutput(new Text("hello"), new IntWritable(1));
        mapDriver.withOutput(new Text("my"), new IntWritable(1));
        mapDriver.withOutput(new Text("name"), new IntWritable(1));
        mapDriver.withOutput(new Text("is"), new IntWritable(1));
        mapDriver.withOutput(new Text("bonjour"), new IntWritable(1));
        mapDriver.withOutput(new Text("this"), new IntWritable(1));
        mapDriver.withOutput(new Text("is"), new IntWritable(1));
        mapDriver.withOutput(new Text("a"), new IntWritable(1));
        mapDriver.withOutput(new Text("wordcount"), new IntWritable(1));
        mapDriver.withOutput(new Text("program"), new IntWritable(1));
        mapDriver.withOutput(new Text("we"), new IntWritable(1));
        mapDriver.withOutput(new Text("try"), new IntWritable(1));
        mapDriver.withOutput(new Text("to"), new IntWritable(1));
        mapDriver.withOutput(new Text("find"), new IntWritable(1));
        mapDriver.withOutput(new Text("the"), new IntWritable(1));
        mapDriver.withOutput(new Text("top"), new IntWritable(1));
        mapDriver.withOutput(new Text("20"), new IntWritable(1));
        mapDriver.withOutput(new Text("words"), new IntWritable(1));
        mapDriver.withOutput(new Text("in"), new IntWritable(1));
        mapDriver.withOutput(new Text("this"), new IntWritable(1));
        mapDriver.withOutput(new Text("document"), new IntWritable(1));
        mapDriver.withOutput(new Text("it"), new IntWritable(1));
        mapDriver.withOutput(new Text("should"), new IntWritable(1));
        mapDriver.withOutput(new Text("be"), new IntWritable(1));
        mapDriver.withOutput(new Text("words"), new IntWritable(1));
        mapDriver.withOutput(new Text("like"), new IntWritable(1));
        mapDriver.withOutput(new Text("words"), new IntWritable(1));
        mapDriver.withOutput(new Text("hello"), new IntWritable(1));
        mapDriver.withOutput(new Text("how"), new IntWritable(1));
        mapDriver.withOutput(new Text("are"), new IntWritable(1));
        mapDriver.withOutput(new Text("you"), new IntWritable(1));
        mapDriver.withOutput(new Text("you"), new IntWritable(1));
        mapDriver.withOutput(new Text("you"), new IntWritable(1));
        mapDriver.withOutput(new Text("you"), new IntWritable(1));
        mapDriver.withOutput(new Text("hello"), new IntWritable(1));
        mapDriver.withOutput(new Text("how"), new IntWritable(1));
        mapDriver.withOutput(new Text("are"), new IntWritable(1));
        mapDriver.withOutput(new Text("you"), new IntWritable(1));
        mapDriver.withOutput(new Text("document"), new IntWritable(1));
        mapDriver.withOutput(new Text("should"), new IntWritable(1));
        mapDriver.withOutput(new Text("try"), new IntWritable(1));
        mapDriver.withOutput(new Text("find"), new IntWritable(1));
        mapDriver.withOutput(new Text("find"), new IntWritable(1));
        mapDriver.withOutput(new Text("word1"), new IntWritable(1));
        mapDriver.withOutput(new Text("word2"), new IntWritable(1));
        mapDriver.withOutput(new Text("word3"), new IntWritable(1));
        mapDriver.withOutput(new Text("word4"), new IntWritable(1));
        mapDriver.withOutput(new Text("word5"), new IntWritable(1));
        mapDriver.withOutput(new Text("word6"), new IntWritable(1));
        mapDriver.withOutput(new Text("word7"), new IntWritable(1));
        mapDriver.withOutput(new Text("word8"), new IntWritable(1));
        mapDriver.withOutput(new Text("word9"), new IntWritable(1));
        mapDriver.withOutput(new Text("word10"), new IntWritable(1));
        mapDriver.withOutput(new Text("word11"), new IntWritable(1));
        mapDriver.withOutput(new Text("word12"), new IntWritable(1));
        mapDriver.withOutput(new Text("word13"), new IntWritable(1));
        mapDriver.withOutput(new Text("word14"), new IntWritable(1));
        mapDriver.withOutput(new Text("word15"), new IntWritable(1));
        mapDriver.withOutput(new Text("word16"), new IntWritable(1));
        mapDriver.withOutput(new Text("word17"), new IntWritable(1));
        mapDriver.withOutput(new Text("word18"), new IntWritable(1));
        mapDriver.withOutput(new Text("word19"), new IntWritable(1));
        mapDriver.withOutput(new Text("word20"), new IntWritable(1));
        mapDriver.withOutput(new Text("you"), new IntWritable(1));
        mapDriver.withOutput(new Text("find"), new IntWritable(1));
        mapDriver.withOutput(new Text("hello"), new IntWritable(1));
        mapDriver.withOutput(new Text("words"), new IntWritable(1));
        mapDriver.withOutput(new Text("try"), new IntWritable(1));
        mapDriver.withOutput(new Text("this"), new IntWritable(1));
        mapDriver.withOutput(new Text("should"), new IntWritable(1));
        mapDriver.withOutput(new Text("is"), new IntWritable(1));
        mapDriver.withOutput(new Text("how"), new IntWritable(1));
        mapDriver.withOutput(new Text("are"), new IntWritable(1));
        mapDriver.withOutput(new Text("document"), new IntWritable(1));
        mapDriver.withOutput(new Text("a"), new IntWritable(1));
        mapDriver.withOutput(new Text("newword"), new IntWritable(1));
        mapDriver.withOutput(new Text("newword"), new IntWritable(1));
        mapDriver.withOutput(new Text("be"), new IntWritable(1));
        mapDriver.withOutput(new Text("name"), new IntWritable(1));
        mapDriver.withOutput(new Text("we"), new IntWritable(1));
        mapDriver.withOutput(new Text("the"), new IntWritable(1));
        mapDriver.withOutput(new Text("program"), new IntWritable(1));
        mapDriver.withOutput(new Text("like"), new IntWritable(1));
        mapDriver.withOutput(new Text("bonjour"), new IntWritable(1));
        mapDriver.runTest();
    }


    @Test
    public void testMapReduce() throws IOException {
        mapReduceDriver.withInput(new LongWritable(),
                new Text("hello my name is bonjour"
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
                        + " be name we the program like bonjour"));

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