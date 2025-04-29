package com.pfa.service;

import com.pfa.Shared.CustomResponseException;
import com.pfa.abstracts.AdminService;
import com.pfa.dto.AdminDTO;
import com.pfa.model.Admin;
import com.pfa.repo.AdminRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin createAdmin(AdminDTO adminDTO) {
        // Check if admin with this numero already exists
        if (adminRepository.existsById(adminDTO.getNumero())) {
            throw CustomResponseException.BadRequest("Admin with this numero already exists");
        }

        // Check if email is already in use


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
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Admin not found with numero: " + numero));
    }

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        if (admins.isEmpty()) {
            throw CustomResponseException.ResourceNotFound("No admins found");
        }
        return admins;
    }

    @Override
    public Admin updateAdmin(int numero, AdminDTO adminDTO) {
        Admin existingAdmin = adminRepository.findById(numero)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Admin not found with numero: " + numero));

        // Check if new email is already in use by another admin


        existingAdmin.setNom(adminDTO.getNom());
        existingAdmin.setPrenom(adminDTO.getPrenom());
        existingAdmin.setEmail(adminDTO.getEmail());
        existingAdmin.setMotDePasse(adminDTO.getMotDePasse());
        return adminRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdmin(int numero) {
        if (!adminRepository.existsById(numero)) {
            throw CustomResponseException.ResourceNotFound("Admin not found with numero: " + numero);
        }
        adminRepository.deleteById(numero);
    }
}