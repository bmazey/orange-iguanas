package org.columbia.controller;

import org.columbia.dto.TextDto;
import org.columbia.entity.TextEntity;
import org.columbia.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("api")
public class DemoController {

    /**
     * Spring controllers! opening development branch ...
     */

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getGreeting() {
        return new ResponseEntity<String>("hello!", HttpStatus.OK);
    }

    @RequestMapping(value = "/greeting/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getGreetingById(@PathVariable UUID id) {
        TextEntity entity = demoService.getTextByID(id);
        return ResponseEntity.ok(demoService.convertTextEntityToTextIdDto(entity));
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> postGreeting(@RequestBody TextDto text) {
        TextEntity entity = demoService.createText(demoService.convertTextDtoToTextEntity(text));
        return ResponseEntity.ok(demoService.convertTextEntityToTextIdDto(entity));
    }

    @RequestMapping(value= "/mariko", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getMarikoGreeting() {
        System.out.println("Hello from Mariko! (inside Spring)");

        TextDto greeting = new TextDto();
        greeting.setContent("hello from Mariko!");

        return ResponseEntity.ok(greeting);
    }

}
