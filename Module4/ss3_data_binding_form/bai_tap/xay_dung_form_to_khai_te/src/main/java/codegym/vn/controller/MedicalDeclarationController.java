package codegym.vn.controller;

import codegym.vn.entity.MedicalDeclaration;
import codegym.vn.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicalDeclaration")
public class MedicalDeclarationController {
    private MedicalDeclarationService medicalDeclarationService;
    @Autowired
    public MedicalDeclarationController(MedicalDeclarationService medicalDeclarationService) {
        this.medicalDeclarationService = medicalDeclarationService;
    }

    @GetMapping("/list")
    public String listAll(Model model){
        model.addAttribute("medicalDeclarationList",medicalDeclarationService.listAllMedicalDeclaration());
        return "views/list";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        String[] travelInformations = {"tau bay","tau thuyen","oto"};
        model.addAttribute("medicalDeclaration",new MedicalDeclaration());
        model.addAttribute("travelInformations",travelInformations);
        return "views/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute ("medicalDeclaration") MedicalDeclaration medicalDeclaration,Model model){
        medicalDeclarationService.createMedicalDeclaration(medicalDeclaration);
        model.addAttribute("medicalDeclarationList",medicalDeclarationService.listAllMedicalDeclaration());
        return "redirect:/medicalDeclaration/list";
    }
}
