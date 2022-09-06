package com.co.ude.mintic.UdeaDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerDemoLegacy {
    @RequestMapping(value = "/udea/path2")
    @ResponseBody
    public String mensaje (){
        return "Hola mundo";
    }

}
