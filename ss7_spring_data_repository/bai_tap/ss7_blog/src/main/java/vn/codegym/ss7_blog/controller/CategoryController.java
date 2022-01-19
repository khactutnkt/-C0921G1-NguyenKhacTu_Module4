package vn.codegym.ss7_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.ss7_blog.model.Category;
import vn.codegym.ss7_blog.service.ICategoryService;

@Controller
@RequestMapping("/blog")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/listCategory")
    public ModelAndView getCategoryList(){
        return new ModelAndView("category/listCategory","categoryList", categoryService.findAll());
    }

    @GetMapping("/createCategory")
    public ModelAndView createCategory(){
        return new ModelAndView("category/createCategory","category",new Category());
    }

    @PostMapping("/saveCategory")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("messInsert","Successfully added 1 new category");
        return "redirect:/blog/listCategory";
    }

    @GetMapping("/{id}/editCategory")
    public ModelAndView editCategory(@ModelAttribute Category category){
        return new ModelAndView("category/editCategory","category", categoryService.findById(category.getId()));
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("messInsert","Successfully updated 1 category");
        return "redirect:/blog/listCategory";
    }

    @GetMapping("/{id}/deleteCategory")
    public ModelAndView deleteCategory(@ModelAttribute Category category){
        return new ModelAndView("category/deleteCategory","category", categoryService.findById(category.getId()));
    }

    @PostMapping("/deleteCategory")
    public String removeCategory(@ModelAttribute Category category, RedirectAttributes redirect){
        categoryService.remove(category);
        redirect.addFlashAttribute("messInsert","Successfully removed 1 category");
        return "redirect:/blog/listCategory";
    }

}
