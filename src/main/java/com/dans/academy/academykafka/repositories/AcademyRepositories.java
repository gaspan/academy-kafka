package com.dans.academy.academykafka.repositories;

import com.dans.academy.academykafka.model.AcademyTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepositories extends CrudRepository<AcademyTransaction, Integer> {

}
