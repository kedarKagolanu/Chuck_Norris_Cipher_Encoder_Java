package chucknorris;

public class BinaryEncryption {
    // Converts a string to its corresponding binary representation
    public static String stringToBinary(String inputString) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(c));
            while(binaryString.length() < 7) {
                binaryString.insert(0, '0');
            }
            binaryStringBuilder.append(binaryString);
        }
        return binaryStringBuilder.toString();
    }

    public static String binaryToString(String binaryString) throws IllegalArgumentException{
        StringBuilder normalStringBuilder = new StringBuilder();

        if(binaryString.length() % 7 != 0){
            throw new IllegalArgumentException("Encoded string is not valid.");
        }

        String token;
        int len = binaryString.length();
        int intValue;
        for(int i=0;i< len;i+=7) {
            token = binaryString.substring(i, Math.min(i + 7, len));
            try {
                intValue = Integer.parseInt(token, 2);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Encoded string is not valid.");
            }
            char charValue = (char) intValue;
            normalStringBuilder.append(charValue);
        }

        return normalStringBuilder.toString().replace("`"," ");
    }
}
