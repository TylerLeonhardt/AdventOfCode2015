import java.util.*;
import java.io.*;
import java.security.*;

public class day4_1{

  public static void main(String[] argv) throws Exception {
    String input = "iwrupvqb";
    System.out.println(find5Zeros(input));
  }

  public static int find5Zeros(String str) throws Exception {

    int counter = 1;
    while(true){
      byte[] bytesOfMessage = (str + counter).getBytes("UTF-8");

      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] thedigest = md.digest(bytesOfMessage);

      String answer = bytesToHex(thedigest);
      // System.out.println(answer);

      if(answer.length() >= 6){

        String first5 = answer.substring(0,6);
        try {
          if(Integer.parseInt(first5) == 0){
            return counter;
          }
        } catch (NumberFormatException e) {}
      }

      counter++;
    }

    // String test = "abcdef609043";
    //
    // byte[] bytesOfMessage = test.getBytes("UTF-8");
    //
    // MessageDigest md = MessageDigest.getInstance("MD5");
    // byte[] thedigest = md.digest(bytesOfMessage);
    //
    // String answer = bytesToHex(thedigest);
    // System.out.println(answer);

    // return 0;
  }

  final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
  public static String bytesToHex(byte[] bytes) {
      char[] hexChars = new char[bytes.length * 2];
      for ( int j = 0; j < bytes.length; j++ ) {
          int v = bytes[j] & 0xFF;
          hexChars[j * 2] = hexArray[v >>> 4];
          hexChars[j * 2 + 1] = hexArray[v & 0x0F];
      }
      return new String(hexChars);
  }
}
