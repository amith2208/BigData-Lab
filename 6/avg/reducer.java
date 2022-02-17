package avg;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class reducer extends Reducer<Text,DoubleWritable,Text,DoubleWritable>
{
	public void reduce(Text key,Iterable<DoubleWritable> value,Context vc) throws IOException,InterruptedException
	{
		String k=key.toString();
		if(k=="M")
		{
			int c=0;
			double s=0;
			for(DoubleWritable a:value)
			{
				s += a.get();
				c++;
			}
			double avg=(double)(s/c);
			String t="Average Salary = ";
			vc.write(new Text(key +"-"+ t),new DoubleWritable(avg));
		}
		else
		 {       
                        int fc=0;
                        double fs=0;
                        for(DoubleWritable a:value)
                        {       
                                fs += a.get();
                                fc++;
                        }       
                        double favg=(double)(fs/fc);
                        String ft="Average Salary = ";
                        vc.write(new Text(key +"-"+ ft),new DoubleWritable(favg));
                }
	}
}
