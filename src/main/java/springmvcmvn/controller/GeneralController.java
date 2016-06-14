package springmvcmvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
  
@Controller  
public class GeneralController {  
    @RequestMapping(value="index.do")  
    public void index_jsp2(Model model){	// 若没有return的string，则根据@RequestMapping(value="index.do")获得index.jsp
        model.addAttribute("hello", "你好啊spring mvc");  
        System.out.println("index.jsp");  
    }
} 
