package com.yiwei.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;
import java.util.Iterator;

/**
 * Created by yizhao on 3/16/2018.
 */
public class WordCountRecuder extends Reducer<Text,IntWritable,Text,IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        super.reduce(key, values, context);

        int sum = 0;
        Iterator<IntWritable> valuesIt = values.iterator();
        while (valuesIt.hasNext()){
            sum = sum + valuesIt.next().get();
        }
        context.write(key,new IntWritable(sum));

    }
}
