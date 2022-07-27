package kz.iitu.itse1903.birlikbai.repository;

import kz.iitu.itse1903.birlikbai.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    //Basic(CRUD)
    Admin save(Admin admin);
    void deleteById(int id);
    Admin findById(int id);
    List<Admin> findAll();

}
