package cn.jhsoft.bigdata.storm.my.stream.bolt;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.Map;

/**
 * Created by maoxiangyi on 2016/4/26.
 */
public class SplitBolt extends BaseBasicBolt {
    @Override
    public void prepare(Map stormConf, TopologyContext context) {
    }

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        String message = input.getString(0);
        if (message.contains("1")){
            collector.emit("number-stream",new Values(message));
        }
        if (message.contains("t")){
            collector.emit("string-stream",new Values(message));
        }
        if (message.contains("!")){
            collector.emit("sing-stream",new Values(message));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream("string-stream", new Fields("String"));
        declarer.declareStream("sign-stream", new Fields("sing"));
        declarer.declareStream("number-stream", new Fields("number"));
    }
}
