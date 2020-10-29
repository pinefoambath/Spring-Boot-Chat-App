package com.rollmops.demo.controller;

import com.rollmops.demo.model.ChatForm;
import com.rollmops.demo.service.MessageService;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// we need to tell it that this controller serves this request path:
// this is the mapping that the below controller is responsible for
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    // we declare a ChatForm object, which allows the app to initialise a POJO for the form backend
    public String getChatPage(ChatForm chatForm, Model model) {
        // we add the chat messages already stored to the model
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        // tell it to go to the/chat page
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model) {
        // we pass the entire form to the addMessage service
        this.messageService.addMessage(chatForm);
        // then we clear the message text of the form
        chatForm.setMessageText("");
        // and then we update the list of chat messages in the model
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        // tell it to go to the/chat page
        return "chat";
    }

     //
    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () { return new String [] { "Say", "Shout", "Whisper"}; }
}
