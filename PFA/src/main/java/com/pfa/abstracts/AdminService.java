package com.pfa.abstracts;

import com.pfa.dto.AdminDTO;
import com.pfa.model.Admin;
import java.util.List;

public interface AdminService {
    Admin createAdmin(AdminDTO adminDTO);
    Admin getAdminByNumero(int numero);
    List<Admin> getAllAdmins();
    Admin updateAdmin(int numero, AdminDTO adminDTO);
    void deleteAdmin(int numero);
}