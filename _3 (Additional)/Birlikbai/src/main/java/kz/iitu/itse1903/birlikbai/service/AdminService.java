package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Admin;
import kz.iitu.itse1903.birlikbai.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }




    //truncate Table
    public String truncateTable() {
        return adminRepository.truncateTable();
    }


    //Basic(CRUD)
    @Cacheable(value = "admin", key = "#admin.id")
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }
    @CachePut("admin")
    public void deleteById(int id) {
        adminRepository.deleteById(id);
    }
    @Cacheable("admin")
    public Admin findById(int id) {
        return adminRepository.findById(id);
    }
    @CacheEvict("admin")
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }


}
