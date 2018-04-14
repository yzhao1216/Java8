package com.yiwei.hadoop;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * Created by yizhao on 3/16/2018.
 */
public class WordCount extends Configured implements Tool{

    public static void main(String[] args) throws Exception{
        int exitCode = ToolRunner.run(new WordCount(), args);
        System.exit(exitCode);
    }

    @Override
    public int run(String[] strings) throws Exception {
        Job job = new Job();
        job.setJarByClass(WordCount.class);
        job.setJobName("yiwei_WordCounter");

        FileInputFormat.addInputPath(job, new Path(strings[0]));
        FileOutputFormat.setOutputPath(job, new Path(strings[1]));

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountRecuder.class);

        int returnValue = job.waitForCompletion(true) ? 0 : 1;
        System.out.println("job.is successful" + job.isSuccessful());

        return returnValue;
    }
}

