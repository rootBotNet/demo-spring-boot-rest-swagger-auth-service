package playground.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import playground.v1.message.Message;

import java.util.List;

@Component
public class DefaultMessage implements MessageService {

    @Autowired
    Message message;

    @Override
    public String getMessage() {
        return message.getMessage();
    }

    public List<String> addMessage(String text) {
        List<String> messageList = message.addMessage(text);
        return messageList;
    }
}
