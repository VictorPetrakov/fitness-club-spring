package com.victorp.controller;

import com.victorp.model.User;
import com.victorp.service.ClientService;
import com.victorp.service.TrainerService;
import com.victorp.service.UserService;
import com.victorp.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private WorkoutService workoutService;

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

    @GetMapping("/clientsView")
    public String clientsView(Model model, String keyword) throws Exception{
        if(keyword != null){
            model.addAttribute("allUsers", userService.findUserByKeyword(keyword));
        }else {
            model.addAttribute("allUsers", userService.getAll());
        }

        return findPaginated(1, "firstName", "asc", model);
    }

    @PostMapping("/clientsView")
    public String deleteUser(@RequestParam Long idUser)throws Exception{

        userService.delete(idUser);

        return "redirect:/";

    }
    @GetMapping("/clientsView/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<User> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<User> listUsers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");


        model.addAttribute("allUsers", listUsers);
        return "clientsView";
    }

}
