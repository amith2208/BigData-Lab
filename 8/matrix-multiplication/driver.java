package matrix;

import java.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.*;

public class driver
{
	public static void main(String args[]) throws Exception
	{
		Configuration c =new Configuration();
		c.set("m","2");
		c.set("n","5");
		c.set("p","3");
		Job j=Job.getInstance(c,"driver");
		j.setJarByClass(driver.class);
		j.setMapperClass(mapper.class);
		j.setReducerClass(reducer.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(j,new Path(args[0]));
		FileOutputFormat.setOutputPath(j,new Path(args[1]));
		j.waitForCompletion(true);
	}
}

