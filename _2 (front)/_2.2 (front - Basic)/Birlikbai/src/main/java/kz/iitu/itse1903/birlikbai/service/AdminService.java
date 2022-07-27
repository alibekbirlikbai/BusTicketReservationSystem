package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Admin;
import kz.iitu.itse1903.birlikbai.repository.AdminRepository;

import java.util.List;

public class AdminService {

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }



    //truncate Table
    public String truncateTable() {
        return adminRepository.truncateTable();
    }


    //Basic(CRUD)
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }
    public void deleteById(int id) {
        adminRepository.deleteById(id);
    }
    public Admin findById(int id) {
        return adminRepository.findById(id);
    }
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }


}
