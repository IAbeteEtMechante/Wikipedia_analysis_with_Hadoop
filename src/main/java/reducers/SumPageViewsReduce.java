package reducers;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SumPageViewsReduce extends
        Reducer<Text, LongWritable, Text, LongWritable> {
    public void reduce(Text key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException {
        long views = 0;
        for (LongWritable t : values) {
            views += t.get();
        }
        context.write(new Text("Total_view"), new LongWritable(views));
    }
}