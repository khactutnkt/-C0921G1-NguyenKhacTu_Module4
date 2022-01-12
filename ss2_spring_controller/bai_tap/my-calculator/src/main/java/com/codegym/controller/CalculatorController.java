package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping(value = {"/", "/calculator"})
    public String calculator(){
        return "index";
    }

    @PostMapping(value = {"/", "/calculator"})
    public String calculator(@RequestParam(required = false, defaultValue = "0") int firstOperand,@RequestParam(required = false, defaultValue = "0") int secondOperand, @RequestParam String calculation, Model model) {
        String result;
        try {
            switch (calculation){
                case "+":
                    result = Integer.toString(firstOperand + secondOperand);
                    break;
                case "-":
                    result = Integer.toString(firstOperand - secondOperand);
                    break;
                case "*":
                    result = Integer.toString(firstOperand * secondOperand);
                    break;
                case "/":
                    result = Integer.toString(firstOperand / secondOperand);
                    break;
                default:
                    result = "math error";
            }
        }catch (Exception e){
            result = "math error";
        }
        model.addAttribute("result", result);
        return "index";
    }
}
