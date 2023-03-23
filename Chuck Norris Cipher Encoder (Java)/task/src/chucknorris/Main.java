package chucknorris;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input string:");
        String inputChuckNorrisString = in.nextLine();

        System.out.println("\nThe result:");
        String binaryString = ChuckNorrisEncryption.decodeChuckNorris_To_Binary(inputChuckNorrisString);
        String normalString = BinaryEncryption.binaryToString(binaryString);
        System.out.println(normalString);
    }
}
