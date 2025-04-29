package com.pfa.service;

import com.pfa.abstracts.AdminService;
import com.pfa.dto.AdminDTO;
import com.pfa.model.Admin;
import com.pfa.repo.AdminRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin createAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setNumero(adminDTO.getNumero());
        admin.setNom(adminDTO.getNom());
        admin.setPrenom(adminDTO.getPrenom());
        admin.setEmail(adminDTO.getEmail());
        admin.setMotDePasse(adminDTO.getMotDePasse());
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminByNumero(int numero) {
        return adminRepository.findById(numero)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin updateAdmin(int numero, AdminDTO adminDTO) {
        Admin existingAdmin = getAdminByNumero(numero);
        existingAdmin.setNom(adminDTO.getNom());
        existingAdmin.setPrenom(adminDTO.getPrenom());
        existingAdmin.setEmail(adminDTO.getEmail());
        existingAdmin.setMotDePasse(adminDTO.getMotDePasse());
        return adminRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdmin(int numero) {
        Admin admin = getAdminByNumero(numero);
        adminRepository.delete(admin);
    }
}