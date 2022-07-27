package kz.iitu.itse1903.birlikbai.repository;

import kz.iitu.itse1903.birlikbai.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query(value = "truncate table admin", nativeQuery = true)
    String truncateTable();

    //Basic(CRUD)
    Admin save(Admin admin);
    void deleteById(int id);
    Admin findById(int id);
    List<Admin> findAll();

}
