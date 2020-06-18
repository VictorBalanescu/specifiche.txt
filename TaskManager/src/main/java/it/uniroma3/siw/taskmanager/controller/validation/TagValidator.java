package it.uniroma3.siw.taskmanager.controller.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.taskmanager.model.Tag;

@Component
public class TagValidator implements Validator{
	final Integer MAX_NAME_LENGTH = 100;
    final Integer MIN_NAME_LENGTH = 2;
    final Integer MAX_DESC_LENGTH = 100;

    @Override
    public void validate(Object o, Errors errors) {
        Tag tag = (Tag) o;
        String nome = tag.getNome().trim();
        String descrizione= tag.getDescrizione().trim();

        if (nome.isBlank())
            errors.rejectValue("nome", "required");
        else if (nome.length() < MIN_NAME_LENGTH || nome.length() > MAX_NAME_LENGTH)
            errors.rejectValue("nome", "size");

        if (descrizione.isBlank())
            errors.rejectValue("descrizione", "required");
        else if (descrizione.length() >MAX_DESC_LENGTH)
            errors.rejectValue("descrizione", "size");
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Tag.class.equals(clazz);
    }


}
