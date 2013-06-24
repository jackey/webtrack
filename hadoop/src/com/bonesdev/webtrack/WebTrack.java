package com.bonesdev.webtrack;

import java.io.File;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WebTrack extends Configured implements Tool{
	public static void main(String[] args) throws Exception{
		int res = ToolRunner.run(new Configuration(), new WebTrack(), args);
		System.exit(res);
	}

	@Override
	public int run(String[] args) throws Exception {
		String pwd = new File(".").getCanonicalPath().toString();
		JobConf conf = new JobConf(this.getConf(), WebTrack.class);
		
		conf.setJobName("WebTrack");
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
		conf.setMapperClass(WebTrackMapper.class);
		conf.setCombinerClass(WebTrackReducer.class);
		conf.setReducerClass(WebTrackReducer.class);
		
		conf.setNumMapTasks(3);
		conf.setNumReduceTasks(1);
		
		FileInputFormat.addInputPaths(conf, pwd + "/data/node.csv");
		FileOutputFormat.setOutputPath(conf, new Path(pwd + "/out"));
		
		JobClient.runJob(conf);
		return 0;
	}
}