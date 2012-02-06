package clsearcher.web;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import clsearcher.domain.CommandSearchCriteria;

public class CheckBoxValidator implements Validator{
 
	@Override
	public boolean supports(Class clazz) {
		
		return CommandSearchCriteria.class.isAssignableFrom(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
 
		CommandSearchCriteria cust = (CommandSearchCriteria)target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "searchWord", "required.searchWord", "Search word is required");

		if(cust.getCategories().length==0){
			errors.rejectValue("categories", "required.categories", "Please select at least one category");
		}
		if(cust.getRegions().length==0){
			errors.rejectValue("regions", "required.regions", "Please select at least one region");
		}
	}


}
