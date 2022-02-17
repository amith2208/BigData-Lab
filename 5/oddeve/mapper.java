package odd;

import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>
{
	public void map(LongWritable key,Text value,OutputCollector<Text,IntWritable> o,Reporter r) throws IOException
	{
		String[] d=value.toString().split(" ");
		for(String a:d)
		{
			int i=Integer.parseInt(a);
			if(i%2==0)
			{
				o.collect(new Text("Even"),new IntWritable(i));
			}
			else
			{
				o.collect(new Text("ODD"),new IntWritable(i));
			}
		}
	}
}
