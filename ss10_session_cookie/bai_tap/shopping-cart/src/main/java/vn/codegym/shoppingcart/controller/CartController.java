package vn.codegym.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.shoppingcart.model.Cart;

@Controller
public class CartController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/cart")
    public ModelAndView cart(@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart","cart", cart);
        return modelAndView;
    }
}
