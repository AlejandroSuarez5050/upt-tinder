/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.app.upt.service;

import com.app.app.upt.dto.AdminDTO;

import java.util.List;

/**
 * @author AxelA
 */
public interface AdminServices {
    List<AdminDTO> listAdmins();

    Boolean addAdmin(AdminDTO admin);

    Boolean editAdmin(String id, AdminDTO admin);
}
