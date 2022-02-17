package odd;
import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable>
{
	public void reduce(Text key,Iterator<IntWritable> value,OutputCollector<Text,IntWritable> o,Reporter r) throws IOException
	{
		String k=key.toString();
		if(k=="Even")
		{
			int esum=0;
			int ec=0;
			while(value.hasNext())
			{
				esum += value.next().get();
				ec++;
			}
			o.collect(key,new IntWritable(esum));
			o.collect(key,new IntWritable(ec));
		}
		else
		{
                        int osum=0;
                        int oc=0;
                        while(value.hasNext())
                        {       
                                osum += value.next().get();
                                oc++;   
                        }       
                        o.collect(key,new IntWritable(osum));
                        o.collect(key,new IntWritable(oc));
                }
	}
}	
