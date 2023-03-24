package chucknorris;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userInputOperation;
        String asciiCodeBuffer,binaryCodeBuffer,chuckNorrisCodeBuffer;
        boolean repeat = true;

            while (repeat) {
                System.out.println("\nPlease input operation (encode/decode/exit):");
                userInputOperation = in.nextLine();
                try {
                    switch (userInputOperation.toLowerCase(Locale.ROOT)) {
                        case "encode":
                            System.out.println("Input string:");
                            asciiCodeBuffer = in.nextLine();
                            binaryCodeBuffer = BinaryEncryption.stringToBinary(asciiCodeBuffer);
                            chuckNorrisCodeBuffer = ChuckNorrisEncryption.encodeBinary_To_ChuckNorris(binaryCodeBuffer);

                            System.out.println("Encoded string:");
                            System.out.println(chuckNorrisCodeBuffer);
                            break;
                        case "decode":
                            System.out.println("Input encoded string:");
                            chuckNorrisCodeBuffer = in.nextLine();
                            binaryCodeBuffer = ChuckNorrisEncryption.decodeChuckNorris_To_Binary(chuckNorrisCodeBuffer);
                            asciiCodeBuffer = BinaryEncryption.binaryToString(binaryCodeBuffer);

                            System.out.println("Decoded string:");
                            System.out.println(asciiCodeBuffer);
                            break;
                        case "exit":
                            repeat = false;
                            break;

                        default:
                            System.out.println("There is no '" + userInputOperation + "' operation");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }


        System.out.println("Bye!");
    }
}
