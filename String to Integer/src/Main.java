import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            int result = myAtoi(str);
            System.out.println(result);
        }
    }

    public static int myAtoi(String str) {
        int ans = 0;
        int sign = 1;
        String input = str.trim();
        if(input.length() == 0)
            return 0;
        char positiveOrNegative = input.charAt(0);

            if(positiveOrNegative == '-')
            {
                sign = -1;
            }
        else if(positiveOrNegative>='0' && positiveOrNegative<='9')
        {
            int num = positiveOrNegative-48;
            ans = num;
        }
        else if(positiveOrNegative!='+')
            {
                return 0;
            }
        for(int i=1; i< input.length();i++)
        {
            char c = input.charAt(i);
            if(c>='0' && c<='9')
            {
                if(sign == 1) {
                    if(ans<=(Integer.MAX_VALUE)/10) {

                        if((ans!=Integer.MAX_VALUE/10) || (ans == (Integer.MAX_VALUE)/10 && (c-48)<=7))
                        {
                            ans *= 10;
                            ans += (c - 48);
                        }
                        else
                            return Integer.MAX_VALUE;
                    }
                    else
                        return Integer.MAX_VALUE;
                }
                else {
                    if(ans*-1>=(Integer.MIN_VALUE)/(10))
                    {
                        if((ans*-1!=Integer.MIN_VALUE/10) || (ans*-1 ==(Integer.MIN_VALUE)/(10) && (c-48)<=8))
                        {
                            ans *= 10;
                            ans += (c - 48);
                        }
                        else
                            return Integer.MIN_VALUE;
                    }
                    else
                        return Integer.MIN_VALUE;
                }
            }
            else{
                if (ans != 0)
                    return ans * sign;
                else
                    return ans;
            }
        }

        return ans*sign;
    }
}
