package com.example.apiTestting.service;

import com.example.apiTestting.DTO.ApplicationDataRequest;
import com.example.apiTestting.DTO.listOfApplication;
import com.example.apiTestting.DTO.resultDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class rootMisService {
    @Autowired
    excelResult er;
    public String rootMisExcel (listOfApplication appList , String cookie, HttpServletResponse response ){

        misResultService mrs = new misResultService();
        List<resultDTO>appResults = new ArrayList<>() ;
        List<String>appIDS = appList.getApplicationIds();
        for( int i = 0 ; i < appIDS.size() ; ++i ){
            resultDTO misResponse = mrs.misResult(appIDS.get(i),cookie);
            appResults.add(misResponse);
        }
        try {
            er.convertListToExcel(appResults, response);
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed";
        }

       return "File Downloaded";
    }
}
