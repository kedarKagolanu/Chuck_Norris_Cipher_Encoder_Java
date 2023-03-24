package chucknorris;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ChuckNorrisEncryption {

    // Encodes a binary string using the Chuck Norris encoding technique
    public static String encodeBinary_To_ChuckNorris(String binaryString) {
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

    public static String decodeChuckNorris_To_Binary(String chuckNorrisCode) throws IllegalArgumentException{
        StringBuilder binaryCode = new StringBuilder();
        StringTokenizer st = new StringTokenizer(chuckNorrisCode," ");
        String binaryDigit;
        String binaryDigitCount;
        int count;
        while(st.hasMoreTokens()) {
            binaryDigit = st.nextToken();
            try {
                binaryDigitCount = st.nextToken();
            } catch(NoSuchElementException e) {
                throw new IllegalArgumentException("Encoded string is not valid.");
            }
            count = binaryDigitCount.length();
            if(binaryDigit.equals("00")) {
                binaryCode.append("0".repeat(count));
            } else if(binaryDigit.equals("0")){
                binaryCode.append("1".repeat(count));
            } else {
                throw new IllegalArgumentException("Encoded string is not valid.");
            }
        }

        return binaryCode.toString();
    }
}
