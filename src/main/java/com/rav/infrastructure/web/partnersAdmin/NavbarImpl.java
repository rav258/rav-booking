package com.rav.infrastructure.web.partnersAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavbarImpl implements NavbarService{

    NavbarRepository navbarRepository;
@Autowired
    public NavbarImpl(NavbarRepository navbarRepository) {
        this.navbarRepository = navbarRepository;
    }

    @Override
    public List<Navbar> findAll() {
        return navbarRepository.findAll();
    }


}
