package springmvcmvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
  
@Controller  
public class GeneralController {  
    @RequestMapping(value="index.do")  
    public void index_jsp2(Model model){	// ��û��return��string�������@RequestMapping(value="index.do")���index.jsp
        model.addAttribute("hello", "��ð�spring mvc");  
        System.out.println("index.jsp");  
    }
} 
