package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

    @Controller
public class HomeController {
    @Autowired
    MessageRepository messageRepository;
    @RequestMapping("/")
    public String listMessage(Model model){
        model.addAttribute("messages", messageRepository.findAll());
        return "list";
    }
//    Add a platform to allow user to inout a message
    @GetMapping("/add")
    public String messageForm(Model model){
        model.addAttribute("message", new Message());
        return "messageform";
    }
//    Take the input and store it
    @PostMapping("/process")
    public String processForm(@Valid Message message,
                              BindingResult result){
        if(result.hasErrors()){
            return "messageform";
        }
        messageRepository.save(message);
        return "redirect:/";
    }
//    Creates a details model for user to lookup details of their posts
    @RequestMapping("/detail/{id}")
    public String showMessage(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("message", messageRepository.findById(id).get());
        return "show";
    }
//    User can make editions of their posts
    @RequestMapping("/update/{id}")
    public String updateMessage(@PathVariable("id") long id, Model model){
        model.addAttribute("message", messageRepository.findById(id).get());
        return "messageform";
    }
    @RequestMapping("/delete/{id}")
    public String delMessage(@PathVariable("id")long id){
        messageRepository.deleteById(id);
        return "redirect:/";
    }
}

