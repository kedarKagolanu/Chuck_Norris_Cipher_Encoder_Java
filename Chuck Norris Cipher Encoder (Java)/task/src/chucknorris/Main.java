import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input string:");
        String inputString = in.nextLine();

        System.out.println("\nThe result:");
        String binaryString = stringToBinary(inputString);
        String chuckNorrisEncodedString = encodeToChuckNorris(binaryString);
        System.out.println(chuckNorrisEncodedString);
    }

    // Converts a string to its corresponding binary representation
    public static String stringToBinary(String inputString) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            String binaryString = Integer.toBinaryString(c);
            // Make sure the binary string has 7 bits by adding leading zeros if necessary
            binaryString = String.format("%7s", binaryString).replace(' ', '0');
            binaryStringBuilder.append(binaryString);
        }
        return binaryStringBuilder.toString();
    }

    // Encodes a binary string using the Chuck Norris encoding technique
    public static String encodeToChuckNorris(String binaryString) {
        StringBuilder chuckNorrisStringBuilder = new StringBuilder();
        int i = 0;
        while (i < binaryString.length()) {
            char currentBit = binaryString.charAt(i);
            int j = i + 1;
            // Count the number of consecutive bits that have the same value
            while (j < binaryString.length() && binaryString.charAt(j) == currentBit) {
                j++;
            }
            // Encode the consecutive bits using the Chuck Norris technique
            if (currentBit == '0') {
                chuckNorrisStringBuilder.append("00 ");
            } else {
                chuckNorrisStringBuilder.append("0 ");
            }
            chuckNorrisStringBuilder.append("0".repeat(Math.max(0, j - i)));
            chuckNorrisStringBuilder.append(" ");
            i = j;
        }
        return chuckNorrisStringBuilder.toString();
    }

}
