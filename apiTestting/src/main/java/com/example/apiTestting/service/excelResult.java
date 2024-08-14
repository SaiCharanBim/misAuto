package com.example.apiTestting.service;


import com.example.apiTestting.DTO.resultDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class excelResult {

    private final ObjectMapper objectMapper;

    public excelResult(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final String DIRECTORY_PATH = "/home/bimsai/misPG";

    public void convertListToExcel(List<resultDTO> resultDTOList, HttpServletResponse response) throws IOException {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Results");

        // Create a header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Name", "Email", "Mobile", "Application ID", "Case Initiation Date",
                "Application Initial Submission Date", "Initiation to First Time Submission TAT",
                "Application Latest Submission Date", "Initiation to Latest Submission TAT",
                "SRE Total TAT", "Application Status", "Assigned With", "Last Actioned By",
                "Total Time In CPU Tray", "Action By CPU", "Time Of Action By CPU", "Actioned By CPU"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Create data rows for each ResultDTO object
        int rowNum = 1;
        for (resultDTO result : resultDTOList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(result.getName());
            row.createCell(1).setCellValue(result.getEmail());
            row.createCell(2).setCellValue(result.getMobile());
            row.createCell(3).setCellValue(result.getApplicationId());
            row.createCell(4).setCellValue(result.getCaseInitiationDate());
            row.createCell(5).setCellValue(result.getApplicationInitialSubmissionDate());
            row.createCell(6).setCellValue(result.getInitiationToFirstTimeSubmissionTAT());
            row.createCell(7).setCellValue(result.getApplicationLatestSubmissionDate());
            row.createCell(8).setCellValue(result.getInitiationToLatestSubmissionTAT());
            row.createCell(9).setCellValue(result.getSreTotalTAT());
            row.createCell(10).setCellValue(result.getApplicationStatus());
            row.createCell(11).setCellValue(result.getAssignedWith());
            row.createCell(12).setCellValue(result.getLastActionedBy());
            row.createCell(13).setCellValue(result.getTotalTimeInCpuTray());
            row.createCell(14).setCellValue(result.getActionByCpu());
            row.createCell(15).setCellValue(result.getTimeOfActionByCpu());
            row.createCell(16).setCellValue(result.getActionedByCpu());
        }

        // Ensure the directory exists
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Define the full path to the file
        String filePath = DIRECTORY_PATH + File.separator + "results.xlsx";

        // Write the workbook to the specified file on the server's file system
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }

        // Optionally, also write the output to the response's output stream for client download
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=results.xlsx");
        workbook.write(response.getOutputStream());

        // Close the workbook
        workbook.close();
    }
}
