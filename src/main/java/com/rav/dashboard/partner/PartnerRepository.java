package com.rav.dashboard.partner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Optional<Partner> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Partner a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enablePartner(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Partner a " +
            "SET a.category.id = 1 where a.email = ?1")
    int updateCategoryToId1(String email);

    @Modifying
    @Query("UPDATE Partner a SET a.firstName = :firstName where a.id = :id")
    void updateFirstName(@Param(value = "id") long id, @Param(value = "firstName") String firstName);

    @Modifying
    @Query("UPDATE Partner a SET a.lastName = :lastName where a.id = :id")
    void updateLastName(@Param(value = "id") long id, @Param(value = "lastName") String lastName);





}
