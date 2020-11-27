import java.io.IOException;
import mappers.Top25ViewedPageMap;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;
import reducers.CovidReduce;

public class Top25ViewedPageTest {
    MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable> mapReduceDriver;
    MapDriver<LongWritable, Text, Text, LongWritable> mapDriver;
    ReduceDriver<Text, LongWritable, Text, LongWritable> reduceDriver;

    @Before
    public void setUp() {
        Top25ViewedPageMap mapper = new Top25ViewedPageMap();
        CovidReduce reducer = new CovidReduce();
        mapDriver = MapDriver.newMapDriver(mapper);
        reduceDriver = ReduceDriver.newReduceDriver(reducer);
        mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
    }

    @Test
    public void testMapper() throws IOException {
        mapDriver.withInput(new LongWritable(1), new Text(
                "Donald_Trump 20201115 1660915"));
        mapDriver.withInput(new LongWritable(1), new Text(
                "Donald_Trump 20201116 1833827"));
        mapDriver.withInput(new LongWritable(1), new Text(
                "Diana,_Princess_of_Wales 20201116 532204"));
        mapDriver.withInput(new LongWritable(1), new Text(
                "Diana,_Princess_of_Wales 20201115 386834"));

        mapDriver.withOutput(new Text("Donald_Trump"), new LongWritable(1660915));
        mapDriver.withOutput(new Text("Donald_Trump"), new LongWritable(1833827));
        mapDriver.withOutput(new Text("Diana,_Princess_of_Wales"), new LongWritable(532204));
        mapDriver.withOutput(new Text("Diana,_Princess_of_Wales"), new LongWritable(386834));

        mapDriver.runTest();
    }

    @Test
    public void testMapReduce() throws IOException {
        mapReduceDriver.withInput(new LongWritable(1), new Text(
                "Donald_Trump 20201115 1660915"));
        mapReduceDriver.withInput(new LongWritable(1), new Text(
                "Donald_Trump 20201116 1833827"));
        mapReduceDriver.withInput(new LongWritable(1), new Text(
                "Diana,_Princess_of_Wales 20201116 532204"));
        mapReduceDriver.withInput(new LongWritable(1), new Text(
                "Diana,_Princess_of_Wales 20201115 386834"));
        mapReduceDriver.withOutput(new Text("Diana,_Princess_of_Wales"), new LongWritable(919038));
        mapReduceDriver.withOutput(new Text("Donald_Trump"), new LongWritable(3494742));

        mapReduceDriver.runTest();
    }
}