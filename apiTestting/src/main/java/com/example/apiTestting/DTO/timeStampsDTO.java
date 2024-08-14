package com.example.apiTestting.DTO;

import java.util.List;

public class timeStampsDTO {
    List<String> rmSideStamps;
    List<String>backOpsStamps;

    public List<String> getRmSideStamps() {
        return rmSideStamps;
    }

    public void setRmSideStamps(List<String> rmSideStamps) {
        this.rmSideStamps = rmSideStamps;
    }

    public List<String> getBackOpsStamps() {
        return backOpsStamps;
    }

    public void setBackOpsStamps(List<String> backOpsStamps) {
        this.backOpsStamps = backOpsStamps;
    }
}
