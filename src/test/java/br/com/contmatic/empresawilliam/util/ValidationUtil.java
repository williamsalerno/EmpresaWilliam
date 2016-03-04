package br.com.contmatic.empresawilliam.util;

import java.util.Set;

import javax.validation.*;

import br.com.contmatic.empresawilliam.Telefone;

public final class ValidationUtil {
    
    private ValidationUtil(){
        
    }
    
    public static boolean valida(Object obj, String message){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> errors = validator.validate(obj);
        for(ConstraintViolation<Object> constraintViolation : errors) {
           if(message.equals(constraintViolation.getMessage())){
               return true;
           }
        }
        return false;
        
    }

}
