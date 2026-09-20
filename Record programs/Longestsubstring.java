import java.util.Scanner;

public class LongestSubstring {

    static String findLongest(String str) {
        String longest = "";

        for (int i = 0; i < str.length(); i++) {
            String current = "";

            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);

                // Check whether character is already present
                if (current.indexOf(ch) != -1) {
                    break;
                }

                current = current + ch;

                // Store the longest substring
                if (current.length() > longest.length()) {
                    longest = current;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String longest = findLongest(str);

        System.out.println("Length: " + longest.length());
        System.out.println("Longest substring: " + longest);

        sc.close();
    }
}
