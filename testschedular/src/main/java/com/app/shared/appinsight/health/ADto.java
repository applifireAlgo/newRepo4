package com.app.shared.appinsight.health;
import com.athena.server.pluggable.interfaces.EntityValidatorInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Transient;
import java.lang.Override;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ADto implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    private String aDay;

    private String aMonth;

    private String aYear;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public String getaDay() {
        return aDay;
    }

    public void setaDay(String _aDay) {
        this.aDay = _aDay;
    }

    public String getaMonth() {
        return aMonth;
    }

    public void setaMonth(String _aMonth) {
        this.aMonth = _aMonth;
    }

    public String getaYear() {
        return aYear;
    }

    public void setaYear(String _aYear) {
        this.aYear = _aYear;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.dtoValidator = _validateFactory;
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SecurityException {
        boolean isValid = false;
        if (this.dtoValidator != null) {
            isValid = this.dtoValidator.validateEntity(this);
            this.isDtoValidated = true;
        } else {
            throw new SecurityException();
        }
        return isValid;
    }
}
