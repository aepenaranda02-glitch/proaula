package com.almora.almora.Services;

import com.almora.almora.Model.Admin;
import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin saveAdmin(Admin admin);

    List<Admin> getAllAdmins();

    Optional<Admin> getAdminById(String id); // Cambié Integer → String

    Admin updateAdmin(String id, Admin admin); // Cambié Integer → String

    void deleteAdmin(String id); // Cambié Integer → String
}
