API com foco em mandar informações do producer para consumer, envio de email com o SimpleEmailMessage

A API pode ser configurada para produzir e consumir mensagens de Kafka. Exemplo de configuração de Kafka no application.properties:

properties
Copiar código
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.consumer.group-id=group-id
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.key-serializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-serializer=org.apache.kafka.common.serialization.StringDeserializer

Kafka
Certifique-se de ter o Kafka rodando na máquina local ou no servidor desejado. Para rodar o Kafka localmente, basta seguir os seguintes passos:

Inicie o Zookeeper:

bash
Copiar código
zookeeper-server-start.sh config/zookeeper.properties
Inicie o Kafka:

bash
Copiar código
kafka-server-start.sh config/server.properties
Crie o tópico necessário para a integração:

bash
Copiar código
kafka-topics.sh --create --topic your_topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
Executando a API Localmente
Clone o repositório para sua máquina local:

bash
Copiar código
git clone https://github.com/seu_usuario/sua_api.git
cd sua_api
Compile o projeto utilizando Maven:

bash
Copiar código
mvn clean install
Execute o aplicativo com o seguinte comando:

bash
Copiar código
mvn spring-boot:run
O servidor será iniciado na porta 8080 por padrão.
