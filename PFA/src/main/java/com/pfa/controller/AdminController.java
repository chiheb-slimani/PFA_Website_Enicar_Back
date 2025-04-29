package com.pfa.controller;

import com.pfa.dto.AdminDTO;
import com.pfa.model.Admin;
import com.pfa.abstracts.AdminService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public Admin createAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.createAdmin(adminDTO);
    }

    @GetMapping("/{numero}")
    public Admin getAdmin(@PathVariable int numero) {
        return adminService.getAdminByNumero(numero);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PutMapping("/{numero}")
    public Admin updateAdmin(@PathVariable int numero, @RequestBody AdminDTO adminDTO) {
        return adminService.updateAdmin(numero, adminDTO);
    }

    @DeleteMapping("/{numero}")
    public void deleteAdmin(@PathVariable int numero) {
        adminService.deleteAdmin(numero);
    }
}