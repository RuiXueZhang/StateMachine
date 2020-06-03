package stateMachine.VirtualToolsClass;

import cn.ruix.stateMachine.StateAndEvent.StateType;

import java.io.Serializable;

public class Person  extends cn.ruix.stateMachine.VirtualToolsClass.PersonInfo {

   private Integer userId;

   private String name;

   private Integer age;

   private String sex;

   private Long phone;

   private StateType stateType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public StateType getStateType() {
        return stateType;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
