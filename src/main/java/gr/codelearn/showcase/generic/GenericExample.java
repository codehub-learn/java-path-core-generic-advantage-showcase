package gr.codelearn.showcase.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public static void main(String[] args) {
        typeSafetyExample();
        upperBoundExample();
    }

    public static void typeSafetyExample(){
        List listError = new ArrayList();
        listError.add("Hello");
        listError.add("World");
//        listError.add(5);

        for (Object o : listError) {
            String str = (String) o;
            System.out.println("The string is: "+str);
        }

        List<String> list = new ArrayList<>();
        list.add("Advantage");
        list.add("CodeHub");
//        list.add(5);
        list.forEach(System.out::println);
    }

    public static void upperBoundExample(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(10);
        integerList.add(15);
        System.out.println("The mean of the integer list is: "+ calculateMean(integerList));


        List<Double> doubleList = new ArrayList<>();
        doubleList.add(5.5);
        doubleList.add(10.5);
        doubleList.add(15.0);
        System.out.println("The mean of the double list is: "+ calculateMean(doubleList));
    }

    private static double calculateMean(List<? extends Number> numbers){
        if (!numbers.isEmpty()){
            return numbers.stream().mapToDouble(Number::doubleValue).average().getAsDouble();
        }
        else {
            return 0;
        }
    }

    public static void lowerBoundExample(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(2.5);

        List<Number> numberList = new ArrayList<>();
        numberList.add(2);

        List<? super Integer> lowerBoundList;
        lowerBoundList = integerList;
        lowerBoundList = numberList;
//        lowerBoundList = doubleList;
    }
}
