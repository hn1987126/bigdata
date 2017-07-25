#!/bin/bash
nohup /export/servers/storm/bin/storm nimbus >/dev/null 2>&1 &
nohup /export/servers/storm/bin/storm ui >/dev/null 2>&1 &
nohup /export/servers/kafka/bin/kafka-server-start.sh  /export/servers/kafka/config/server.properties >/dev/null 2>&1 &

#ssh s2 /bin/bash /home/hadoop/mystorm.sh

#redis
/usr/local/bin/redis-server /usr/local/redis/etc/redis.conf