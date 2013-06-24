package com.bonesdev.webtrack;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class WebTrackMapper extends MapReduceBase implements Mapper {
	
	private static final IntWritable one = new IntWritable(1);
	private Text word = new Text();
	private static final Log LOG = LogFactory.getLog(WebTrackMapper.class);
	
	public void map(WritableComparable key, Text values,
			OutputCollector output, Reporter reporter) throws IOException {
		String line = values.toString();
		StringTokenizer itr  = new StringTokenizer(line);
		LOG.info(line);
		while (itr.hasMoreTokens()) {
			word.set(itr.nextToken());
			output.collect(word, one);
		}
 	}

	@Override
	public void map(Object arg0, Object arg1, OutputCollector arg2,
			Reporter arg3) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
