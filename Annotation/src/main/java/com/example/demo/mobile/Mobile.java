package com.example.demo.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mobilemethods.MobileInterface;

@Controller
@RequestMapping("/mobile")
@ResponseBody
public class Mobile {

    @Autowired 
    MobileInterface mobileInterface;
    
    @GetMapping("/wantmobile")
    public String newMobile() {
        return mobileInterface.getMobile();
    }
    
    @GetMapping("/wantinfo")
    public String wantInformation() {
        return mobileInterface.getMobileInformation();
    }
    
    @PostMapping("/create")
    public String createMobile() {
        return mobileInterface.postInformation(75000, "iphone-16");
    }
    
    @DeleteMapping("/delete")
    public String Electronicwaste() {
        return mobileInterface.deleteInfo();
    }
}