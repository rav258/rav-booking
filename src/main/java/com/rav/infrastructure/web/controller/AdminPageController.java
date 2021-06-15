package com.rav.infrastructure.web.controller;


import com.rav.dashboard.partner.Partner;
import com.rav.dashboard.partner.PartnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class AdminPageController {

    private final PartnerRepository partnerRepository;

    public AdminPageController(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @GetMapping("adminPartnerPage")
    public String adminPage(Model model, Principal principal) {
        List<Partner> partnerList = partnerRepository.findAll();
        for (Partner partner : partnerList) {
            if (partner.getEmail().equals(principal.getName())) {
                model.addAttribute("partner", partner);
            }
        }
        return "/admin/adminPage";
    }
}
