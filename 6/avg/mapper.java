package avg;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class mapper extends Mapper<LongWritable,Text,Text,DoubleWritable>
{
	public void map(LongWritable key,Text value,Context c) throws IOException,InterruptedException
	{
		String[] l=value.toString().split("\\t");
		String s=l[3];
		double salary=Double.parseDouble(l[8]);
		c.write(new Text(s),new DoubleWritable(salary));
	}
}
