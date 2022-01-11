package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static Map<String, String> dictionaryMap;
    static {
        dictionaryMap = new HashMap<>();
        dictionaryMap.put("hello", "xin chào");
        dictionaryMap.put("thank", "cảm ơn");
        dictionaryMap.put("vehicle", "xe hơi");
        dictionaryMap.put("bridge", "cây cầu");
        dictionaryMap.put("umbrella", "cái dù");
        dictionaryMap.put("hi", "chào!");
    }

    @GetMapping("/dictionary")
    public String translate(){
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String translate(@RequestParam String word, Model model){
        model.addAttribute("result",dictionaryMap.get(word));
        return "dictionary";
    }

}
