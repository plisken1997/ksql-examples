# Kafka KSQL examples

## monitoring:
  - https://github.com/framiere/monitoring-demo
  - https://github.com/yahoo/kafka-manager
### kafka manager
[configure](https://github.com/yahoo/kafka-manager#configuration) and [deploy](https://github.com/yahoo/kafka-manager#deployment)

  run
  ```bash
  
    bin/kafka-manager -Dconfig.file=/path/to/conf/application.conf
  ```

## install

### from docker
https://docs.confluent.io/current/installation/docker/docs/quickstart.html

### from confluent applications
https://docs.confluent.io/current/installation/installing_cp/index.html

## CLI 

run confluent platform
```bash
  bin/confluent start
```

list topic

```bash
  bin/kafka-topics --list --zookeeper localhost:2181
```

producer

```bash
  bin/kafka-console-producer --broker-list "localhost:9092" --topic "ksqlexamples.show-opinions"  
```

## KSQL

offset

```
  SET 'auto.offset.reset' = 'earliest';
```

### k-streams


### k-table
