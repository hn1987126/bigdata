package cn.jhsoft.bigdata.storm.wordcount;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.Map;

/**
 * Created by chen on 2017/7/23.
 */
public class MyBolt extends BaseRichBolt {

    OutputCollector collector;

    // 初始化方法
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }

    /**
     * storm框架在while(true) 调用nextTuple方法（Tuple是元组的意思，很多元素的组合）
     * 输入参数是上一个 的输出
     *
     * @param tuple
     */
    @Override
    public void execute(Tuple tuple) {

        // 取MySpout里定义的  collector.emit(new Values("i am lilei love hanmeimei"));  的第一个values
        String line = tuple.getString(0);
        // 或者这样取
        //line = tuple.getStringByField("love")

        // 切割
        String[] arrWords = line.split(" ");
        for (String word : arrWords){
            collector.emit(new Values(word, 1));
            System.out.println(word);
        }

    }



    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word", "num"));
    }
}
