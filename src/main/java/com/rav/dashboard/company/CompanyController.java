package com.rav.dashboard.company;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/list")
    public String companiesList(Model model){
        List<Company> companyList = companyRepository.findAll();
        model.addAttribute("companies",companyList);
        return "/fragments/company_list";
    }

    @GetMapping("/showFormForAddCompany")
    public String showFormForAdd(Model model) {
        Company company = new Company();
        model.addAttribute("companies", company);
        return "forms/companyForm";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("company") Company company) {
        companyRepository.save(company);
        return "redirect:/list";
    }

    @GetMapping("/list/{companyId}")
    public String getCompanyDetails(Model model, @PathVariable String companyId){
        int id = Integer.parseInt(companyId);
        List<Company> companyList = companyRepository.findAll();
        List<Company> companyList1 = companyList.stream().filter(x-> x.getId()==id).collect(Collectors.toList());
        for (Company company : companyList1) {
            model.addAttribute("companies", company);
        }

        return "/fragments/company";

    }

}
