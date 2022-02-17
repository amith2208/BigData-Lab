package word;

import java.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class driver
{
	public static void main(String args[]) throws Exception
	{
		JobConf c=new JobConf(driver.class);
		c.setMapperClass(mapper.class);
		c.setReducerClass(reducer.class);
		c.setOutputKeyClass(Text.class);
		c.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(c,new Path(args[0]));
		FileOutputFormat.setOutputPath(c,new Path(args[1]));
		JobClient.runJob(c);
	}
}
