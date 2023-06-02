package com.chatproject.Controller;

//public class ChatController {
//
//}
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat") // Endpoint to receive incoming messages
    @SendTo("/topic/messages") // Destination to send the processed messages
    public ChatMessage handleMessage(ChatMessage message) {
        // Perform any necessary processing on the incoming message
        // For example, you might save it to a database or apply business logic

        // Return the processed message to be broadcasted to all subscribers
        return message;
    }
}

