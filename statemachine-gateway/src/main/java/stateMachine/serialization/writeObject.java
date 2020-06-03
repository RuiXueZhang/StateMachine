package stateMachine.serialization;

import java.io.*;

/**
 * 普通序列化测试
 * 写一个对象到文件里
 */
public class writeObject {

    public static  void main(String[] args) throws IOException {


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("serializationPerson.txt")));

        Person person = new Person("Ruix",22);

        oos.writeObject(person);
    }
}
