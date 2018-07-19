package Tomcat_EE;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.time.LocalDate;

public class CheckDates implements ConstraintValidator<SynchronizeDates,Validator_Class> {

    @Override
    public void initialize(SynchronizeDates synchronizeDates) {

    }

    @Override
    public boolean isValid(Validator_Class validator_class, ConstraintValidatorContext constraintValidatorContext) {
        return validator_class.birthDate.isBefore(validator_class.deathDate);
    }

}
