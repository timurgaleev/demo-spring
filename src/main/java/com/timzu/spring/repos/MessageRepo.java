package com.timzu.simple.repos;

import com.timzu.simple.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {

}
