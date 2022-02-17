package word;

import java.io.*;
import java.util.StringTokenizer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>
{
	Text w=new Text();
	public void map(LongWritable key,Text value,OutputCollector<Text,IntWritable> o,Reporter e) throws IOException
	{
		String s=value.toString();
		StringTokenizer t=new StringTokenizer(s);
		while(t.hasMoreTokens())
		{
			w.set(t.nextToken());
			 o.collect(new Text(w),new IntWritable(1));
		}
		
	}
}
