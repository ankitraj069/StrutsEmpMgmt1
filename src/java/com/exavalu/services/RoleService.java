/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.services;

import com.exavalu.models.Role;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RoleService {

    public static ArrayList getAllRole() {
        ArrayList roleLIst = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getMySQLConnection();

            String sql = "Select * from roles";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Role role=new Role();
                
                role.setRoleId(rs.getInt("roleId"));
                role.setRoleName(rs.getString("roleName"));
                
                roleLIst.add(role);
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return roleLIst;
    }
    
}
