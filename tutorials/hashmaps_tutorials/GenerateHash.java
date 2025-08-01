package tutorials.hashmaps_tutorials;

public class GenerateHash {
    public static void main(String[] args) {
        System.out.println(createHash("ABC"));   // 8
        System.out.println(createHash("BCA"));   // 8
        System.out.println(createHash("CAB"));   // 8
    }

    public static int createHash(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += (int) c;
        }
        return sum % 10;
    }
}
