package playground.v2.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageV2 {

    @Value("${message.api.v2.greeting}")
    private String apiGreeting;

    public List<String> messageList = new ArrayList<>();

    public String getMessage() {

        System.out.println();
        return apiGreeting;
    }

    public List<String> addMessage(String message) {
        messageList.add(message);
        return messageList;
    }

}
