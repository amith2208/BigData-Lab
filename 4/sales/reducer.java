package sales;

import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable>
{
	public void reduce(Text key,Iterator<IntWritable> value,OutputCollector<Text,IntWritable> o,Reporter r) throws IOException
	{
		String k =key.toString();
		if(k.charAt(0)=='c')
		{
			int sum=0;
			while(value.hasNext())
			{
				sum += value.next().get();
			}
			o.collect(key,new IntWritable(sum));
		}
		else
		{
			int c=0;
			while(value.hasNext())
			{
				c += value.next().get();
			}
			o.collect(key,new IntWritable(c));
		}
	}
}
