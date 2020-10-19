package com.victorp.controller;

import com.victorp.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewTrainerController {

    @Autowired
    private TrainerService trainerService;


    @GetMapping("/trainerView")
    public String viewTrainer(Model model, String keyword) throws Exception{

        if(keyword != null){
            model.addAttribute("allTrainers", trainerService.findTrainerByKeyword(keyword));
        }else {
            model.addAttribute("allTrainers", trainerService.getAll());
        }


        return "trainerView";

    }

    @PostMapping("/trainerView")
    public String deleteTrainer(@RequestParam Long idTrainer)throws Exception{

        trainerService.delete(idTrainer);

        return "redirect:/";

    }


}
