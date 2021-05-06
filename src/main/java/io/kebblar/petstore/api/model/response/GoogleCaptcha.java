package io.kebblar.petstore.api.model.response;

public class GoogleCaptcha {

    public static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
    public static final String GOOGLE_RECAPTCHA_SECRET_CODE = "6Le5uroaAAAAADen22qpov_2nbZq0zYY0dmg_kxj";
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
