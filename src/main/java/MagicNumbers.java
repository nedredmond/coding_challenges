import java.util.*;

public class MagicNumbers {

    public static void main(String[] args) {
        String line = "100 1000";
        String[] input = line.split(" ");

        for (int i=Integer.parseInt(input[0]); i<=Integer.parseInt(input[1]); i++) {
            int[] digitArray = getDigitArray(i);
            if (digitArray.length == 0) {
                System.out.println(-1);
            }
            if (doesNotRepeat(digitArray) && rotates(digitArray))
                System.out.println(i);
        }
    }

    private static int[] getDigitArray(int number) {
        String[] digitStringArray = Integer.toString(number).split("");
        int[] digitArray = new int[digitStringArray.length];
        for (int i=0; i<digitArray.length; i++)
            digitArray[i] = Integer.parseInt(digitStringArray[i]);
        return digitArray;
    }

    private static boolean doesNotRepeat(int[] digitArray) {
        boolean doesNotRepeat = true;
        Set<Integer> digits = new HashSet<>();
        for (int i : digitArray)
            if (!digits.add(i))
                doesNotRepeat = false;
        return doesNotRepeat;
    }

    private static boolean rotates(int[] digitArray) {
        boolean rotates = true;
        int index = 0;
        Set<Integer> indices = new HashSet<>();
        for (int i=0; i<digitArray.length; i++) {
            index = (digitArray[index] + index) % digitArray.length;
            if (!indices.add(index)) {
                rotates = false;
                break;
            }
        }
        return rotates;
    }
}
