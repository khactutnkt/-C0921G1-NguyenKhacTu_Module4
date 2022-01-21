package vn.codegym.ss8_validatte_bai_hat.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.ss8_validatte_bai_hat.dto.SongDto;
import vn.codegym.ss8_validatte_bai_hat.model.Song;
import vn.codegym.ss8_validatte_bai_hat.service.ISongService;


import java.util.List;
import java.util.Optional;

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
        SongDto songDto = new SongDto();
        model.addAttribute("songDto", songDto);
        return "create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            model.addAttribute("songList", songService.findAll());
            return "list";
        }

//        redirect.addFlashAttribute("messInsert", "Successfully added 1 new song");
//        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id){
        Optional<Song> song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            model.addAttribute("songList", songService.findAll());
            return "list";
        }
//        songService.save(song);
//        redirect.addFlashAttribute("messUpdate", "Updated song information successfully");
//        return "redirect:/";
    }

}
