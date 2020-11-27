/* MapReduce Program - file SumPageViewsMap.java
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
 * of SumPageViews.java
 */

public class SumPageViewsMap extends Mapper<LongWritable, Text, Text, LongWritable> {

    /** Map Function
     * Maps every input to record sum of page views.
     *
     * @param key is the title of Wikipedia articles.
     * @param value is the view count of Wikipedia articles.
     * @param context is the map of article title and its view count.
     * @throws IOException if map cannot be written or closed.
     * @throws InterruptedException if interrupted while processing.
     */

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String delims = ",";
        String[] wikiData = StringUtils.split(value.toString(), delims);
        Text article = new Text();
        LongWritable views = new LongWritable(Long.parseLong(wikiData[1]));
        context.write(article, views);
    }
}
