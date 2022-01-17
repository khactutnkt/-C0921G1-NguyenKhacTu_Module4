package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Song;
import vn.codegym.service.ISongService;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String list(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        Song song = new Song();
        model.addAttribute("song", song);
        return "create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Song song, RedirectAttributes redirect){
        songService.save(song);
        redirect.addFlashAttribute("messInsert", "Successfully added 1 new song");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Integer id){
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Song song, RedirectAttributes redirect){
        songService.save(song);
        redirect.addFlashAttribute("messUpdate", "Updated song information successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable Integer id, Model model){
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "/delete";
    }

    @PostMapping("/delete")
    public String remove(@ModelAttribute Song song, RedirectAttributes redirect){
        songService.remove(song.getId());
        redirect.addFlashAttribute("messRemove", "Successfully deleted the song");
        return "redirect:/";
    }
}
