package ch14;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamEx8 {
	public static void main(String[] args) {
		Student1[] stuArr = {
				new Student1("���ڹ�", true,	1, 1, 300),
				new Student1("������", false,	1, 1, 250),
				new Student1("���ڹ�", true,	1, 1, 200),
				new Student1("������", false,	1, 2, 150),
				new Student1("���ڹ�", true,	1, 2, 100),
				new Student1("������", false,	1, 2, 50),
				new Student1("Ȳ����", false,	1, 3, 100),
				new Student1("������", false,	1, 3, 150),
				new Student1("���ڹ�", true,	1, 3, 200),
				
				new Student1("���ڹ�", true,	2, 1, 300),
				new Student1("������", false,	2, 1, 250),
				new Student1("���ڹ�", true,	2, 1, 200),
				new Student1("������", false,	2, 2, 150),
				new Student1("���ڹ�", true,	2, 2, 100),
				new Student1("������", false,	2, 2, 50),
				new Student1("Ȳ����", false,	2, 3, 100),
				new Student1("������", false,	2, 3, 150),
				new Student1("���ڹ�", true,	2, 3, 200)
		};
		
		System.out.printf("1. �ܼ� �׷�ȭ(�ݺ��� �׷�ȭ)%n");
		Map<Integer, List<Student1>> stuByBan = Stream.of(stuArr)
				.collect(groupingBy(Student1::getBan));
		for(List<Student1> ban : stuByBan.values()) {
			for(Student1 s:ban) {
				System.out.println(s);
			}
		}
		
		
		System.out.printf("%n 2. �ܼ� �׷�ȭ(�������� �׷�ȭ)%n");
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


		System.out.printf("%n 3. �ܼ� �׷�ȭ + ���(������ �л���)%n");
		Map<Student1.Level, Long> stuCntByLevel = Stream.of(stuArr)
				.collect(groupingBy(s-> {
					if(((Student1) s).getScore() >= 200) return Student1.Level.HIGH;
					else if(((Student1) s).getScore() >= 100) return Student1.Level.MID;
					else return Student1.Level.LOW;
				}, counting()));
		for(Student1.Level key : stuCntByLevel.keySet()) 
			System.out.printf("[%s] - %d��,  ", key, stuCntByLevel.get(key));
		System.out.println();

		
//		System.out.printf("%n 4. ���� �׷�ȭ(�г⺰, �ݺ�)%n");
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
		System.out.printf("%n 4. ���� �׷�ȭ(�г⺰, �ݺ�)%n");
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

		
		System.out.printf("%n 5. ���� �׷�ȭ + ���(�г⺰, �ݺ� 1��)%n");
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

		
		System.out.printf("%n 6. ���� �׷�ȭ + ���(�г⺰, �ݺ� ���� �׷�)%n");
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
		return String.format("[%s, %s, %d�г� %d��, %3d��]",
				name, isMale ? "��":"��", hak, ban, score);
	}
	
	enum Level {
		HIGH, MID, LOW
	}
	
}