package com.choucair.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class LoginModel {

    String username;
    String password;

    public static List<LoginModel> setData(DataTable dataTable) {
        List<LoginModel> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            data.add(new ObjectMapper().convertValue(map, LoginModel.class));
        }
        return data;
    }

}
