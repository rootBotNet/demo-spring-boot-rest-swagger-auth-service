package playground.v3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import playground.v2.service.MessageServiceV2;

import java.util.List;

@RestController
@RequestMapping("/v3")
public class MessageControllerV3 {

    private static final Logger log = LoggerFactory.getLogger(MessageControllerV3.class);

    @Autowired
    MessageServiceV2 messageServiceV2;

    @Secured("ROLE_USER")
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String find() {
        String greeting = messageServiceV2.getMessage();
        return greeting;
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public List<String> addMessage(@RequestParam String text){
        return messageServiceV2.addMessage(text);

    }

}
