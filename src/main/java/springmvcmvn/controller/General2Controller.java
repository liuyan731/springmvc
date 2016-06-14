package springmvcmvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="general2.do")
public class General2Controller {
	@RequestMapping(params="method=index")  //����param������
    public String index_jsp2(Model model){
        model.addAttribute("hello", "��ð�spring mvc������һ��mapping��ʽ");  
        return "index";	//����ֱֵ��ӳ��Ϊindex.jsp����ͼ��������
	}
}
