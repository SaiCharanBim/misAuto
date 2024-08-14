package com.example.apiTestting.controller;

import com.example.apiTestting.DTO.ApplicationDataRequest;
import com.example.apiTestting.DTO.listOfApplication;
import com.example.apiTestting.DTO.resultDTO;
import com.example.apiTestting.DTO.timeStampsDTO;
import com.example.apiTestting.repo.responseModel;
import com.example.apiTestting.service.excelResult;
import com.example.apiTestting.service.misResultService;
import com.example.apiTestting.service.misService;
import com.example.apiTestting.service.rootMisService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class misController {

    private final misService applicationDataService;
    private final misResultService misresultService;
    private final excelResult jsonToExcelService;
    private final rootMisService rms;

    @Autowired
    public misController(misService applicationDataService, misResultService misresultService, excelResult jsonToExcelService, rootMisService rms) {
        this.applicationDataService = applicationDataService;
        this.misresultService = misresultService;
        this.jsonToExcelService = jsonToExcelService;
        this.rms = rms ;

    }


    @PostMapping("/getApplicationData")
    public responseModel getApplicationData(
            @RequestBody ApplicationDataRequest request,
            @RequestHeader("Cookie") String cookie) {
        return applicationDataService.getApplicationData(request.getApplicationId(), cookie);
    }

    @PostMapping("/getMisData")
    public resultDTO getMisData(
            @RequestBody ApplicationDataRequest request,
            @RequestHeader("Cookie") String cookie) {
        return misresultService.misResult(request.getApplicationId(), cookie);
    }

    @PostMapping("/getTimeStamps")
    public timeStampsDTO getTimeStamps(
            @RequestBody ApplicationDataRequest request,
            @RequestHeader("Cookie") String cookie) {
        return misresultService.timestamps(request.getApplicationId(), cookie);
    }



    @PostMapping("/misDownload")
    public void misDownload(@RequestBody List<resultDTO> resultDTOList, HttpServletResponse response) {
        try {
            jsonToExcelService.convertListToExcel(resultDTOList, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("misPgExcel")
    public String misPgExcel ( @RequestBody listOfApplication request,
                               @RequestHeader("Cookie") String cookie,HttpServletResponse response){
        return rms.rootMisExcel(request,cookie,response);
    }
}