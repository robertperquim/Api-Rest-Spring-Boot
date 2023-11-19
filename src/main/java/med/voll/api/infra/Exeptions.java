package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class Exeptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handle404Error(){
            return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handle400Error(MethodArgumentNotValidException exception){
        List<FieldError> errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ErrorsValidationData::new).toList());
    }

    //dto para retornar o erro e a mensagem no erro 400
    public record ErrorsValidationData(String name, String message){
        public ErrorsValidationData (FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}