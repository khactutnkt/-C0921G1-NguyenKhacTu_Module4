package vn.codegym.ung_dung_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.ung_dung_blog.model.Blog;
import vn.codegym.ung_dung_blog.service.IBlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public ModelAndView getBlogList(){
        return new ModelAndView("blog/list","blogList", blogService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("blog/create","blog",new Blog());
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("messInsert","Successfully added 1 new blog");
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@ModelAttribute Blog blog){
        return new ModelAndView("blog/edit","blog", blogService.findById(blog.getId()));
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("messInsert","Successfully updated 1 blog");
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@ModelAttribute Blog blog){
        return new ModelAndView("blog/delete","blog", blogService.findById(blog.getId()));
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute Blog blog, RedirectAttributes redirect){
        blogService.remove(blog);
        redirect.addFlashAttribute("messInsert","Successfully removed 1 blog");
        return "redirect:/blog/list";
    }

}
