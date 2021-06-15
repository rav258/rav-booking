package com.rav.dashboard.partner;

import com.rav.dashboard.category.Category;
import com.rav.dashboard.category.CategoryRepository;
import com.rav.dashboard.company.Company;
import com.rav.dashboard.company.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("registerPartner")
public class PartnerController {


    CategoryRepository categoryRepository;
    PartnerRepository partnerRepository;
    CompanyRepository companyRepository;

    @GetMapping
    public String showPartnerLoginPage(Model model) {
        model.addAttribute("partner", new Partner());
        List<Category> categoryRepositoryAll = categoryRepository.findAll();
        categoryRepositoryAll.forEach(x -> model.addAttribute("cat", x));
        return "forms/partnerRegistrationForm";
    }

    @GetMapping("login")
    public String partnerLogin(Model model) {
        return "";
    }

//    @RequestMapping("/updatePartner")
//    public String updatePartner(Long id, String firstName) {
//        Optional<Partner> partnerRepositoryById = partnerRepository.findById(id);
//        List<Partner> collect = partnerRepositoryById.stream().filter(x -> x.getId().equals(id)).collect(Collectors.toList());
//        for (Partner partner : collect) {
//            if (partner.getId().equals(id)){
//                partner.setFirstName(firstName);
//                partnerRepository.save(partner);
//            }
//        }
//        return "redirect:admin/setup";
//
//    }

    @PostMapping("/savePartner")
    public String updatePartner(Partner partner, Long id, Company company){
      log.info(partner.getFirstName());
partnerRepository.updateFirstName(id,partner.getFirstName());
partnerRepository.updateLastName(id,partner.getLastName());
//companyRepository.updateCompanyName(id,company.getName());
        log.info(partner.getFirstName());


        return "redirect:/partner/admin/setup";
    }

//    @GetMapping("/findOne")
//    @ResponseBody
//    public Partner findAll(@RequestParam("productId") Long theId){
//
//        return partnerRepository.findById(theId).orElse(null);
//
//    }

    @PutMapping("/findOne")
    public Partner updatePartnerV2(@RequestBody Partner partner){
        partnerRepository.save(partner);
        return partner;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long theId,
                                    Model theModel, String firstName) {


        Optional<Partner> partnerRepositoryById = partnerRepository.findById(theId);
        Partner partner = null;

        if (partnerRepositoryById.isPresent()){
             partner = partnerRepositoryById.get();
        }



        assert partner != null;
        partner.setFirstName(firstName);
        partnerRepository.save(partner);

//        partnerRepository.updateFirstName(theId,firstName);

        theModel.addAttribute("partner", partner);


        return "admin/setup";
    }


}
