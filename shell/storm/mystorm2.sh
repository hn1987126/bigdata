#!/bin/bash
nohup /export/servers/storm/bin/storm supervisor >/dev/null 2>&1 &
nohup /export/servers/kafka/bin/kafka-server-start.sh  /export/servers/kafka/config/server.properties >/dev/null 2>&1 &
