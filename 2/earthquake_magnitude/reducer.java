package earth;
import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class reducer extends Reducer<Text,DoubleWritable,Text,DoubleWritable>
{
	public void reduce(Text key,Iterable<DoubleWritable> value,Context c) throws IOException,InterruptedException
	{
		double sum=0;
		for(DoubleWritable v:value)
		{
			sum += v.get();
		}
		c.write(key,new DoubleWritable(sum));
	}
}
