package com.rav.dashboard.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    @Modifying
    @Query("UPDATE Company a SET a.name = :name where a.id = :id")
    void updateCompanyName(@Param(value = "id") long id, @Param(value = "name") String name);


}
