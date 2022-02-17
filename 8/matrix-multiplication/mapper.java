package matrix;

import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.conf.*;

public class mapper extends Mapper<LongWritable,Text,Text,Text>
{
	public void map(LongWritable key,Text value,Context c) throws IOException,InterruptedException
	{
		Configuration co=c.getConfiguration();
		int m=Integer.parseInt(co.get("m"));
		int p=Integer.parseInt(co.get("p"));
		String[] l=value.toString().split(",");
		Text ok=new Text();
		Text ov=new Text();
		if(l[0].equals("A"))
		{
			for(int k=0;k<p;k++)
			{
				ok.set(l[1]+","+k);
				ov.set("A,"+l[2]+","+l[3]);
				c.write(ok,ov);
			}
		}
		else
		{
                        for(int i=0;i<m;i++)
                        {
                                ok.set(i+","+l[2]);
                                ov.set("B,"+l[1]+","+l[3]);
                                c.write(ok,ov);
                        }
                }
	}
}


