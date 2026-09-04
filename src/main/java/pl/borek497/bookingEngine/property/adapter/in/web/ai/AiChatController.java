package pl.borek497.bookingEngine.property.adapter.in.web.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.borek497.bookingEngine.property.adapter.in.ai.PropertySearchTool;

@RestController
@RequestMapping("/ai")
class AiChatController {

    private final ChatClient chatClient;
    private final PropertySearchTool tool;

    public AiChatController(ChatClient.Builder chatClientBuilder, PropertySearchTool tool) {
        this.chatClient = chatClientBuilder.build();
        this.tool = tool;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody AiChatRequest request) {
        return chatClient
                .prompt()
                .user(request.message())
                .tools(tool)
                .call()
                .content();
    }

//    @PostMapping("/test")
//    public String testChat2() {
//        return chatClient
//                .prompt()
//                .user("Znajdź mi hotel w Serocku")
//                .options(OllamaChatOptions.builder().disableThinking().numPredict(64))
//                .call()
//                .content();
//    }
}
