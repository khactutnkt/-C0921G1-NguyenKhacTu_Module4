package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.service.customer.ICustomerService;
import com.codegym.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping
    public ModelAndView getCustomerListPage(@PageableDefault(size = 3)Pageable pageable){
        return new ModelAndView("customer/list", "customers", customerService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView getCreateCustomerPage(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Customer customer, RedirectAttributes attributes){
        customer.setCustomerStatus("1");
        customerService.save(customer);
        return "redirect:/customer";
    }

}
