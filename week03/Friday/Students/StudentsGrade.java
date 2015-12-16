package week03.Friday.Students;

import java.util.ArrayList;
import java.util.Collections;

public class StudentsGrade implements Comparable<StudentsGrade> {
	
	private String name;
	private Integer grade;

	public StudentsGrade(String name, Integer grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String toString(){
		return name + "_" + grade;
	}
	
	public int compareTo(StudentsGrade s) {
		int res; 
		if (grade > s.grade) {
			res = -1;
		} else if (grade == s.grade) {
			res = name.compareTo(s.name);
		} else {
			res = -0;
		}
		return res;
	}
	
	public static void main(String [] Args) {
		
		ArrayList<StudentsGrade> a = new ArrayList<StudentsGrade>();
		
		StudentsGrade Pavel = new StudentsGrade("Pavel", 35);
		StudentsGrade Peter = new StudentsGrade("Peter", 35);
		StudentsGrade Ivan = new StudentsGrade("Ivan", 40);
		StudentsGrade Nasko = new StudentsGrade("Nasko", 100);
		StudentsGrade Boyan = new StudentsGrade("Boyan", 3);
		StudentsGrade Andrey = new StudentsGrade("Andrey", 28);
		a.add(Peter);
		a.add(Pavel);
		a.add(Ivan);
		a.add(Nasko);
		a.add(Boyan);
		a.add(Andrey);
		System.out.println(a);
		Collections.sort(a);
		System.out.println(a);
		
		System.out.println("Pavel".compareTo("Peter"));
	}
}
