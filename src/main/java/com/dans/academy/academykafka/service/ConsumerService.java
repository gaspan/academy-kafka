package com.dans.academy.academykafka.service;

import com.dans.academy.academykafka.model.AcademyTransaction;
import com.dans.academy.academykafka.repositories.AcademyRepositories;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConsumerService {
    public final AcademyRepositories academyRepositories;

    @KafkaListener(topics = "topic-kafka", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consumer(String message){
        log.info("Event consumed with contents : {}", message);
        AcademyTransaction academyTransaction = new AcademyTransaction();
        academyTransaction.setSource("kafka");
        academyTransaction.setCreated_by("kafka");
        academyTransaction.setCreated_at(String.valueOf(new Date()));
        academyRepositories.save(academyTransaction);
    }
}
