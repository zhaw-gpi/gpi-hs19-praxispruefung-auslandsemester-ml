package ch.zhaw.iwi.gpi.evento;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * StudentGrades
 */
@Entity
public class StudentGrades {

    @Id
    private String studentId;
    private Double gradeGm;
    private Double gradeInfor;
    private Double gradeLang;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Double getGradeGm() {
        return gradeGm;
    }

    public void setGradeGm(Double gradeGm) {
        this.gradeGm = gradeGm;
    }

    public Double getGradeInfor() {
        return gradeInfor;
    }

    public void setGradeInfor(Double gradeInfor) {
        this.gradeInfor = gradeInfor;
    }

    public Double getGradeLang() {
        return gradeLang;
    }

    public void setGradeLang(Double gradeLang) {
        this.gradeLang = gradeLang;
    }

    
}