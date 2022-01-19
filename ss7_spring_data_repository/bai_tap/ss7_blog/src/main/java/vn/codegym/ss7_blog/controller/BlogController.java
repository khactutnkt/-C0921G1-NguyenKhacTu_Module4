package vn.codegym.ss7_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.ss7_blog.model.Blog;
import vn.codegym.ss7_blog.service.IBlogService;
import vn.codegym.ss7_blog.service.ICategoryService;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping({"/list",""})
    public String getBlogList(Optional<String> keySearch, Optional<Integer> cateId, Model model,
                              @PageableDefault(size = 2) Pageable pageable){
        model.addAttribute("categoryList", categoryService.findAll());
        if (!keySearch.isPresent() || keySearch.equals("")){    /* TH không nhập tìm kiếm theo tên */
            if (!cateId.isPresent()){   /* TH không nhập tìm theo tên, không chọn category */
                model.addAttribute("blogList", blogService.findAll(pageable));
            }else {   /* TH không nhập tìm theo tên, có chọn category */
                model.addAttribute("cateId",cateId.get());
                model.addAttribute("blogList", blogService.findByCategoryId(cateId.get(), pageable));
            }
        }else {     /* TH có nhập tìm theo tên*/
            model.addAttribute("keySearch", keySearch.get());
            model.addAttribute("blogList", blogService.findByName(keySearch.get(), pageable));
        }

        return "blog/list";

    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/create";
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
