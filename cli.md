# Instalation
KAFKA_CLUSTER_ID="$(./kafka-storage.sh random-uuid)"
<br>
./kafka-storage.sh  format -t $KAFKA_CLUSTER_ID -c ../config/kraft/server.properties 
# Start server
./kafka-server-start.sh ../config/kraft/server.properties
### start consumer
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my.first.topic
### start producer
./kafka-console-producer.sh --bootstrap-server localhost:9092 --topic my.first.topic
# Topics
./kafka-topics.sh --bootstrap-server localhost:9092 --list
<br>
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic my.new.topic
<br>
./kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic my.new.topic
<br>
./kafka-topics.sh --bootstrap-server localhost:9092 --alter --topic my.new.topic --partitions 3
<br>
./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic my.new.topic
<br>
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic cg.demo.topic --partitions 5
<br>
./kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic cg.demo.topic
# Consumer group
### start two consumers
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic cg.demo.topic  --group my.new.group
<br>
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic cg.demo.topic  --group my.new.group
### consumer groups
./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
<br>
./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my.new.group
<br>
./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my.new.group --state
<br>
./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my.new.group --members

