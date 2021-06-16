package kodlamaio.hrms.core.utilities.exeption;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kodlamaio.hrms.core.utilities.results.ErrorResult;

@ControllerAdvice
public class ExceptionHandle {
	
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        return new ResponseEntity<>(new ErrorResult(ex.getBindingResult().getFieldError().getDefaultMessage()),
	                HttpStatus.NOT_ACCEPTABLE);
	    }
	/*//Validation hataları exeptions.getBindingResult().getFieldError()
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException exeptions) {
	       Map<String,String> validationErrors = new HashMap<String, String>(); 
		   for(FieldError fieldError : exeptions.getBindingResult().getFieldError()) {
			     validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		   }
	       ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hatalı");
	       return errors;
		   
	     //return new ResponseEntity<>(new ErrorResult(),
	                //HttpStatus.NOT_ACCEPTABLE);
	    }
*/
}
