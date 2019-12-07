package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SendDecisionDelegate
 */
@Named("sendDecision")
public class SendDecisionDelegate implements JavaDelegate {

    @Autowired
    private MailService mailService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Integer suitabilityValue = (Integer) execution.getVariable("suitabilityValue");
        String studentId = (String) execution.getVariable("studentId");

        Boolean accepted;
        String subject = "Antrag Auslandsemester ";
        String body = "Ihr Antrag für das Auslandsemester ";

        if(suitabilityValue < 0){
            accepted = false;
        } else {
            accepted = (Boolean) execution.getVariable("approved");
        }

        if(accepted){
            subject += "in erster Instanz bewilligt";
            body += "geht nun in die zweite Runde.";
        } else {
            subject += "abgelehnt";
            body += "wurde abgelehnt.";
        }

        mailService.sendPseudoMail(studentId + "@students.zhaw.ch", subject, body);
    }    
}