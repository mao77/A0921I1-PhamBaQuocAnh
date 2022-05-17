package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listAllUser(Model model){

        return "/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("user", new UserDto());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute ("user") @Validated  UserDto userDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            return "create";
        }else { User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.create(user);
            redirectAttributes.addFlashAttribute("message", "Create user: " + user.getFirstName()
                    + " " + user.getLastName() + "OK!");
            return "redirect:/user/list";
        }
    }
}
