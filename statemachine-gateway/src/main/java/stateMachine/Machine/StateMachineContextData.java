package cn.ruix.stateMachine.Machine;

import cn.ruix.stateMachine.VirtualToolsClass.Person;
import cn.ruix.stateMachine.VirtualToolsClass.PersonInfo;

import java.io.Serializable;

public class StateMachineContextData implements Serializable{

    private Person person;

    private PersonInfo personInfo;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
