package codegym.vn.controller;

import codegym.vn.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    private DictionaryService dictionaryService;
    @Autowired
    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @RequestMapping(path = "",method = RequestMethod.GET)
    public String home(){
        return "dictionary/translate";
    }

    @RequestMapping(path = "/translate",method = RequestMethod.POST)
    public String calculator(Model model, @RequestParam ("word") String word){
        model.addAttribute("result",dictionaryService.translate(word));
        return "/dictionary/translate";
    }
}
