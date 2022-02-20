package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.service.customer.ICustomerService;
import com.codegym.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

//    @GetMapping()
//    public ModelAndView getCustomerListPage(@PageableDefault(size = 3) Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("customer/list");
//        modelAndView.addObject("customers", customerService.findAllCustomer(pageable));
//        modelAndView.addObject("customerTypes", customerTypeService.findAll());
//        return modelAndView;
//    }


    @GetMapping()
    public ModelAndView getCustomerListPage(@PageableDefault(size = 3) Pageable pageable,
                                            @RequestParam(defaultValue = "") String customerNameSearch,
                                            @RequestParam(defaultValue = "") String customerTypeSearch) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
//        modelAndView.addObject("customers", customerService.findAll(pageable));
        modelAndView.addObject("customers", customerService.searchCustomer(customerNameSearch, customerTypeSearch, pageable));
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreateCustomerPage() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customer.setCustomerStatus("1");
        customerService.save(customer);
        return "redirect:/customer";
    }


    @GetMapping("/view/{id}")
    public String getDetail(@PathVariable Long id, Model model) {
        Optional<Customer> customer = customerService.findByCustomerId(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
        }
        return "customer/view";
    }

    @GetMapping("/showDelete/{id}")
    public String getDelete(@PathVariable Long id, Model model) {
        Optional<Customer> customer = customerService.findByCustomerId(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
        }
        return "customer/delete";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findByCustomerId(id);
        if (customer.isPresent()) {
            customerService.delete(customer.get());
        }
        return "redirect:/customer";
    }

//    @GetMapping("/edit/{id}")
//    public String getEditCustomerPage(@PathVariable Long id, Model model){
//        Optional<Customer> customer=customerService.findByCustomerId(id);
//        if (customer.isPresent()){
//            model.addAttribute("customer",customer.get());
//            model.addAttribute("customerTypes",customerTypeService.findAll());
//            return "customer/edit";
//        }
//        return "/customer/list";
//    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditCustomerPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        Optional<Customer> customer = customerService.findByCustomerId(id);
        if (customer.isPresent()){
            modelAndView.addObject("customer", customer.get());
            modelAndView.addObject("customerTypes", customerTypeService.findAll());
        }
        return modelAndView;
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Customer customer) {
        customer.setCustomerStatus("1");
        customerService.save(customer);
        return "redirect:/customer";
    }

}
