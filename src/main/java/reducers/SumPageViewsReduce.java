/* MapReduce Program - file SumPageViewsReduce.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

package reducers;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/** Reducer class for MapReduce program
 * of SumPageViews.java
 */

public class SumPageViewsReduce extends
        Reducer<Text, LongWritable, Text, LongWritable> {

    /** Reduce Function
     * Aggregation of results.
     * Outputs the total views for all Wikipedia
     * articles for certain period.
     *
     * @param key is the date from dump files of Wikipedia articles.
     * @param values is the view count of Wikipedia articles.
     * @param context is the map containing summary of data.
     * @throws IOException if reduce cannot be written or closed.
     * @throws InterruptedException if interrupted while processing.
     */

    public void reduce(Text key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException {

        // returns the total views of Wikipedia articles
        long views = 0;
        for (LongWritable t : values) {
            views += t.get();
        }
        context.write(new Text("Total_view"), new LongWritable(views));
    }
}