package vn.codegym.validate_form_dang_ky.controller;

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
import vn.codegym.validate_form_dang_ky.dto.UserDto;
import vn.codegym.validate_form_dang_ky.model.User;
import vn.codegym.validate_form_dang_ky.service.IUserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping({"/list",""})
    public String showList(Model model){
        model.addAttribute("userList", userService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            model.addAttribute("userList", userService.findAll());
            return "list";
        }
    }
}
