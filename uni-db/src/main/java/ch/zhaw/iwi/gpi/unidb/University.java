package ch.zhaw.iwi.gpi.unidb;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * University
 */
@Entity
public class University {

    @Id
    private String institution;
    private String countryCode;
    private String accreditation;

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAccreditation() {
        return accreditation;
    }

    public void setAccreditation(String accreditation) {
        this.accreditation = accreditation;
    }

    
    
}