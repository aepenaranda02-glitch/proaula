package com.almora.almora.Services.impl;

import com.almora.almora.Model.Admin;
import com.almora.almora.Repository.AdminRepository;
import com.almora.almora.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin updateAdmin(String id, Admin admin) {
        admin.setIdUsuario(id); // asegúrate que Admin tenga idUsuario como String
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(String id) {
        adminRepository.deleteById(id);
    }
}
