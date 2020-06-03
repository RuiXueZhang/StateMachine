package stateMachine.serialization;

import java.io.*;

/**
 * 普通读序列化测试
 * 从文件中读出对象
 */
public class ReadObject {

    public static  void main(String[] args) {
        ObjectInputStream fis;

        {
            try {
                fis = new ObjectInputStream(new FileInputStream("serializationPerson.txt"));

                Person person = (Person) fis.readObject();

                System.out.println(person);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
