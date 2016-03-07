package br.com.contmatic.empresawilliam.util;

import java.util.Set;

import javax.validation.*;

public final class ValidationUtil {
    
    private ValidationUtil(){
        
    }
    
    public static boolean hasErrors(Object obj, String message){
        if(message != null){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> errors = validator.validate(obj);
        for(ConstraintViolation<Object> constraintViolation : errors) {
           if(message.equals(constraintViolation.getMessage())){
               return true;
           }
        }
        }
        return false;
        
    }

}
