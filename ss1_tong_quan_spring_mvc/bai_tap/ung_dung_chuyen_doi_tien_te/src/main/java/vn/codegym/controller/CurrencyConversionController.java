package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @GetMapping("/currencyConverter")
    public String convert(){
        return "currencyConversion";
    }

    @PostMapping("/currencyConverter")
    public String convert(@RequestParam double rate, double usd, Model model){
        double vnd = usd * rate;
        model.addAttribute("vnd",vnd);
        return "currencyConversion";
    }
}
