package com.example.tgaleev.repos;

import com.example.tgaleev.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {

}
