package com.rav.dashboard.company;


import com.rav.dashboard.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String logoPicture;

    @ManyToOne
    private Category category;

    public Company(String name, String location, String logoPicture) {
        this.name = name;
        this.location = location;
        this.logoPicture = logoPicture;
    }



}
