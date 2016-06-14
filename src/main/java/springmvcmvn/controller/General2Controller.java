package springmvcmvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="general2.do")
public class General2Controller {
	@RequestMapping(params="method=index")  //加入param的请求
    public String index_jsp2(Model model){
        model.addAttribute("hello", "你好啊spring mvc，另外一种mapping方式");  
        return "index";	//返回值直接映射为index.jsp（视图解析器）
	}
}
