package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
@RequestMapping("/sandwich")

public class SandwichController {
    @GetMapping(path = "/order")
    public String viewOrder(){
        return "sandwich/order";
    }
    @PostMapping(path = "/order")
    public String getOrder(Model model,@RequestParam ("condiments") String[] condiments){
        model.addAttribute("condiments",condiments);
        return "sandwich/list";
    }
}
