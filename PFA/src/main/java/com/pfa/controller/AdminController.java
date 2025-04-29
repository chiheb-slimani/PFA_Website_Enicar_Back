package com.pfa.controller;

import com.pfa.Shared.GlobalResponse;
import com.pfa.Shared.CustomResponseException;
import com.pfa.dto.AdminDTO;
import com.pfa.model.Admin;
import com.pfa.abstracts.AdminService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public GlobalResponse<Admin> createAdmin(@Valid @RequestBody AdminDTO adminDTO) {
        Admin createdAdmin = adminService.createAdmin(adminDTO);
        return new GlobalResponse<>(createdAdmin);
    }

    @GetMapping("/{numero}")
    public GlobalResponse<Admin> getAdmin(@PathVariable int numero) {
        Admin admin = adminService.getAdminByNumero(numero);
        return new GlobalResponse<>(admin);
    }

    @GetMapping
    public GlobalResponse<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return new GlobalResponse<>(admins);
    }

    @PutMapping("/{numero}")
    public GlobalResponse<Admin> updateAdmin(@PathVariable int numero,
                                             @Valid @RequestBody AdminDTO adminDTO) {
        Admin updatedAdmin = adminService.updateAdmin(numero, adminDTO);
        return new GlobalResponse<>(updatedAdmin);
    }

    @DeleteMapping("/{numero}")
    public GlobalResponse<String> deleteAdmin(@PathVariable int numero) {
        adminService.deleteAdmin(numero);
        return new GlobalResponse<>("Admin deleted successfully");
    }
}