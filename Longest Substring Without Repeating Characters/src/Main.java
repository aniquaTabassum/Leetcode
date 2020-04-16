import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String string = sc.nextLine();
            lengthOfLongestSubstring(string);
        }
    }
    public static int lengthOfLongestSubstring(String s) {

        int size = Integer.MIN_VALUE;
        String subString = "";
        if(s!=null && s.length()>0) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (subString.indexOf(c) != -1) {
                    if (subString.length() > size)
                        size = subString.length();
                    int position = subString.lastIndexOf(c);
                    if(position<subString.length()-1)
                        subString = subString.substring(position+1);
                    else
                        subString = "";

                }
                subString += c;

            }
            if (subString.length() > size)
                size = subString.length();
        }
        else
            size = 0;

        System.out.println(size);
        return size;
    }
}
