package com.rav.infrastructure.web.partnersAdmin;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Navbar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoryName;
    private String iconClassName;
    private String hrefRedirect;

    public Navbar(String categoryName, String iconClassName, String hrefRedirect) {
        this.categoryName = categoryName;
        this.iconClassName = iconClassName;
        this.hrefRedirect = hrefRedirect;
    }
}
