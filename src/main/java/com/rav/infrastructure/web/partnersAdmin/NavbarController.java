package com.rav.infrastructure.web.partnersAdmin;


import com.rav.dashboard.category.Category;
import com.rav.dashboard.category.CategoryRepository;
import com.rav.dashboard.company.Company;
import com.rav.dashboard.company.CompanyRepository;
import com.rav.dashboard.partner.Partner;
import com.rav.dashboard.partner.PartnerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Controller
@RequestMapping("/partner/admin")
public class NavbarController {

    @Autowired
    private final NavbarImpl navbarService;
    @Autowired
    private final PartnerRepository partnerRepository;
    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public NavbarController(NavbarImpl navbarService, PartnerRepository partnerRepository, CompanyRepository companyRepository,CategoryRepository categoryRepository) {
        this.navbarService = navbarService;
        this.partnerRepository = partnerRepository;
        this.companyRepository = companyRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    public String showNavbarCategories(Model model) {
        List<Navbar> navbar = navbarService.findAll();


        model.addAttribute("navbar", navbar);

        return "admin/adminPage";
    }

    @GetMapping("/setup")
    public String showNavbarSetup(Model model, Principal principal) {
        List<Partner> partnerList = partnerRepository.findAll();
        List<Company> companyListAll = companyRepository.findAll();

        List<Category> categoryRepositoryAll = categoryRepository.findAll();
        for (Category category : categoryRepositoryAll) {

            model.addAttribute("categories",category);
            log.info(category);
        }




        List<Partner> collectLoggedUser = partnerList.stream().filter(x -> x.getEmail().equals(principal.getName())).collect(Collectors.toList());

        for (Partner partner : collectLoggedUser) {
            log.info(partner.getEmail());
            log.info(partner.getFirstName());
            log.info(partner.getLastName());
            log.info(partner.getCompany().getName());
            log.info(partner.getCategory());
            log.info("................................");


model.addAttribute("company", companyListAll);
            model.addAttribute("partner",partner);

        }





        log.info(principal.getName());
        List<Navbar> navbar = navbarService.findAll();
        model.addAttribute("navbar", navbar);

        return "admin/setup";
    }




}
