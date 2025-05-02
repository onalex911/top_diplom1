package ru.onalex.bijoushop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.onalex.bijoushop.entities.BjGroup;
import ru.onalex.bijoushop.repositories.BJGroupRepository;
import ru.onalex.bijoushop.services.*;

import java.util.List;

@Controller
@RequestMapping("/bizhuteriya")
public class HomeController {
    @Autowired
    private BJGroupRepository bjGroupRepository;


    @GetMapping("/groups")
    public String getBjGroups(Model model) {
        List<BjGroup> groups = bjGroupRepository.findAllActive();
        model.addAttribute("groups",groups);
        return "bj_groups";
//        return getBjGroupsService(model);
    }

}
