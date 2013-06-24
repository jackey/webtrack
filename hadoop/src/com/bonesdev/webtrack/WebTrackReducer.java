package com.bonesdev.webtrack;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class WebTrackReducer extends MapReduceBase implements Reducer<WritableComparable, IntWritable, WritableComparable, IntWritable> {
	
	@Override
	public void reduce(WritableComparable key, Iterator<IntWritable> values,
			OutputCollector<WritableComparable, IntWritable> output, Reporter reporter) throws IOException {
		int sum = 0;
		while (values.hasNext()) {
			sum += values.next().get();
		}
		output.collect(key, new IntWritable(sum));
	}

}
