package earth;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class mapper extends Mapper<LongWritable,Text,Text,DoubleWritable>
{
	public void map(LongWritable key,Text value,Context c)throws IOException,InterruptedException
	{
		String[] line= value.toString().split(",",12);
		if(line.length!=12)
		{
			return;
		}
		String mag=line[11];
		Double val=Double.parseDouble(line[8]);
		c.write(new Text(mag),new DoubleWritable(val));
	}
}
