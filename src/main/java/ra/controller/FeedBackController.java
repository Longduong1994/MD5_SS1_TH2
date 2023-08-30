package ra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.model.dto.FormFeedBackDto;
import ra.model.service.FeedBackService;

@Controller
public class FeedBackController {
    @Autowired
   private FeedBackService feedBackService;
    @GetMapping
    public String home(Model model){
        model.addAttribute("list",feedBackService.findAll());
        model.addAttribute("form",new FormFeedBackDto());
        return "home";
    }

    @PostMapping()
    public String publish (@ModelAttribute FormFeedBackDto f){
        feedBackService.save(f);
        return "redirect:/";
    }
    @GetMapping("{id}")
    public String like (@PathVariable Long id){
        feedBackService.like(id);
        return "redirect:/";
    }


}