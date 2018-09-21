package com.evergrande.hdtms.web.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.evergrande.hdtms.web.utils.AjaxResultPo;

@Controller
public class InitPageController {
    @RequestMapping("index")
    public String deleteDepart(){
        System.out.println("controller");
        return "index";
    }
}
