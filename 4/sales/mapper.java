package sales;

import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>
{
	private static final IntWritable one=new IntWritable(1);
	public void map(LongWritable key,Text value,OutputCollector<Text,IntWritable> o,Reporter r) throws IOException
	{
		String[] l=value.toString().split(",");
		if(l[0].equals("Transaction_date"))
		{
			return; //header of csv
		}
		String c="country"+l[7];
		int p=Integer.parseInt(l[2]);
		String pro="Product"+l[1];
		o.collect(new Text(c),new IntWritable(p));
		o.collect(new Text(pro),one);
	}
}

