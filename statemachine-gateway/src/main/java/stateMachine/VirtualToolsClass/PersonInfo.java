package cn.ruix.stateMachine.VirtualToolsClass;

import java.io.Serializable;

public class PersonInfo implements Serializable {

    private String school;

    private String status;

    private Integer schoolId;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
}
