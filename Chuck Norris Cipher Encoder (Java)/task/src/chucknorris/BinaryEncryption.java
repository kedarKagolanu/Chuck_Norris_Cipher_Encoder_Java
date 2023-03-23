package chucknorris;

public class BinaryEncryption {
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

    public static String binaryToString(String binaryString) {
        StringBuilder normalStringBuilder = new StringBuilder();
        String[] tokens = binaryString.split(" ");

        // use this if you get a binary format string without any space (" ") between them.
        /*for (int i = 0; i < len; i += 7) {
            String token = binaryString.substring(i, Math.min(i + 7, len));
            normalStringBuilder.append(token);
        }*/

        String token;
        int len = binaryString.length();
        for(int i=0;i< len;i+=7) {
            token = binaryString.substring(i, Math.min(i + 7, len));
            int intValue = Integer.parseInt(token, 2);
            char charValue = (char) intValue;
            normalStringBuilder.append(charValue);
        }

        return normalStringBuilder.toString();
    }
}
