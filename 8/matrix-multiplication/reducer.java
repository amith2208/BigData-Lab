package matrix;

import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapreduce.*;

public class reducer extends Reducer<Text,Text,Text,Text>
{
	public void reduce(Text key,Iterable<Text> value,Context c) throws IOException,InterruptedException
	{
		String[] v;
		HashMap<Integer,Float> A=new HashMap<Integer,Float>();
		HashMap<Integer,Float> B=new HashMap<Integer,Float>();

		for(Text val:value)
		{
			v=val.toString().split(",");
			if(v[0].equals("A"))
			{
				A.put(Integer.parseInt(v[1]),Float.parseFloat(v[2]));
			}
			else
			{       
                                B.put(Integer.parseInt(v[1]),Float.parseFloat(v[2]));
                        }
		}
		float result=0.0f;
		float a_ij,b_jk;
		int n=Integer.parseInt(c.getConfiguration().get("n"));
		for(int j=0;j<n;j++)
		{
			a_ij=A.containsKey(j) ? A.get(j):0.0f;
			b_jk=B.containsKey(j) ? B.get(j):0.0f;
			result += a_ij*b_jk;
		}
		if(result!=0.0f)
		{
			c.write(null,new Text(key.toString() +" :"+ Float.toString(result)));
		}
	}
}	
