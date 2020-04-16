import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            String result = longestPalindrome(s);
            System.out.println(result);
        }
    }

    public static String longestPalindrome(String s) {

        if(s.equals(""))
            return "";
        StringBuilder substring = new StringBuilder();
        StringBuilder tempSUbstring = new StringBuilder();
        int size = Integer.MIN_VALUE;

        String reverse = (new StringBuilder(s).reverse().toString());
        for(int i=0; i<s.length();i++)
        {
            if(s.charAt(i) == reverse.charAt(i))
            {
                tempSUbstring.append(s.charAt(i));
            }
            else
            {
                if(size<tempSUbstring.length())
                {
                    substring = new StringBuilder(tempSUbstring.toString());
                    size = tempSUbstring.length();
                }
                tempSUbstring = new StringBuilder();
            }
        }

        if(size<tempSUbstring.length())
        {
            substring = new StringBuilder(tempSUbstring.toString());
            size = tempSUbstring.length();
        }

        if(substring.length()!=0)
            return substring.toString();
        else
            return String.valueOf(s.charAt(0));
    }


}
