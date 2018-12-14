package in.tcampus.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandeler extends ResponseEntityExceptionHandler{
	
	
	// handles all the exceptions.
	@ExceptionHandler(Exception.class) //note here we are providing the class we want to catch exception of type
	public final ResponseEntity<Object> HandleAllExceptions(Exception ex, WebRequest request){		
		ExceptionDetails genericException =new ExceptionDetails(new Date(),ex.getMessage(),request.getDescription(false));		
		return new ResponseEntity(genericException,HttpStatus.INTERNAL_SERVER_ERROR) ;		
	}
	
	//handles only UserNotFoundException
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> HandleUserNotFoundException(UserNotFoundException ex, WebRequest request){		
			ExceptionDetails genericException =new ExceptionDetails(new Date(),ex.getMessage(),request.getDescription(false));		
			return new ResponseEntity(genericException,HttpStatus.NOT_FOUND) ;				
	}
}
