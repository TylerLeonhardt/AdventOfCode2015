import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class day2_1 {
  public static void main(String[] argv){

    // for (String line : Files.readAllLines(Paths.get("./day2_1.txt"))) {
    //   System.out.println(line);
    // }
    // String s = new String(Files.lines("./day2_1.txt"));
    // System.out.println(s);
    String everything = "";
    try(BufferedReader br = new BufferedReader(new FileReader("day2_1.txt"))) {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    }catch(IOException e){}

    String[] input = everything.split("\n");

    int total = 0;
    for(String str : input){
      total += getSquareFeet(str);
    }
    System.out.println(total);

  }

  public static int getSquareFeet(String str){
    String[] strArr = str.split("x");

    int lw = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[1]);
    int lh = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[2]);
    int wh = Integer.parseInt(strArr[1]) * Integer.parseInt(strArr[2]);

    int slack = Math.min(lw,Math.min(lh,wh));

    return 2*(lw+lh+wh)+slack;
  }
}
