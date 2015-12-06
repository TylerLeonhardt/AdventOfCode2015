import java.io.*;
import java.util.*;

public class day5_1 {

  public static void main(String[] argv) throws IOException{
    Scanner in = new Scanner(new File("day5.txt"));

    int answer = 0;
    while(in.hasNextLine()){
      answer += isNice(in.nextLine()) ? 1 : 0;
    }
    System.out.println(answer);
    System.out.println(isNice("aa"));
  }

  public static boolean isNice(String str){
    int vowels = 0;

    final String THE_VOWELS = "aeiou";
    for(int i = 0; i < str.length(); i++){
      if(THE_VOWELS.contains(""+str.charAt(i))){
        vowels++;
      }
    }
    if(vowels < 3) return false;

    char currChar = str.charAt(0);
    boolean foundDouble = false;
    for(int i = 1; i < str.length(); i++){
      if(currChar == str.charAt(i)){
        foundDouble = true;
      }else{
        currChar = str.charAt(i);
      }
    }
    if(!foundDouble) return false;

    String[] badLetters = {"ab", "cd", "pq", "xy"};

    boolean allNiceLetters = true;
    for(String bad : badLetters){
      if(str.contains(bad)){
        allNiceLetters = false;
      }
    }
    if(!allNiceLetters) return false;

    return true;
  }
}
