package com.yiwei.hadoop;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * Created by yizhao on 3/16/2018.
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
    //one and word are the key/value pair
    private final static IntWritable one  = new IntWritable(1);
    private Text word = new Text();

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        StringTokenizer st = new StringTokenizer(line," ");

        while(st.hasMoreTokens()){
            word.set(st.nextToken());
            context.write(word,one);
        }


    }
}
