package insurance;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import java.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text,Text,IntWritable>
{
	private static final IntWritable one=new IntWritable(1);
	public void map(LongWritable key,Text value,OutputCollector<Text,IntWritable> output,Reporter r) throws IOException
	{
		String[] s=value.toString().split(",");
		String k=s[16];
		output.collect(new Text(k),one);
	}
}
