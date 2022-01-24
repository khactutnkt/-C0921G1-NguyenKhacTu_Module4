package vn.codegym.ung_dung_muon_sach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.ung_dung_muon_sach.model.Book;
import vn.codegym.ung_dung_muon_sach.service.IBookService;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping({"","list"})
    public String getBookList(Model model, @PageableDefault(size = 2) Pageable pageable){
        model.addAttribute("bookList",bookService.findAll(pageable));
        return "list";
    }

    @GetMapping("/{id}/view")
    public ModelAndView getInformation(@PathVariable Integer id){
        System.out.println(bookService.findById(id));
        return new ModelAndView("info", "book", bookService.findById(id));
    }

    @PostMapping("/rent")
    public String rentBook(@ModelAttribute Book book, RedirectAttributes attributes){
        Book book1 = bookService.findById(book.getId());
        if (book1.getQuantity()>0){
            book1.setQuantity(book1.getQuantity()-1);
            bookService.save(book1);
            attributes.addFlashAttribute("mess","Successfully rent 1 book");
            return "redirect:/book/";
        }else {
            return "error_page";
        }
    }

    @PostMapping("/return")
    public String returnBook(Optional<Integer> bookId, RedirectAttributes attributes) throws Exception{
        Book book = bookService.findById(bookId.get());
        if (book == null){
            throw new Exception();
        }
        book.setQuantity(book.getQuantity()+1);
        bookService.save(book);
        attributes.addFlashAttribute("mess","Successfully return 1 book");
        return "redirect:/book/";
    }

    @ExceptionHandler(value = Exception.class)
    public String goErrorPage(){
        return "error_page";
    }
}
