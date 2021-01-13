package com.timzu.spring;

import com.timzu.spring.domain.Message;
import com.timzu.spring.repos.MessageRepo;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int ROW_PER_PAGE = 5;

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";

    }

    @PostMapping
    public String add(@RequestParam String text, Map<String, Object> model){
        Message message = new Message(text);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll ();
        model.put("messages", messages);
        return "main";
    }
}
