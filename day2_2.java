import java.io.*;
import java.util.*;

public class day2_2 {
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
      total += getRibbon(str);
    }
    System.out.println(total);

  }

  public static int getRibbon(String str){
    String[] strArr = str.split("x");

    int l = Integer.parseInt(strArr[0]);
    int w = Integer.parseInt(strArr[1]);
    int h = Integer.parseInt(strArr[2]);

    int wrap = Math.min((l+l+w+w),Math.min(l+l+h+h,w+w+h+h));

    return wrap+(l*w*h);
  }
}
