package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * CheckAccreditationDelegate
 */
@Named("checkAccreditation")
public class CheckAccreditationDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String universityName = (String) execution.getVariable("universityName");

        RestTemplate rt = new RestTemplate();

        String accreditation;
        try {
            University university = rt.getForObject("http://localhost:8090/unidb/university/{institution}", University.class, universityName);
            accreditation = (university.getAccreditation().equals("") ? "Keine" : university.getAccreditation());
        } catch (HttpClientErrorException e) {
            accreditation = "Unbekannt";
        }

        execution.setVariable("accreditation", accreditation);
    }

    
}