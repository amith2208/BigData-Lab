package word;

import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable>
{
	public void reduce(Text key,Iterator<IntWritable> value,OutputCollector<Text,IntWritable> o,Reporter h) throws IOException
	{
		int c=0;
		while(value.hasNext())
		{
			c+= value.next().get();
		}
		o.collect(key,new IntWritable(c));
	}
}
