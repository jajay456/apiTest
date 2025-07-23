package com.example.apitest.dto;

public class TokenResponse {
    private String responseCode;
    private String responseMessage;
    private ResponseData responseData;

    public TokenResponse(String responseCode, String responseMessage, ResponseData responseData) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseData = responseData;
    }

    public String getResponseCode() { return responseCode; }
    public void setResponseCode(String responseCode) { this.responseCode = responseCode; }

    public String getResponseMessage() { return responseMessage; }
    public void setResponseMessage(String responseMessage) { this.responseMessage = responseMessage; }

    public ResponseData getResponseData() { return responseData; }
    public void setResponseData(ResponseData responseData) { this.responseData = responseData; }

    public static class ResponseData {
        private String userId;
        private String tokenId;

        public ResponseData(String userId, String tokenId) {
            this.userId = userId;
            this.tokenId = tokenId;
        }

        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }

        public String getTokenId() { return tokenId; }
        public void setTokenId(String tokenId) { this.tokenId = tokenId; }
    }
}

