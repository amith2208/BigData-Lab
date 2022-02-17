package earth;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class driver
{
	public static void main(String args[]) throws Exception
	{
		Job j=Job.getInstance();
		j.setJarByClass(driver.class);
		j.setMapperClass(mapper.class);
		j.setReducerClass(reducer.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(DoubleWritable.class);
		FileInputFormat.addInputPath(j,new Path(args[0]));
		FileOutputFormat.setOutputPath(j,new Path(args[1]));

		j.waitForCompletion(true);
	}
}
