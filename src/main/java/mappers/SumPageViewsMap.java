package mappers;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SumPageViewsMap extends Mapper<LongWritable, Text, Text, LongWritable> {

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