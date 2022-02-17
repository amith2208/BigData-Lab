package sales;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.fs.Path;

public class driver
{
	public static void main(String args[]) throws Exception
	{
		JobConf j=new JobConf(driver.class);
		j.setMapperClass(mapper.class);
		j.setReducerClass(reducer.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(j,new Path(args[0]));
		FileOutputFormat.setOutputPath(j,new Path(args[1]));
		JobClient.runJob(j);
	}
}
