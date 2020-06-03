package cn.ruix.Stream;

import java.util.*;

/**
 * Stream reduction Operation学习
 *
 * reduction Operation 归约运算：可以理解为将将同种对象：归类，约简
 *
 * source:  java.util.stream
 * since: 1.8
 */
public class ReductionOperation {

    public static void main(String[] args) {


    List<Integer> numbers = new LinkedList<>();
    numbers.add(1);
    numbers.add(22);
    numbers.add(333);
    numbers.add(4444);

    List<Heavy> heavies = new ArrayList<>();
    heavies.add(new Heavy("h1",34));
    heavies.add(new Heavy("h2",56));
    heavies.add(new Heavy("h3", 99));

//  example:  sequential loops
    int sum = 0;
    for(int s : numbers){
        sum = s + sum;
    }

//   Stream
     sum = numbers.stream().reduce(0, (x,y)-> x+y);

     sum = numbers.stream().reduce(0, Integer::sum);

     sum = numbers.parallelStream().reduce(0, Integer::sum);


//    归约操作（max())与其他（mapToInt)结合使用,代替批量循环
     OptionalInt heaviest = heavies.parallelStream()
             .mapToInt(Heavy::getHeavy)
             .max();

     System.out.println(heaviest);

     System.out.println(Integer.parseInt(null));
}
}
