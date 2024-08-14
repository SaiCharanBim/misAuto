package com.example.apiTestting.service;


// ApplicationDataService.java



import com.example.apiTestting.repo.requestModel;
import com.example.apiTestting.repo.responseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class misService {

    private  RestTemplate restTemplate = new RestTemplate();



    public responseModel getApplicationData(String applicationId, String cookies) {
        String url = "https://sarathi2-proxy.axisbank.com/blender/getApplicationData";

        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Cookie", cookies);

        // Set up request body
         requestModel request = new requestModel(applicationId);

        // Create HttpEntity object to pass headers and body
        HttpEntity<requestModel> entity = new HttpEntity<>(request, headers);

        // Send POST request
        ResponseEntity<responseModel> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                responseModel.class
        );

        // Return response body
        return response.getBody();
    }
}

