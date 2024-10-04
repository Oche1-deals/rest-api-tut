package com.example.apis.demo;

import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;
    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

//@RequestMapping(path = "/hello-world")
  //  public String helloWorld(){
    //    return "helloworld";
    //}

    @RequestMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorld(){
        return new HelloWorldBean("helloworld");
}

    @GetMapping(path = "/hello-world-intrenationalized")
    public  String helloWorldInternationalized(){
        Locale Locale =  LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null,"Default Message", Locale);
       // return "Hello world v2";
    }

}
