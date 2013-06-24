package com.bonesdev.webtrack;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class WebTrackMapper extends MapReduceBase implements Mapper<WritableComparable, Text, Text, IntWritable> {
	
	private static final IntWritable one = new IntWritable(1);
	private Text word = new Text();
	private static final Log LOG = LogFactory.getLog(WebTrackMapper.class);
	
	public void map(WritableComparable key, Text values,
			OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
		String line = values.toString();
		Date d = new Date(new Long( line.split(",")[7]) * 1000);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		LOG.info(format.format(d));
		output.collect(new Text(format.format(d)), one);
 	}

}
