package br.com.contmatic.empresawilliam.util;

import java.util.Set;

import javax.validation.*;

public final class ValidationUtil {
    
    private ValidationUtil(){
        
    }
    
    public static boolean valida(Object obj, String message){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> errors = validator.validate(obj);
        return false;
        
    }

}
