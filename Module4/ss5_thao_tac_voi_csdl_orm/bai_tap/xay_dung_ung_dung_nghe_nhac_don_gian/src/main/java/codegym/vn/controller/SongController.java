package codegym.vn.controller;

import codegym.vn.entity.Song;
import codegym.vn.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("songs",songService.findAll());
        return "/nhaccuatui/list";
    }

    @GetMapping("/view")
    public String viewById(@RequestParam ("id") String id,Model model){
        model.addAttribute("song",songService.findById(id));
        return "/nhaccuatui/view";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        String[] tyleNames = {"pop","rock","rap","bolero"};
        model.addAttribute("tyleNames",tyleNames);
        model.addAttribute("song",new Song());
        return "/nhaccuatui/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("song") Song song, Model model) {
        songService.create(song);
       model.addAttribute("songs", songService.findAll());
        return "redirect:/song/list";
    }

    @GetMapping("/edit")
    public String viewEdit(@RequestParam ("id") String id,Model model){
        String[] tyleNames = {"pop","rock","rap","bolero"};
        model.addAttribute("song",songService.findById(id));
        model.addAttribute("typeNames",tyleNames);
        return "/nhaccuatui/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute ("song") Song song) {
        songService.update(song);
        return "redirect:/song/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("id") String id) {
        songService.delete(id);
        return "redirect:/song/list";
    }
}
