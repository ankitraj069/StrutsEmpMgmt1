/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Province;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class StateService {

    public static StateService stateService = null;

    public StateService() {
    }

    public static StateService getInstance() {
        if (stateService == null) {
            return new StateService();
        } else {
            return stateService;
        }
    }

    public ArrayList getAllState(String id) {
        ArrayList stateList = new ArrayList<>();

        String sql = "Select * from states where countryCode=?";

        try {
            Connection con = JDBCConnectionManager.getMySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);

            System.out.println("StateService :: " + ps);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Province state = new Province();
                state.setStateCode(rs.getString("stateCode"));

                state.setStateName(rs.getString("stateName"));
//                state.setDistrictCode(rs.getString("distCode"));

                state.setCountryCode(rs.getString("countryCode"));

                stateList.add(state);
            }
            System.out.println(stateList.size());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return stateList;
    }

}
