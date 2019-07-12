package playground.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import playground.v1.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String find() {
        String greeting = messageService.getMessage();
        return greeting;
    }

    @RequestMapping(value = "/message/{text}", method = RequestMethod.POST)
    public List<String> addMessage(@PathVariable String text){
        return messageService.addMessage(text);

    }

}
