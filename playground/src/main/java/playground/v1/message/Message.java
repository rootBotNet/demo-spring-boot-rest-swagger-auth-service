package playground.v1.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Message {

    @Value("${message.api.v1.greeting}")
    private String apiGreeting;

    public String getMessage() {

        System.out.println();
        return apiGreeting;
    }

    public List<String> messageList = new ArrayList<>();

    public List<String> addMessage(String message) {
        messageList.add(message);
        return messageList;
    }

}
