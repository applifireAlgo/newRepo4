package com.app.shared.appinsight.health;
import com.athena.server.pluggable.interfaces.EntityValidatorInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Transient;
import java.lang.Override;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmpDto implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    private Long aday;

    private Long aMonth;

    private Long aYear;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public Long getAday() {
        return aday;
    }

    public void setAday(Long _aday) {
        this.aday = _aday;
    }

    public Long getaMonth() {
        return aMonth;
    }

    public void setaMonth(Long _aMonth) {
        this.aMonth = _aMonth;
    }

    public Long getaYear() {
        return aYear;
    }

    public void setaYear(Long _aYear) {
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
