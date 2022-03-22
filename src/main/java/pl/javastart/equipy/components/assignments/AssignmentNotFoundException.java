package pl.javastart.equipy.components.assignments;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nie znaleziono przypisania o takim ID.")
class AssignmentNotFoundException extends RuntimeException{
}
