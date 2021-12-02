package ch14;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamEx8 {
	public static void main(String[] args) {
		Student1[] stuArr = {
				new Student1("나자바", true,	1, 1, 300),
				new Student1("김지미", false,	1, 1, 250),
				new Student1("김자바", true,	1, 1, 200),
				new Student1("이지미", false,	1, 2, 150),
				new Student1("남자바", true,	1, 2, 100),
				new Student1("안지미", false,	1, 2, 50),
				new Student1("황지미", false,	1, 3, 100),
				new Student1("강지미", false,	1, 3, 150),
				new Student1("이자바", true,	1, 3, 200),
				
				new Student1("나자바", true,	2, 1, 300),
				new Student1("김지미", false,	2, 1, 250),
				new Student1("김자바", true,	2, 1, 200),
				new Student1("이지미", false,	2, 2, 150),
				new Student1("남자바", true,	2, 2, 100),
				new Student1("안지미", false,	2, 2, 50),
				new Student1("황지미", false,	2, 3, 100),
				new Student1("강지미", false,	2, 3, 150),
				new Student1("이자바", true,	2, 3, 200)
		};
		
		System.out.printf("1. 단순 그룹화(반별로 그룹화)%n");
		Map<Integer, List<Student1>> stuByBan = Stream.of(stuArr)
				.collect(groupingBy(Student1::getBan));
		for(List<Student1> ban : stuByBan.values()) {
			for(Student1 s:ban) {
				System.out.println(s);
			}
		}
		
		
		System.out.printf("%n 2. 단순 그룹화(성적별로 그룹화)%n");
		Map<Student1.Level, List<Student1>> stuByLevel = Stream.of(stuArr)
				.collect(groupingBy(s-> {
					if(((Student1) s).getScore() >= 200) return Student1.Level.HIGH;
					else if(((Student1) s).getScore() >= 100) return Student1.Level.MID;
					else return Student1.Level.LOW;
				}));
		TreeSet<Student1.Level> keySet = new TreeSet<>(stuByLevel.keySet());
		for(Student1.Level key : keySet) {
			System.out.println("[" + key + "]");
			for(Student1 s:stuByLevel.get(key)) {
				System.out.println(s);
			}
			System.out.println();
		}


		System.out.printf("%n 3. 단순 그룹화 + 통계(성적별 학생수)%n");
		Map<Student1.Level, Long> stuCntByLevel = Stream.of(stuArr)
				.collect(groupingBy(s-> {
					if(((Student1) s).getScore() >= 200) return Student1.Level.HIGH;
					else if(((Student1) s).getScore() >= 100) return Student1.Level.MID;
					else return Student1.Level.LOW;
				}, counting()));
		for(Student1.Level key : stuCntByLevel.keySet()) 
			System.out.printf("[%s] - %d명,  ", key, stuCntByLevel.get(key));
		System.out.println();

		
//		System.out.printf("%n 4. 다중 그룹화(학년별, 반별)%n");
//		Map<Integer, Map<Integer, Map<Boolean, List<Student1>>>> stuByHakAndBan = 
//				Stream.of(stuArr)
//				.collect(groupingBy(Student1::getHak,
//						groupingBy(Student1::getBan,
//						groupingBy(Student1::isMale))));
//		for(Map<Integer, Map<Boolean, List<Student1>>> hak : stuByHakAndBan.values()) {
//			for(Map<Boolean, List<Student1>> ban : hak.values()) {
//				for(List<Student1> sex : ban.values()) {
//					System.out.println();
//					for(Student1 s: sex) {
//						System.out.println(s);
//					}
//				}
//				System.out.println();
//			}
//		}
		System.out.printf("%n 4. 다중 그룹화(학년별, 반별)%n");
		Map<Integer, Map<Integer, List<Student1>>> stuByHakAndBan = 
				Stream.of(stuArr)
				.collect(groupingBy(Student1::getHak,
						groupingBy(Student1::getBan)));
		for(Map<Integer, List<Student1>> hak : stuByHakAndBan.values()) {
			for(List<Student1> ban : hak.values()) {
				System.out.println();
				for(Student1 s: ban) {
					System.out.println(s);
				}
			}
		}

		
		System.out.printf("%n 5. 다중 그룹화 + 통계(학년별, 반별 1등)%n");
		Map<Integer, Map<Integer, Student1>> topStuByHakBan = 
				Stream.of(stuArr)
				.collect(groupingBy(Student1::getHak,
						groupingBy(Student1::getBan,
								collectingAndThen(
										maxBy(comparingInt(Student1::getScore)),
										Optional::get
										)
								)
						));
		for(Map<Integer, Student1> ban : topStuByHakBan.values())
			for(Student1 s : ban.values())
				System.out.println(s);

		
		System.out.printf("%n 6. 다중 그룹화 + 통계(학년별, 반별 성적 그룹)%n");
		Map<String, Set<Student1.Level>> stuByScoreGroup = Stream.of(stuArr)
				.collect(groupingBy(s-> s.getHak() + "-" + s.getBan(),
						mapping(s -> {
							if(((Student1) s).getScore() >= 200) return Student1.Level.HIGH;
							else if(((Student1) s).getScore() >= 100) return Student1.Level.MID;
							else return Student1.Level.LOW;
						}, toSet())
						));
		Set<String> keySet2 = stuByScoreGroup.keySet();
		for(String key:keySet2) {
			System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
		}		
	}
}
class Student1{
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	public Student1(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	String getName() {
		return name;
	}
	boolean isMale() {
		return isMale;
	}
	int getHak() {
		return hak;
	}
	int getBan() {
		return ban;
	}
	int getScore() {
		return score;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s, %s, %d학년 %d반, %3d점]",
				name, isMale ? "남":"여", hak, ban, score);
	}
	
	enum Level {
		HIGH, MID, LOW
	}
	
}