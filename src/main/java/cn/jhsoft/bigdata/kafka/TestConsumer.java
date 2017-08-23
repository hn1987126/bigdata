package cn.jhsoft.bigdata.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

public class TestConsumer {
    public static void main(String[] args) {

        String topic = "wifi7";
        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(createConsumerConfig());
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream =  consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while(it.hasNext()) {
            MessageAndMetadata<byte[], byte[]> mam = it.next();
            if (mam != null) {
                String msg = new String(mam.message());
                //JSONObject jobj= JSON.parseObject(msg);
                //String mac=jobj.get("mac").toString();
                //String cookieid = msg.split("\\|")[1];
                //int testPartition = Math.abs(mac.hashCode()) % 4;
                // 在哪个分区上：mam.partition()
                System.out.println("consume: Partition [" + mam.partition() + "] ["+msg+"]");
            }
        }

    }

    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        props.put("group.id","group_lxw_test1");
        props.put("zookeeper.connect","116.196.88.60:2181,116.196.88.61:2181,116.196.88.62:2181");
        props.put("zookeeper.session.timeout.ms", "4000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");
        return new ConsumerConfig(props);
    }
}