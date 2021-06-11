package io.kebblar.petstore.api.support;

import io.kebblar.petstore.api.model.exceptions.GoogleCaptchaException;
import io.kebblar.petstore.api.model.request.GoogleCaptcha;

public interface InvokeRestService {
    String checkCaptcha(GoogleCaptcha googleCaptcha) throws GoogleCaptchaException;
    String getBitsoInfo2();
}
