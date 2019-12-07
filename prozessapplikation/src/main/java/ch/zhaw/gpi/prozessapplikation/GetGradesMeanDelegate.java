package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

/**
 * GetGradesMeanDelegate
 */
@Named("getGradesMean")
public class GetGradesMeanDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String studentId = (String) execution.getVariable("studentId");

        RestTemplate rt = new RestTemplate();

        StudentGrades grades = rt.getForObject("http://localhost:8070/evapi/studentgrades/{studentId}", StudentGrades.class, studentId);

        Double gradesMean = (2*grades.getGradeGm() + 2*grades.getGradeInfor() + 1*grades.getGradeLang()) / 5;

        execution.setVariable("gradesMean", gradesMean);

    }

    
}