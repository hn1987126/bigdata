package cn.jhsoft.bigdata.storm.wordcount;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen on 2017/7/23.
 */
public class MyBoltCount extends BaseRichBolt {

    OutputCollector collector;

    Map<String, Integer> map = new HashMap<String, Integer>();

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }

    /**
     * 获取 MyBolt类里射进来的 (word，10）  这样的数据
     * @param tuple
     */
    @Override
    public void execute(Tuple tuple) {
        String word = tuple.getString(0);
        Integer num = tuple.getInteger(1);

        if (map.containsKey(word)){
            map.put(word, map.get(word) + num);
        }else{
            map.put(word, num);
        }
        //System.out.println("count:"+map);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        // 最后一步了，可以不用处理
        //System.out.println("End");
    }
}
