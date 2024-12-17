package com.subhajit.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.subhajit.model.TeacherSql;

public class SqlMeetsStreamMain {
	
	public static void main(String[] args) {
		
		List<TeacherSql> teacherList = new ArrayList<>();
		
		teacherList.add(new TeacherSql(1, "AK",	"Durgapur",	55000L));
		teacherList.add(new TeacherSql(2, "JMG","Durgapur",	60000L));
		teacherList.add(new TeacherSql(3, "SVB","kolkata",	75000L));
		teacherList.add(new TeacherSql(4, "SR",	"Durgapur",	45000L));
		teacherList.add(new TeacherSql(5, "SB",	"kolkata",	30000L));
		teacherList.add(new TeacherSql(6, "SG",	"Asansol",	40000L));
		
		//System.out.println("Teacher list : " + teacherList);
		
		// SQL query : select TEACHER_CITY, count(*) total_count from TEACHER group by TEACHER_CITY;
		// Result : 
		// Durgapur	3
		// kolkata	2
		
		Map<String, Long> map1 = teacherList
				.stream()
				.collect(Collectors
						.groupingBy(TeacherSql :: getTeacherCity, Collectors.counting()));
		
		System.out.println("map1 : " + map1);
		
		// SQL query : select TEACHER_CITY, sum(TEACHER_SALARY) total_salary from TEACHER group by TEACHER_CITY;
		// Result : 
		// Durgapur	160000
		// kolkata	105000
		
		Map<String, Long> map2 = teacherList
				.stream()
				.collect(Collectors
						.groupingBy(TeacherSql :: getTeacherCity, Collectors.summingLong(TeacherSql :: getTeacherSalary)));
		
		System.out.println("map2 : " + map2);
		
		// SQL query : select TEACHER_CITY, avg(TEACHER_SALARY) total_salary from TEACHER group by TEACHER_CITY;
		// Result : 
		// Durgapur	53333.3333333333333333333333333333333333
		// kolkata	52500
				
		Map<String, Double> map3 = teacherList
					.stream()
					.collect(Collectors
							.groupingBy(TeacherSql :: getTeacherCity, Collectors.averagingDouble(TeacherSql :: getTeacherSalary)));
				
		System.out.println("map3 : " + map3);
		
		// added 1 more record 
		// 6 SG	Asansol	40000
		// SQL query : select TEACHER_CITY, count(*) total_count from TEACHER group by TEACHER_CITY having count(*) > 1;
		// Result : 
		// Durgapur	3
		// kolkata	2
						
		Map<String, Long> map4 = teacherList
					.stream()
					.collect(Collectors
							.groupingBy(TeacherSql :: getTeacherCity, Collectors.counting()));
		map4 = map4.entrySet().stream().filter(record -> record.getValue() > 1).collect(Collectors.toMap(record -> record.getKey(), record -> record.getValue()));
						
		System.out.println("map4 : " + map4);
		
		// SQL query : select TEACHER_CITY, max(TEACHER_SALARY) max_Salary from TEACHER group by TEACHER_CITY;
		// Result : 
		// Durgapur	60000
		// Asansol	40000
		// kolkata	75000
						
		Map<String, Optional<Long>> map5 = teacherList
					.stream()
					.collect(Collectors
							.groupingBy(TeacherSql :: getTeacherCity, 
									Collectors.mapping(TeacherSql :: getTeacherSalary, 
											Collectors.maxBy((s1,s2) -> {return s1.compareTo(s2);}))));
						
		System.out.println("map5 : " + map5);
		
		Map<String, LongSummaryStatistics > map6 = teacherList
				.stream()
				.collect(Collectors
						.groupingBy(TeacherSql :: getTeacherCity, 
								Collectors.summarizingLong(TeacherSql :: getTeacherSalary)));
		Map<String, Long> map7 = map6.entrySet().stream().collect(Collectors.toMap(record -> record.getKey(), record -> record.getValue().getMax()));		
	
		System.out.println("map7 : " + map7);
		
		// SQL query : SELECT * FROM (SELECT TEACHER_ID, TEACHER_NAME, TEACHER_CITY, TEACHER_SALARY, ROW_NUMBER() OVER(ORDER BY TEACHER_SALARY desc) as pos from TEACHER) WHERE pos = 1;
		// Result : 
		// 3 SVB kolkata	75000	1
		TeacherSql teacherWithMaxSal = teacherList
		.stream()
		.collect(Collectors
				.reducing(BinaryOperator
						.maxBy(Comparator
								.comparing(TeacherSql :: getTeacherSalary))))
		.get();
		System.out.println("teacherWithMaxSal : " + teacherWithMaxSal);
		
		// SQL query : SELECT * FROM (SELECT TEACHER_ID, TEACHER_NAME, TEACHER_CITY, TEACHER_SALARY, ROW_NUMBER() OVER(PARTITION BY TEACHER_CITY ORDER BY TEACHER_SALARY desc) as pos from TEACHER) WHERE pos = 1;
		// Result : 
		// 6	SG	Asansol	40000	1
		// 2	JMG	Durgapur	60000	1
		// 3	SVB	kolkata	75000	1
		List<Optional<TeacherSql>> teacherListWIthMaxSalPerCity = teacherList
				.stream()
				.collect(Collectors
						.groupingBy(TeacherSql :: getTeacherCity, Collectors
								.reducing(BinaryOperator
										.maxBy(Comparator
												.comparing(TeacherSql :: getTeacherSalary)))))
		.entrySet()
		.stream()
		.collect(Collectors
				.mapping(record -> record.getValue(), Collectors.toList()));
		
		System.out.println("teacherListWIthMaxSalPerCity : " + teacherListWIthMaxSalPerCity);
		
	}
	
}
// Table columns
//TEACHER_ID
//TEACHER_NAME
//TEACHER_CITY
//TEACHER_SALARY

// Table data
//1	AK	Durgapur	55000
//2	JMG	Durgapur	60000
//3	SVB	kolkata		75000
//4	SR	Durgapur	45000
//5	SB	kolkata		30000
