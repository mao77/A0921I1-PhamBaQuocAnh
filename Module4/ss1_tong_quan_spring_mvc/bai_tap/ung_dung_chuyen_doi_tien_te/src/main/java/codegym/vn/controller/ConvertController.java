package codegym.vn.controller;

import codegym.vn.service.ConvertService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

@Controller
@RequestMapping("/convert")
public class ConvertController {
    public ConvertService service;
    @Autowired
    public ConvertController(ConvertService service) {
        this.service = service;
    }

    @RequestMapping(path = "",method = RequestMethod.GET)
    public String convert(){
        return "convert/list";
    }
    @RequestMapping(path = "",method = RequestMethod.POST)
    public String calculator(Model model,@RequestParam("usd") double usd){
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",service.calculator(usd));
        return "convert/list";
    }
}
