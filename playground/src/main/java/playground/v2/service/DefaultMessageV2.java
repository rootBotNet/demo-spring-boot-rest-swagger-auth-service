package playground.v2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import playground.v2.message.MessageV2;

import java.util.List;

@Component
public class DefaultMessageV2 implements MessageServiceV2 {

    @Autowired
    MessageV2 messageV2;

    @Override
    public String getMessage() {
        return messageV2.getMessage();
    }

    public List<String> addMessage(String text) {
        List<String> messageList = messageV2.addMessage(text);
        return messageList;
    }
}
