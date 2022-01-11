package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Customer;
import vn.codegym.service.ICustomerService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "/customer")
    public ModelAndView getCustomerList(Model model){
        List<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
//        return new ModelAndView("list", "customerList", customerService.findAll());
    }
}
