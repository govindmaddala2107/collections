package tutorials.comparator_tutorials;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class StringSortDesc implements Comparator<String>{
	
	@Override
	public int compare(String w1, String w2) {
		return w2.length() - w1.length();
	}
}

class StringSortAsc implements Comparator<String>{
	
	@Override
	public int compare(String w1, String w2) {
		return w1.length() - w2.length();
	}
}

public class ComparatorTutorialsString {
	
	public static void sortWithNull() {
		List<String> words = Arrays.asList("banana", "cat", "a", "app", "bad");
		words.sort(null);
		System.out.println("sortWithNull: " + words);
		// sortWithNull: [a, app, bad, banana, cat]
	}
	
	public static void sortAscWithImpl() {
		List<String> words = Arrays.asList("Aaaaa5", "Aaa3", "A1");
		words.sort(new StringSortAsc());
		System.out.println("sortAscWithImpl: " + words);
		// sortAscWithImpl: [A1, Aaa3, Aaaaa5]
	}
	
	public static void sortAscWithLambda() {
		List<String> words = Arrays.asList("Aaaaa5", "Aaa3", "A1");
		words.sort((a,b)-> a.length() - b.length());
		System.out.println("sortAscWithLambda: " + words);
		// sortAscWithLambda: [A1, Aaa3, Aaaaa5]
	}
	
	public static void sortDescWithImpl() {
		List<String> words = Arrays.asList("Aaaaa5", "Aaa3", "A1", "Aaaaaaa7");
		words.sort(new StringSortDesc());
		System.out.println("sortDescWithImpl: " + words);
		// sortDescWithImpl: [Aaaaaaa7, Aaaaa5, Aaa3, A1]
	}
	
	public static void sortDescWithLambda() {
		List<String> words = Arrays.asList("Aaaaa5", "Aaa3", "A1", "Aaaaaaa7");
		words.sort((a,b)-> b.length() - a.length());
		System.out.println("sortDescWithLambda: " + words);
		// sortDescWithLambda: [Aaaaaaa7, Aaaaa5, Aaa3, A1]
	}
	
	public static void main(String[] args) {
		ComparatorTutorialsString.sortWithNull();
		ComparatorTutorialsString.sortAscWithImpl();
		ComparatorTutorialsString.sortAscWithLambda();
		ComparatorTutorialsString.sortDescWithImpl();
		ComparatorTutorialsString.sortDescWithLambda();
	}
}
