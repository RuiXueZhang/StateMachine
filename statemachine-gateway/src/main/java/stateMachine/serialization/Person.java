package stateMachine.serialization;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;

    private int age;


    //没有无参构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "Person{"
                + "name=" + name
                + "age =" + age + ","
                + "}";
    }
}
