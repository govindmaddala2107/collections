package tutorials.comparator_tutorials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
	private String name;
	private double gpa;
	
	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public double getGpa() {
		return gpa;
	}

	@Override
	public String toString() {
		return name + " : " + gpa;
	}
	
}

public class ComparatorTutorialsClass {
	
	public static List<Student> setData() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Dharma", 3.5));
		students.add(new Student("Bobby", 3.8));
		students.add(new Student("Chaitanya", 4.5));
		students.add(new Student("Anirudh", 3.5));
		return students;
	}
	
	public static void naturalSorting() {
		List<Student> students = setData();
		try {
			students.sort(null);
			System.out.println("naturalSorting: " + students);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		/*
		 
		 Exception: class tutorials.comparator_tutorials.Student 
		 cannot be cast to class java.lang.Comparable 
		 (tutorials.comparator_tutorials.Student is in unnamed module of loader 'app'; 
		 java.lang.Comparable is in module java.base of loader 'bootstrap') 
		 
		 */
		
	}
	
	public static void ascByGpaWithComparatorLambda() {
		List<Student> students = setData();
		
		//ascending, so a-b
		students.sort((a, b) -> {
			if(a.getGpa() - b.getGpa() > 0) return 1;
			if(a.getGpa() - b.getGpa() < 0) return -1;
			return 0;
		});
		System.out.println("ascByGpaWithComparatorLambda: " + students);
		
		/* ascByGpaWithComparatorLambda: 
		 * Dharma, gpa=3.5 
		 * Anirudh, gpa=3.5 
		 * Bobby, gpa=3.8 
		 * Chaitanya, gpa=4.5
		 */
		
	}
	
	public static void ascByGpaWithComparatorLambdaAndNamesOnEqualWithCompareTo() {
		List<Student> students = setData();
		
		//ascending, so a-b
		students.sort((a, b) -> {
			if(a.getGpa() - b.getGpa() > 0) return 1;
			if(a.getGpa() - b.getGpa() < 0) return -1;
			
			// On equal of gpa, we want to sort by bame
			return a.getName().compareTo(b.toString());
		});
		System.out.println("ascByGpaWithComparatorLambdaAndNamesOnEqualWithCompareTo: " + students);
		
		/* ascByGpaWithComparatorLambdaAndNamesOnEqualWithCompareTo: 
			 Anirudh : 3.5, 
			 Dharma : 3.5, 
			 Bobby : 3.8, 
			 Chaitanya : 4.5
		 */
		
	}
	
	public static void ascUsingComparingWithGpa() {
		List<Student> students = setData();
		Comparator<Student> comparator = Comparator.comparing(Student::getGpa);
		students.sort(comparator);
		System.out.println("ascUsingComparingWithGpa: " + students);
		/*
		 * Dharma : 3.5, 
		 * Anirudh : 3.5, 
		 * Bobby : 3.8, 
		 * Chaitanya : 4.5
		 */
	}
	
	public static void descUsingComparingWithGpa() {
		List<Student> students = setData();
		Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed();
		students.sort(comparator);
		System.out.println("descUsingComparingWithGpa: " + students);
		/*
		 Chaitanya : 4.5, 
		 Bobby : 3.8, 
		 Dharma : 3.5, 
		 Anirudh : 3.5
		 */
	}

	public static void descUsingComparingWithGpaAndNames() {
		List<Student> students = setData();
		Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
		students.sort(comparator);
		System.out.println("descUsingComparingWithGpaAndNames: " + students);
		/*
		 Chaitanya : 4.5, 
		 Bobby : 3.8,
		 Anirudh : 3.5, 
		 Dharma : 3.5
		 */
	}
	
	public static void descUsingComparingWithGpaAndNamesUsingCollections() {
		List<Student> students = setData();
		Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
//		students.sort(comparator);
		Collections.sort(students, comparator);
		System.out.println("descUsingComparingWithGpaAndNamesUsingCollections: " + students);
		/*
		 Chaitanya : 4.5, 
		 Bobby : 3.8,
		 Anirudh : 3.5, 
		 Dharma : 3.5
		 */
	}
	
	public static void main(String[] args) {
		ComparatorTutorialsClass.naturalSorting();   // Error
		ComparatorTutorialsClass.ascByGpaWithComparatorLambda();
		ComparatorTutorialsClass.ascByGpaWithComparatorLambdaAndNamesOnEqualWithCompareTo();
		ComparatorTutorialsClass.ascUsingComparingWithGpa();
		ComparatorTutorialsClass.descUsingComparingWithGpa();
		ComparatorTutorialsClass.descUsingComparingWithGpaAndNames();
		ComparatorTutorialsClass.descUsingComparingWithGpaAndNamesUsingCollections();
	}

}
