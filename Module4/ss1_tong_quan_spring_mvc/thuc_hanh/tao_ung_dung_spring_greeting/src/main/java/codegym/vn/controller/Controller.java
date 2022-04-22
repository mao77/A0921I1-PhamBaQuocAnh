package codegym.vn.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model) {
        model.addAttribute("name1",name);
        return "list";
    }
//public String greeting(Model model) {
//    model.addAttribute("name","kkkkkkkk");
//    return "list";
//}
}
