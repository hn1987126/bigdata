#!/bin/bash
cat >> /etc/profile << EOF

export KAFKA_HOME=/export/servers/kafka
export PATH=$PATH:$KAFKA_HOME/bin

export STORM_HOME=/export/servers/storm
export PATH=$PATH:$STORM_HOME/bin

export ZK_HOME=/home/hadoop/apps/zookeeper-3.4.5
export PATH=$PATH:$ZK_HOME/bin

export HIVE_HOME=/home/hadoop/apps/hive
export PATH=$PATH:$HIVE_HOME/bin

EOF