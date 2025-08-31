package tutorials.comparator_tutorials;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class IntSortDesc implements Comparator<Integer>{
	
	@Override
	public int compare(Integer num1, Integer num2) {
		return num2 - num1;
	}
}

class IntSortAsc implements Comparator<Integer>{
	
	@Override
	public int compare(Integer num1, Integer num2) {
		return num1 - num2;
	}

}

public class ComparatorTutorialsInt {
	public static void ascSortWithNull() {
		List<Integer> nums = new ArrayList<>();
        nums.add(10000);
        nums.add(100);
        nums.add(10);
        nums.sort(null);
        System.out.println("ascSortWithNull: " + nums);
        // ascSortWithNull: [10, 100, 10000]
	}
	
	public static void ascSortWithComparatorImpl() {
		List<Integer> nums = new ArrayList<>();
        nums.add(10000);
        nums.add(100);
        nums.add(10);
        nums.sort(new IntSortAsc());
        System.out.println("ascSortWithComparatorImpl: " + nums);
        // ascSortWithComparatorImpl: [10, 100, 10000]
	}
	
	public static void descSortWithComparatorImpl() {
		List<Integer> nums = new ArrayList<>();
        nums.add(10000);
        nums.add(100);
        nums.add(10);
        nums.sort(new IntSortDesc());
        System.out.println("descSortWithComparatorImpl: " + nums);
        // descSortWithComparatorImpl: [10000, 100, 10]
	}
	
	public static void ascSortWithComparatorLambda() {
		List<Integer> nums = new ArrayList<>();
        nums.add(10000);
        nums.add(100);
        nums.add(10);
        nums.sort((a,b) -> a - b);
        System.out.println("ascSortWithComparatorLambda: " + nums);
        // ascSortWithComparatorLambda: [1, 100, 10000]
	}
	public static void descSortWithComparatorLambda() {
		List<Integer> nums = new ArrayList<>();
        nums.add(10000);
        nums.add(100);
        nums.add(10);
        nums.sort((a,b) -> b - a);
        System.out.println("descSortWithComparatorLambda: " + nums);
        // descSortWithComparatorLambda: [10000, 100, 10]
	}
    public static void main(String[] args) {
       
    	ComparatorTutorialsInt.ascSortWithNull();
    	ComparatorTutorialsInt.ascSortWithComparatorImpl();
    	ComparatorTutorialsInt.descSortWithComparatorImpl();
    	ComparatorTutorialsInt.descSortWithComparatorLambda();
        
    }
}
