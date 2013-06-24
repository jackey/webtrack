package com.bonesdev.webtrack;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class WebTrackReducer extends MapReduceBase implements Reducer {

	public void reduce(WritableComparable key, Iterator<IntWritable> values,
			OutputCollector output, Reporter reporter) throws IOException {
		int sum = 0;
		while (values.hasNext()) {
			sum += values.next().get();
		}
		output.collect(key, new IntWritable(sum));
	}

	@Override
	public void reduce(Object arg0, Iterator arg1, OutputCollector arg2,
			Reporter arg3) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
