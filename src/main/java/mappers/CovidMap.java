/* MapReduce Program - file CovidMap.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

package mappers;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/** Mapper class for MapReduce program
 * of CovidDriver.java
 */

public class CovidMap extends Mapper<LongWritable, Text, Text, LongWritable> {

    /** Map Function
     * Maps every input to record one.
     *
     * @param key is the date from dump files of Wikipedia articles.
     * @param value is the view count of Covid related Wikipedia articles.
     * @param context is the map containing date and corresponding view count
     *                for a certain date.
     * @throws IOException if map cannot be written or closed.
     * @throws InterruptedException if interrupted while processing.
     */

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String delims = ",";
        String[] wikiData = StringUtils.split(value.toString(), delims);
        Text date = new Text(wikiData[1]);
        LongWritable views = new LongWritable(Long.parseLong(wikiData[2]));
        context.write(date, views);
    }
}
