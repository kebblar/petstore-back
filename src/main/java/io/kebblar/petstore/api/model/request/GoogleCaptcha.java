package io.kebblar.petstore.api.model.request;

public class GoogleCaptcha {
    // https://www.google.com/recaptcha/admin/site/315317938/settings
    // arellano.gustavo@gmail.com account
    public static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
    public static final String GOOGLE_RECAPTCHA_SECRET_CODE = "6LffEdkaAAAAAHjf_29VgTHm1RUIgvhnFOAGDN6q";
    private String response;
    private String ip = "127.0.0.1";
    
    public GoogleCaptcha() {
    }
    public GoogleCaptcha(String response) {
        this.response = response;
    }
    public GoogleCaptcha(String response, String ip) {
        this.response = response;
        this.ip = ip;
    }
    public String getResponse() {
        return response;
    }
    public String getIp() {
        return ip;
    }
}
