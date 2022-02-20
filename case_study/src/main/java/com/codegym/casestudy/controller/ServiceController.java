package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Service;
import com.codegym.casestudy.service.service.IRentTypeService;
import com.codegym.casestudy.service.service.IServiceService;
import com.codegym.casestudy.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IServiceTypeService serviceTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping()
    public ModelAndView getServiceListPage(@PageableDefault(size = 3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("services", serviceService.findAllService(pageable));
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        modelAndView.addObject("serviceTypes", serviceTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreateServicePage(){
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("serviceTypes", serviceTypeService.findAll());
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveService(@ModelAttribute Service service){
        service.setServiceStatus("1");
        serviceService.save(service);
        return "redirect:/service";
    }
}
