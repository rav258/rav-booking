package com.rav.dashboard.company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int theId) {
        Optional<Company> result = companyRepository.findById(theId);

        Company theCompany = null;

        if (result.isPresent()) {
            theCompany = result.get();
        } else {
            throw new RuntimeException("Did not find company id - " + theId);
        }

        return theCompany;
    }

    @Override
    public void save(Company theCompany) {
        companyRepository.save(theCompany);
    }

    @Override
    public void deleteById(int theId) {
        companyRepository.deleteById(theId);
    }
}
