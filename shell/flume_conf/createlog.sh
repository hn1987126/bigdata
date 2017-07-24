#!/bin/bash
for((i=0;i<=50000;i++));
    do echo "message-"+$i >>/export/data/flume_sources/log/test.log;
done