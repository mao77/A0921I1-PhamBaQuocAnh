package codegym.vn.controller;

import codegym.vn.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    private CalculatorService calculatorService;
    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping(path = "")
    public String calculator(Model model, @RequestParam ("operand1") double operand1,
                             @RequestParam ("operand2") double operand2,
                             @RequestParam ("operator") String operator){
       model.addAttribute("result",calculatorService.calculator(operator,operand1,operand2));
        return "calculator/view";
    }
}
