package com.subhajit.main;


import java.util.*;
import java.util.stream.Collectors;

public class TestStreamMethods {

    public static void main(String[] args) {
        //reducingScenarios();
        //joiningScenarios();
        //summarizingScenarios();
        //summingScenarios();
        //groupingByScenarios();
        //partitioningByScenarios();
        //maxByMinByScenarios();
        //countingScenarios();
        //averagingScenarios();
        //toListScenarios();
        //toSetScenarios();
        //toMapScenarios();
        collectingAndThenScenarios();

    }

    private static void collectingAndThenScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");

        // collectingAndThen(Collectors, Function)
        // Function : finisher
        // Collectors -> will apply terminal function on the stream capturing it in a list as per this example
        // Finisher will take teh resultant list and shall apply an output logic on the list, size as per this example
        Integer size = list
                .stream()
                .collect(Collectors
                        .collectingAndThen(Collectors.toList(),
                                outputList -> {
                                   return outputList.size();
                                }));

        System.out.println("size : " + size);
    }

    private static void toMapScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");

        // toMap(Function-key, Function-value)
        // If value is repeated in the list, this will throw duplicate key exception
        Map<String, Integer> map1 = list
                    .stream()
                    .collect(Collectors
                        .toMap(name -> name, name -> name.length()));

        System.out.println("toMap(Function-key, Function-value) : " + map1);

        // toMap(Function-key, Function-value, BinaryOperator)
        // BinaryOperator : merger
        // If value is repeated in the list, this will NOT throw duplicate key exception, instead it will merge the values(as mentioned in merger) against the duplicate key
        list.add("Ram");
        Map<String, Integer> map2 = list
                .stream()
                .collect(Collectors
                        .toMap(name -> name, name -> name.length(), (name1, name2) -> name1 + name2));

        System.out.println("toMap(Function-key, Function-value, BinaryOperator) : " + map2);

        // toMap(Function-key, Function-value, BinaryOperator, Supplier)
        Map<String, Integer> map3 = list
                .stream()
                .collect(Collectors
                        .toMap(name -> name, name -> name.length(), (name1, name2) -> name1 + name2, () -> new TreeMap<>()));

        System.out.println("toMap(Function-key, Function-value, BinaryOperator, Supplier : " + map3);
    }

    private static void toSetScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");
        list.add("Ram");

        Set<String> result= list
                .stream()
                .collect(Collectors
                        .toSet());

        System.out.println("result : " + result);
    }

    private static void toListScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");
        list.add("Ram");

        List<String> result= list
                .stream()
                .collect(Collectors
                        .toList());

        System.out.println("result : " + result);
    }

    private static void averagingScenarios() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // averagingInt(ToIntFunction)
        Double averageInt = list
                .stream()
                .collect(Collectors
                        .averagingInt(val -> val));

        System.out.println("averagingInt(ToIntFunction) : " + averageInt);

        // averagingInt(ToDoubleFunction)
        Double averageDouble = list
                .stream()
                .collect(Collectors
                        .averagingDouble(val -> val));

        System.out.println("averagingInt(ToDoubleFunction) : " + averageDouble);

        // averagingLong(ToLongFunction)
        Double averageLong = list
                .stream()
                .collect(Collectors
                        .averagingLong(val -> val));

        System.out.println("averagingLong(ToLongFunction) : " + averageLong);
    }

    private static void countingScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");
        list.add(null);

        Long count = list
                .stream()
                .collect(Collectors
                        .counting());

        System.out.println("count : " + count);
    }

    private static void maxByMinByScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");

        Optional<String> max = list
                .stream()
                .collect(Collectors
                        .maxBy((name1, name2) -> name1.length() - name2.length()));

        System.out.println("MAX : " + max);

        Optional<String> min = list
                .stream()
                .collect(Collectors
                        .minBy((name1, name2) -> name1.length() - name2.length()));

        System.out.println("MIN : " + min);


    }

    // partitioningBy works same as groupingBy, the difference being it divides the stream into two parts true and false as map keys and corresponding values against those keys
    // variations : 2
    private static void partitioningByScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");

        // partitioningBy(Predicate)
        Map<Boolean, List<String>> result1 = list
                .stream()
                .collect(Collectors
                        .partitioningBy(name -> name.matches("S(.*)")));

        System.out.println("partitioningBy(Predicate) : " + result1);

        // partitioningBy(Predicate, Collectors)
        // Collectors : downstream
        Map<Boolean, Long> result2 = list
                .stream()
                .collect(Collectors
                        .partitioningBy(name -> name.matches("S(.*)"), Collectors.counting()));

        System.out.println("partitioningBy(Predicate, Collectors) : " + result2);
    }

    // groupingBy consumes the given stream and splits the same based on the return value of the Function and returns a Map consisting of the returned function value as well as the corresponding elements in form of list
    // variations : 3
    private static void groupingByScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");

        // groupingBy(Function)
        Map<String, List<String>> result1 = list
                .stream()
                .collect(Collectors
                        .groupingBy(name -> name.substring(0,1)));

        System.out.println("groupingBy(Function) : " + result1);

        // groupingBy(Function, Collectors)
        // Collectors -> downstream
        Map<String, Long> result2 = list
                .stream()
                .collect(Collectors
                        .groupingBy(name -> name.substring(0,1), Collectors.counting()));

        System.out.println("groupingBy(Function, Collectors) : " + result2);

        // groupingBy(Function, Supplier, Collectors)
        // Collectors -> downstream
        Map<String, Long> result3 = list
                .stream()
                .collect(Collectors
                        .groupingBy(name -> name.substring(0,1), () -> new TreeMap<>(),Collectors.counting()));

        System.out.println("groupingBy(Function, Supplier, Collectors) : " + result3);


    }

    // summing consumes the stream and return the summation
    // variations : 3
    private static void summingScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");

        // summingInt(ToIntFunction)
        Integer sum1 = list
                .stream()
                .collect(Collectors
                        .summingInt(name -> name.length()));

        System.out.println("summingInt(ToIntFunction) : " + sum1);

        // summingDouble(ToDoubleFunction)
        Double sum2 = list
                .stream()
                .collect(Collectors
                        .summingDouble(name -> name.length()));

        System.out.println("summingDouble(ToDoubleFunction) : " + sum1);

        // summingLong(ToLongFunction)
        Long sum3 = list
                .stream()
                .collect(Collectors
                        .summingLong(name -> name.length()));

        System.out.println("summingLong(ToLongFunction) : " + sum3);
    }

    // summarizing consumes the stream and return results of count, sum, min, average, max
    // variations : 3
    private static void summarizingScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");

        // summarizingInt(ToIntFunction)
        IntSummaryStatistics result1 = list
                .stream()
                .collect(Collectors
                        .summarizingInt(name -> name.length()));

        System.out.println("count | ToIntFunction : " + result1.getCount());
        System.out.println("sum | ToIntFunction : " + result1.getSum());
        System.out.println("min | ToIntFunction : " + result1.getMin());
        System.out.println("average | ToIntFunction : " + result1.getAverage());
        System.out.println("max | ToIntFunction : " + result1.getMax());
        System.out.println("--------------------------------------------------------");

        // summarizingInt(ToDoubleFunction)
        DoubleSummaryStatistics result2 = list
                .stream()
                .collect(Collectors
                        .summarizingDouble(name -> name.length()));

        System.out.println("count | ToDoubleFunction : " + result2.getCount());
        System.out.println("sum | ToDoubleFunction : " + result2.getSum());
        System.out.println("min | ToDoubleFunction : " + result2.getMin());
        System.out.println("average | ToDoubleFunction : " + result2.getAverage());
        System.out.println("max | ToDoubleFunction : " + result2.getMax());
        System.out.println("--------------------------------------------------------");

        // summarizingInt(ToLongFunction)
        LongSummaryStatistics result3 = list
                .stream()
                .collect(Collectors
                        .summarizingLong(name -> name.length()));

        System.out.println("count | ToLongFunction : " + result2.getCount());
        System.out.println("sum | ToLongFunction : " + result2.getSum());
        System.out.println("min | ToLongFunction : " + result2.getMin());
        System.out.println("average | ToLongFunction : " + result2.getAverage());
        System.out.println("max | ToLongFunction : " + result2.getMax());

    }

    // joining takes 1 stream element at a time and appends them altogether
    // variations : 3
    private static void joiningScenarios() {
        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");

        // joining
        String result = list
                .stream()
                .collect(Collectors.joining());

        System.out.println("Stream | non-empty-list | joining : " + result);

        result = list
                .parallelStream()
                .collect(Collectors.joining());

        System.out.println("Parallel stream | non-empty-list | joining : " + result);

        List<String> emptyList = new ArrayList<>();

        result = emptyList
                .stream()
                .collect(Collectors.joining());

        System.out.println("Stream | empty-list | joining : " + result);


        // joining(delimeter)
        result = list
                .stream()
                .collect(Collectors.joining(";"));

        System.out.println("Stream | non-empty-list | joining(delimeter) : " + result);

        // joining(delimeter, prefix, suffix)
        result = list
                .stream()
                .collect(Collectors.joining(";", "Prefix" ,"Suffix"));

        System.out.println("Stream | non-empty-list | joining(delimeter, prefix, suffix) : " + result);


    }

    // reducing takes stream elements 2 at a time and it returns a single result. eg : a running sum kindof
    // variations : 3
    private static void reducingScenarios() {

        List<String> list = new ArrayList<>();

        list.add("Asim");
        list.add("Subhajit");
        list.add("Suman");
        list.add("Ram");
        list.add("Sourav");

        // reducing(Binary operator)
        // takes 2 names at a time and return a single result appending 2 names each iteration
        Optional<String> optionalResult = list
                .stream()
                .collect(Collectors
                        .reducing((name1, name2) -> name1 + " - " + name2));

        System.out.println("Stream | non-empty-list | reducing(Binary operator) : " + optionalResult.get());

        List<String> emptyList = Collections.emptyList();
        optionalResult = emptyList
                .stream()
                .collect(Collectors
                        .reducing((name1, name2) -> name1 + " - " + name2));

        System.out.println("Stream | empty-list | reducing(Binary operator) : " + optionalResult);

        optionalResult = list
                .parallelStream()
                .collect(Collectors
                        .reducing((name1, name2) -> name1 + " - " + name2));

        System.out.println("Parallel stream | non-empty-list | reducing(Binary operator) : " + optionalResult.get());

        // reducing(identity, Binary operator)
        // identity is the prefix cum default value
        String result = list
                .stream()
                .collect(Collectors
                        .reducing("Prefix", (name1, name2) -> name1 + " - " + name2));

        System.out.println("Stream | non-empty-list | reducing(identity, Binary operator) : " + result);

        result = emptyList
                .stream()
                .collect(Collectors
                        .reducing("Prefix", (name1, name2) -> name1 + " - " + name2));

        System.out.println("Stream | empty-list | reducing(identity, Binary operator) : " + result);

        result = list
                .parallelStream()
                .collect(Collectors
                        .reducing("Prefix", (name1, name2) -> name1 + " - " + name2));

        System.out.println("Parallel stream | non-empty-list | reducing(identity, Binary operator) : " + result);

        // reducing(identity, function, Binary operator)
        // identity is the prefix cum default value
        // function acts like accumulator for parallel stream results, i.e it combines BinaryOperator results from parallel streams and combines them into single result
        result = list
                .stream()
                .collect(Collectors
                        .reducing("Prefix", name -> name.toUpperCase(),(name1, name2) -> name1 + " + " + name2));

        System.out.println("Stream | non-empty-list | reducing(identity, function, Binary operator) : " + result);

        result = list
                .stream()
                .collect(Collectors
                        .reducing("Prefix", name -> name.toUpperCase(),(name1, name2) -> name1 + " + " + name2));

        System.out.println("Parallel stream | non-empty-list | reducing(identity, function, Binary operator) : " + result);


    }
}
