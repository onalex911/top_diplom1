package ru.onalex.bijoushop.controllers;

import lombok.RequiredArgsConstructor;
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
import ru.onalex.bijoushop.services.ProductService;

import java.util.List;

@Controller
//@RequestMapping("/bizhuteriya")
//@RequiredArgsConstructor
public class HomeController {
    private BJGroupRepository bjGroupRepository;
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setBjGroupRepository(BJGroupRepository bjGroupRepository) {
        this.bjGroupRepository = bjGroupRepository;
    }
    @Autowired
    public void setBjProductRepository(BJProductRepository bjProductRepository) {
    }



    @GetMapping()
    public String getBjGroups(Model model) {
        List<BjGroup> groups = bjGroupRepository.findAllActive();
        model.addAttribute("groups",groups);
        return "bj_groups";
//        return getBjGroupsService(model);
    }
    @GetMapping("/{group_id}")
    public String getBjGroups(@PathVariable(name="group_id") int groupId, Model model) {
        List<BjProduct> products = productService.getProductsByGroupId(groupId);
        String groupName = bjGroupRepository.findByGroupId(groupId).getGroupName().toString();
        model.addAttribute("group_name",groupName);
        model.addAttribute("products",products);
        return "bj_products";
//        return getBjGroupsService(model);
    }

}
