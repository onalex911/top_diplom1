package ru.onalex.bijoushop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.onalex.bijoushop.entities.BjProduct;
import ru.onalex.bijoushop.entities.BjGroup;
import ru.onalex.bijoushop.repositories.BJProductRepository;
import ru.onalex.bijoushop.repositories.BJGroupRepository;

import java.util.List;

@Controller
@RequestMapping("/bizhuteriya")
public class HomeController {
    @Autowired
    private BJGroupRepository bjGroupRepository;
    @Autowired
    private BJProductRepository bjProductRepository;


    @GetMapping("/groups")
    public String getBjGroups(Model model) {
        List<BjGroup> groups = bjGroupRepository.findAllActive();
        model.addAttribute("groups",groups);
        return "bj_groups";
//        return getBjGroupsService(model);
    }
    @GetMapping("/groups/{group_id}")
    public String getBjGroups(@PathVariable(name="group_id") int groupId, Model model) {
        List<BjProduct> products = bjProductRepository.findBjProductsByGroupId(groupId);
        String groupName = bjGroupRepository.findByGroupId(groupId).getGroupName();
        model.addAttribute("group_name",groupName);
        model.addAttribute("products",products);
        return "bj_products";
//        return getBjGroupsService(model);
    }

}
