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
import reducers.WordCountReducer;

public class WikiMostUsedWordsTest {

}