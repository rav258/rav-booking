package com.rav.dashboard.category;

import com.rav.dashboard.company.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "icon")
    private String icon;
    @Column(name = "pictureurl")
    private String pictureUrl;

    public Category(int id, String name, String description, String icon, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.pictureUrl = pictureUrl;
    }

    @OneToMany
    private List<Company> companyList;

    public int getId() {
        return id;
    }
}
