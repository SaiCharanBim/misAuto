package com.example.apiTestting.repo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
/*
public class responseModel {
    private Result result;

    // Getters and Setters
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        private MerchantData merchantData;

        // Getters and Setters
        public MerchantData getMerchantData() {
            return merchantData;
        }

        public void setMerchantData(MerchantData merchantData) {
            this.merchantData = merchantData;
        }
    }

    public static class MerchantData {
        private String id;
        private String name;
        private String email;
        private String mobile;
        private List<InternalNote> internalNotes;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public List<InternalNote> getInternalNotes() {
            return internalNotes;
        }

        public void setInternalNotes(List<InternalNote> internalNotes) {
            this.internalNotes = internalNotes;
        }
    }

    public static class InternalNote {
        private String id;
        private Message message;
        private LocalDateTime logTime;
        private String type;
        private String merchantId;
        private String action;
        private String actionBy;
        private String designation;
        private String actionTab;
        private String backopsUserId;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public LocalDateTime getLogTime() {
            return logTime;
        }

        public void setLogTime(LocalDateTime logTime) {
            this.logTime = logTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getActionBy() {
            return actionBy;
        }

        public void setActionBy(String actionBy) {
            this.actionBy = actionBy;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getActionTab() {
            return actionTab;
        }

        public void setActionTab(String actionTab) {
            this.actionTab = actionTab;
        }

        public String getBackopsUserId() {
            return backopsUserId;
        }

        public void setBackopsUserId(String backopsUserId) {
            this.backopsUserId = backopsUserId;
        }
    }

    public static class Message {
        private String instructions;
        private String subject;
        private String reason;

        // Getters and Setters
        public String getInstructions() {
            return instructions;
        }

        public void setInstructions(String instructions) {
            this.instructions = instructions;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}
*/


public class responseModel {
    private Result result;

    // Getters and Setters
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        private MerchantData merchantData;

        // Getters and Setters
        public MerchantData getMerchantData() {
            return merchantData;
        }

        public void setMerchantData(MerchantData merchantData) {
            this.merchantData = merchantData;
        }
    }

    public static class MerchantData {
        public String id;
        public String name;
        public String email;
        public String mobile;
        public List<InternalNote> internalNotes;
        public List<ExecutedRule> executedRules;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public List<InternalNote> getInternalNotes() {
            return internalNotes;
        }

        public void setInternalNotes(List<InternalNote> internalNotes) {
            this.internalNotes = internalNotes;
        }

        public List<ExecutedRule> getExecutedRules() {
            return executedRules;
        }

        public void setExecutedRules(List<ExecutedRule> executedRules) {
            this.executedRules = executedRules;
        }
    }

    public static class InternalNote {
        private String id;
        private Message message;
        private String logTime;
        private String type;
        private String merchantId;
        private String action;
        private String actionBy;
        private String designation;
        private String actionTab;
        private String backopsUserId;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public String getLogTime() {
            return logTime;
        }

        public void setLogTime(String logTime) {
            this.logTime = logTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getActionBy() {
            return actionBy;
        }

        public void setActionBy(String actionBy) {
            this.actionBy = actionBy;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getActionTab() {
            return actionTab;
        }

        public void setActionTab(String actionTab) {
            this.actionTab = actionTab;
        }

        public String getBackopsUserId() {
            return backopsUserId;
        }

        public void setBackopsUserId(String backopsUserId) {
            this.backopsUserId = backopsUserId;
        }
    }

    public static class ExecutedRule {
        private String id;
        private String ruleName;
        private String sourceScreen;
        private String successDestination;
        private String failureDestination;
        private String result;
        private String merchantId;
        private String pageId;
        private String uncertainDestination;
        private String ruleId;
        private String timeStamp;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRuleName() {
            return ruleName;
        }

        public void setRuleName(String ruleName) {
            this.ruleName = ruleName;
        }

        public String getSourceScreen() {
            return sourceScreen;
        }

        public void setSourceScreen(String sourceScreen) {
            this.sourceScreen = sourceScreen;
        }

        public String getSuccessDestination() {
            return successDestination;
        }

        public void setSuccessDestination(String successDestination) {
            this.successDestination = successDestination;
        }

        public String getFailureDestination() {
            return failureDestination;
        }

        public void setFailureDestination(String failureDestination) {
            this.failureDestination = failureDestination;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getPageId() {
            return pageId;
        }

        public void setPageId(String pageId) {
            this.pageId = pageId;
        }

        public String getUncertainDestination() {
            return uncertainDestination;
        }

        public void setUncertainDestination(String uncertainDestination) {
            this.uncertainDestination = uncertainDestination;
        }

        public String getRuleId() {
            return ruleId;
        }

        public void setRuleId(String ruleId) {
            this.ruleId = ruleId;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }
    }

    public static class Message {
        private String instructions;
        private String subject;
        private String reason;

        // Getters and Setters
        public String getInstructions() {
            return instructions;
        }

        public void setInstructions(String instructions) {
            this.instructions = instructions;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}


