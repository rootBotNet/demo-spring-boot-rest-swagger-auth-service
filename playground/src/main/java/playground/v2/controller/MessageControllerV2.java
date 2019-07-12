package playground.v2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import playground.v2.service.MessageServiceV2;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class MessageControllerV2 {

    private static final Logger log = LoggerFactory.getLogger(MessageControllerV2.class);

    @Autowired
    MessageServiceV2 messageServiceV2;

    @Secured("ROLE_USER")
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String find() {
        String greeting = messageServiceV2.getMessage();
        return greeting;
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/message/{text}", method = RequestMethod.POST)
    public List<String> addMessage(@PathVariable String text){
        return messageServiceV2.addMessage(text);

    }

}
