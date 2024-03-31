package hiroo.TalentSourcingSystem;

import hiroo.TalentSourcingSystem.core.utilities.exceptions.BusinessException;
import hiroo.TalentSourcingSystem.core.utilities.exceptions.NotFoundException;
import hiroo.TalentSourcingSystem.core.utilities.exceptions.ProblemDetails;
import hiroo.TalentSourcingSystem.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class TalentSourcingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentSourcingSystemApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.NOT_FOUND)
	public ProblemDetails handleNotFoundException(NotFoundException notFoundException){
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(notFoundException.getMessage());
		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
		ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation.Exception");
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());
		for (FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()
			 ) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());

		}
		return validationProblemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetails NotReadableException(HttpMessageNotReadableException httpMessageNotReadableException){
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(httpMessageNotReadableException.getMessage());
		return problemDetails;
	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
