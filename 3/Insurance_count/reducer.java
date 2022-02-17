package insurance;

import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable>
{
	public void reduce(Text key,Iterator<IntWritable> value,OutputCollector<Text,IntWritable> o,Reporter r) throws IOException
	{
		int c=0;
		while(value.hasNext())
		{
			c += value.next().get();
		}
		o.collect(key,new IntWritable(c));
	}
}
