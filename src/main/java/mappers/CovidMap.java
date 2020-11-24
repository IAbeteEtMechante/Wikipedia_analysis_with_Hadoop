package mappers;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

    public class CovidMap extends Mapper<LongWritable, Text, Text, LongWritable> {

        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String delims = ",";
            String[] wikiData = StringUtils.split(value.toString(), delims);
            Text date = new Text(wikiData[1]);
            LongWritable views = new LongWritable(Long.parseLong(wikiData[2]));
            context.write(date, views);
        }
    }

