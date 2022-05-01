package codegym.vn.controller;

import codegym.vn.entity.Email;
import codegym.vn.service.EmailService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
public class EmailController {
    private EmailService emailService;
    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/update")
    public String viewUpdate(Model model){
        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese"};
        String[] pageSizes = {"5", "10", "15", "25", "50", "100"};
        model.addAttribute("email",new Email());
        model.addAttribute("languages",languages);
        model.addAttribute("pageSizes",pageSizes);
        return "views/email";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("email") Email email){
        emailService.getConfiguring(email);
        return "views/cauhinh";
    }
}
