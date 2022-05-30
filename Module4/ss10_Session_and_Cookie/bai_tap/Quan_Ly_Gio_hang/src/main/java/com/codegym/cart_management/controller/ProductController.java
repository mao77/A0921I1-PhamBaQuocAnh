package com.codegym.cart_management.controller;

import com.codegym.cart_management.model.Cart;
import com.codegym.cart_management.model.Product;
import com.codegym.cart_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    public ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public String showView(@PathVariable("id") Product product, Model model){
        model.addAttribute("product",product);
        return "view";
    }

    @GetMapping("/{id}/add")
    public String addToCart(@PathVariable("id") Product product,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        if (action.equals("up")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }else if(action.equals("down")){
            cart.deleteProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/product/shop";
    }

    @GetMapping("/{id}/delete")
    public String deleteToCart(@PathVariable("id") Product product,
                               @ModelAttribute Cart cart) {
        cart.deleteOneProduct(product);
        return "redirect:/shopping-cart";
    }
}
