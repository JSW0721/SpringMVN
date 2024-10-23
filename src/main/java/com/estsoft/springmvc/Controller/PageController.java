package com.estsoft.springmvc.Controller;

import com.estsoft.springmvc.DTO.person.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
public class PageController {
    //Person  GET/thymeleaf/example
    @GetMapping("/thymeleaf/example")
    public String show(Model model){
        Person person = new Person();
        person.setId(1L);
        person.setName("JYP");
        person.setAge(22);
        person.setHobbies(Arrays.asList("run","learn"));

        model.addAttribute("person", person);
        model.addAttribute("today", LocalDateTime.now());

        return "examplePage";
    }
}
