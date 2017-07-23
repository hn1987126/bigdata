package cn.jhsoft.bigdata.storm.wordcount;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

import java.util.Map;

/**
 * Created by chen on 2017/7/23.
 */
public class MySpout extends BaseRichSpout {

    SpoutOutputCollector collector;

    // 初始化方法
    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
    }

    // storm框架在while(true) 调用nextTuple方法（Tuple是元组的意思，很多元素的组合）
    @Override
    public void nextTuple() {
        collector.emit(new Values("i am lilei love hanmeimei"));
    }


    /**
     * 这里定义上面那一段话，指定一个名字，因为那话可以传两段，这里也可以指定两个名字，分别一一对应
     * 如上面nextTuple方法中， collector.emit(new Values("i am lilei love hanmeimei", "jd is my work"));
     * declareOutputFields 方法中，outputFieldsDeclarer.declare(new Fields("love", "jd"));
     * @param outputFieldsDeclarer
     */
    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("love"));
    }
}
