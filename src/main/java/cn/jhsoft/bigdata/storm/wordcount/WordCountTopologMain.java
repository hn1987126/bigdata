package cn.jhsoft.bigdata.storm.wordcount;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

/**
 * Created by chen on 2017/7/23.
 */
public class WordCountTopologMain {

    public static void main(String[] args) throws Exception {
        // 准备一个TopologyBuilder
        TopologyBuilder topologyBuilder = new TopologyBuilder();
        topologyBuilder.setSpout("mySpout", new MySpout(), 2);
        topologyBuilder.setBolt("myBolt", new MyBolt(), 2).shuffleGrouping("mySpout");
        topologyBuilder.setBolt("myBolt1", new MyBoltCount(), 4).fieldsGrouping("myBolt", new Fields("word"));

        // 创建configuration,用来指定当前topology需要的worker数量
        Config config = new Config();
        config.setNumWorkers(2);

        //3、提交任务  -----两种模式 本地模式和集群模式
        if (args.length>0) {
            StormSubmitter.submitTopology(args[0], config, topologyBuilder.createTopology());
        }else {
            LocalCluster localCluster = new LocalCluster();
            localCluster.submitTopology("mywordcount", config, topologyBuilder.createTopology());
        }
    }

}
