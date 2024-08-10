package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generaTopic(){

        Map<String,String>configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); //Borrar mensajes despues de un determinado tiempo
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); //Tiempo de retención de mensajes especificado en milisegundos
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); //Tamaño máximo del segmento en Bytes
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // Tamaño maximo de mensajes en Bytes
            return TopicBuilder.name("topic-example")
                    .partitions(2)
                    .replicas(2)
                    .configs(configurations)
                    .build();
        }

}
