package com.example.apiTestting.service;

import com.example.apiTestting.DTO.resultDTO;
import com.example.apiTestting.DTO.timeStampsDTO;
import com.example.apiTestting.repo.responseModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class misResultService {

    public resultDTO misResult(String appID, String cookie ){
        List<String> rmSide = new ArrayList<>();
        List<String> backOPSSide = new ArrayList<>();
        misService raw = new misService();
        responseModel rawResponse = raw.getApplicationData(appID,cookie);
        resultDTO finalResult = new resultDTO();
        utcToIstService timeChanger = new utcToIstService();
        timeCalculationService tcs = new timeCalculationService();
        finalResult.applicationId = appID;
        if(rawResponse != null){

          if(rawResponse.getResult()!=null && rawResponse.getResult().getMerchantData() != null && rawResponse.getResult().getMerchantData().email != null ){
              finalResult.email= rawResponse.getResult().getMerchantData().email;
          }else{
              finalResult.email = "N.A";
          }
          if(rawResponse.getResult()!=null && rawResponse.getResult().getMerchantData() != null && rawResponse.getResult().getMerchantData().name != null ){
                finalResult.name= rawResponse.getResult().getMerchantData().name;
          }else{
                finalResult.name = "N.A";
          }
          if(rawResponse.getResult()!=null && rawResponse.getResult().getMerchantData() != null && rawResponse.getResult().getMerchantData().mobile != null ){
                finalResult.mobile= rawResponse.getResult().getMerchantData().email;
          }else{
                finalResult.mobile = "N.A";
          }
          if(rawResponse.getResult()!=null && rawResponse.getResult().getMerchantData() != null && rawResponse.getResult().getMerchantData().getExecutedRules()!= null &&  rawResponse.getResult().getMerchantData().getInternalNotes()!= null){
               //finalResult. = timeChanger.readableUtcToIst(rawResponse.getResult().getMerchantData().getExecutedRules().get(0).getTimeStamp());
             // finalResult.applicationInitialSubmissionDate = timeChanger.utcToIst("2024-08-01T08:42:42.78");
              //List<?>obj = rawResponse.getResult().getMerchantData().getInternalNotes();
              rmSide.add(timeChanger.readableUtcToIst(rawResponse.getResult().getMerchantData().getExecutedRules().get(0).getTimeStamp()));
              for( int i = 0 ; i < rawResponse.getResult().getMerchantData().getInternalNotes().size() ; ++i ){
                  String msg = rawResponse.getResult().getMerchantData().getInternalNotes().get(i).getAction();
                  if( msg.equals("submitted") ){
                      backOPSSide.add(timeChanger.utcToIst((rawResponse.getResult().getMerchantData().getInternalNotes().get(i).getLogTime())));
                  }else if (msg.equals("draft")){
                      rmSide.add(timeChanger.utcToIst(rawResponse.getResult().getMerchantData().getInternalNotes().get(i).getLogTime()));
                  }
              }
              if(rmSide.size() > backOPSSide.size()){
                  finalResult.actionByCpu = "Refer Back";
                  finalResult.applicationStatus = "Refer Back" ;
                  finalResult.timeOfActionByCpu = rmSide.get(rmSide.size()-1);
                  finalResult.actionedByCpu = rawResponse.getResult().getMerchantData().getInternalNotes().get(rmSide.size()-1).getActionBy();
              }else{
                  finalResult.actionByCpu = "N.A";
                  finalResult.applicationStatus = "Pending" ;
              }
              finalResult.caseInitiationDate = rmSide.get(0);
              finalResult.applicationInitialSubmissionDate = backOPSSide.get(0);
              finalResult.applicationLatestSubmissionDate = backOPSSide.get(backOPSSide.size()-1);
              if(rmSide.size() > backOPSSide.size()){
                 /* String lastDraft = rmSide.get(rmSide.size()-1);
                  rmSide.remove(rmSide.size()-1);
                  finalResult.sreTotalTAT = tcs.calTimeDif(rmSide,backOPSSide, backOPSSide.size());
                  rmSide.add(lastDraft);
                  String firstDraft = rmSide.get(0);
                  rmSide.remove(0);
                  finalResult.totalTimeInCpuTray = tcs.calTimeDif(backOPSSide,rmSide , backOPSSide.size());
                  rmSide.add(0,firstDraft);*/
              }else{
                  if (backOPSSide.size() == 1 ){
                    /*  String lastDraft = rmSide.get(rmSide.size()-1);
                      rmSide.remove(rmSide.size()-1);
                      finalResult.sreTotalTAT = tcs.calTimeDif(rmSide,backOPSSide, 1);
                      finalResult.totalTimeInCpuTray = "N.A";*/
                  }else{
                     /* finalResult.sreTotalTAT = tcs.calTimeDif(rmSide,backOPSSide,backOPSSide.size());
                      String lastSub = backOPSSide.get(backOPSSide.size()-1);
                      backOPSSide.remove(backOPSSide.size()-1);
                      String firstRm = rmSide.get(0);
                      rmSide.remove(0);
                      finalResult.totalTimeInCpuTray = tcs.calTimeDif(backOPSSide,rmSide,backOPSSide.size());
                      backOPSSide.add(lastSub);
                      rmSide.add(0,firstRm); */
                  }
                  finalResult.timeOfActionByCpu = "N.A";
                  finalResult.actionedByCpu = "N.A";
              }

              finalResult.initiationToFirstTimeSubmissionTAT = tcs.singleTimeCal(finalResult.caseInitiationDate,finalResult.applicationInitialSubmissionDate);
              finalResult.initiationToLatestSubmissionTAT = tcs.singleTimeCal(finalResult.caseInitiationDate,finalResult.applicationLatestSubmissionDate);
              finalResult.timeOfActionByCpu = rmSide.get(rmSide.size()-1);
             // finalResult.applicationInitialSubmissionDate =  timeChanger.utcToIst (rawResponse.getResult().getMerchantData().getInternalNotes().get(0).getLogTime());
          }else{
                finalResult.applicationInitialSubmissionDate = "N.A";
          }

          return finalResult;
        }
        return null;
    }

    public timeStampsDTO timestamps(String appID, String cookie){
        List<String> rmSide = new ArrayList<>();
        List<String> backOPSSide = new ArrayList<>();
        misService raw = new misService();
        responseModel rawResponse = raw.getApplicationData(appID,cookie);
        utcToIstService timeChanger = new utcToIstService();
        timeCalculationService tcs = new timeCalculationService();
        if(rawResponse.getResult()!=null && rawResponse.getResult().getMerchantData() != null && rawResponse.getResult().getMerchantData().getExecutedRules()!= null &&  rawResponse.getResult().getMerchantData().getInternalNotes()!= null) {
            //finalResult. = timeChanger.readableUtcToIst(rawResponse.getResult().getMerchantData().getExecutedRules().get(0).getTimeStamp());
            // finalResult.applicationInitialSubmissionDate = timeChanger.utcToIst("2024-08-01T08:42:42.78");
            //List<?>obj = rawResponse.getResult().getMerchantData().getInternalNotes();
            rmSide.add(timeChanger.readableUtcToIst(rawResponse.getResult().getMerchantData().getExecutedRules().get(0).getTimeStamp()));
            for (int i = 0; i < rawResponse.getResult().getMerchantData().getInternalNotes().size(); ++i) {
                String msg = rawResponse.getResult().getMerchantData().getInternalNotes().get(i).getAction();
                if (msg.equals("submitted")) {
                    backOPSSide.add(timeChanger.utcToIst((rawResponse.getResult().getMerchantData().getInternalNotes().get(i).getLogTime())));
                } else if (msg.equals("draft")) {
                    rmSide.add(timeChanger.utcToIst(rawResponse.getResult().getMerchantData().getInternalNotes().get(i).getLogTime()));
                }
            }
        }
        timeStampsDTO finAns = new timeStampsDTO();
        finAns.setRmSideStamps(rmSide);
        finAns.setBackOpsStamps(backOPSSide);

        return finAns;
    }
}
