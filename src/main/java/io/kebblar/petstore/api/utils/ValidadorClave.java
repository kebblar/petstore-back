package io.kebblar.petstore.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.passay.*;

import io.kebblar.petstore.api.model.exceptions.InternalServerException;
import io.kebblar.petstore.api.model.exceptions.StrengthPasswordValidatorException;

public class ValidadorClave {

    private ValidadorClave() {}

    public static boolean validate(String clave) throws StrengthPasswordValidatorException, InternalServerException {
        List<Rule> rules = new ArrayList<>();
        //Rule 1: Password length should be in between
        //8 and 16 characters
        rules.add(new LengthRule(8, 16));
        //Rule 2: No whitespace allowed
        rules.add(new WhitespaceRule());
        //Rule 3.a: At least one Upper-case character
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
        //Rule 3.b: At least one Lower-case character
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        //Rule 3.c: At least one digit
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        //Rule 3.d: At least one special character
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

        Properties props = new Properties();
        InputStream is = ValidadorClave.class.getClassLoader().getResourceAsStream("passay.properties");
        try {
            props.load(is);
        } catch (IOException e) {
            throw new InternalServerException("Ha ocurrido un error en el servidor", e.getMessage());
        }
        MessageResolver resolver = new PropertiesMessageResolver(props);
        PasswordValidator validator = new PasswordValidator(resolver, rules);

        PasswordData password = new PasswordData(clave);
        RuleResult result = validator.validate(password);

        if(!result.isValid()) { // NOT valid !!!!
           List<String> messages = validator.getMessages(result);
           StringBuilder sb = new StringBuilder();
           for(String msg : messages) {
               sb.append(msg);
               sb.append("\n");
           }
           throw new StrengthPasswordValidatorException(sb.toString(), messages);
        }
        return true;
      }
}
