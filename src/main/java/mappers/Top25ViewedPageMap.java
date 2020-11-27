/* MapReduce Program - file Top25ViewedPageMap.java
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

/** Mapper class for MapReduce Program
 * of Top25ViewedPageDriver.java
 */

public class Top25ViewedPageMap extends Mapper<LongWritable, Text, Text, LongWritable> {

    /** Map Function
     * Maps every input to record total page views.
     *
     * @param key is the title of Wikipedia article.
     * @param value is the total page view of Wikipedia article.
     * @param context is the map of article title and its view count.
     * @throws IOException if map cannot be written or closed.
     * @throws InterruptedException if interrupted while processing.
     */

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String delims = " ";
        String[] wikiData = StringUtils.split(value.toString(), delims);
        Text article = new Text(wikiData[0]);
        LongWritable views = new LongWritable(Long.parseLong(wikiData[2]));
        context.write(article, views);
    }
}
