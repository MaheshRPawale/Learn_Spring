package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MyDemoController {
   
   @GetMapping("/demo")
   public String myDemo() {
       return "This is demo controller - we created a controller object";
   }
}