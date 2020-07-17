import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int result = reverse(x);
        System.out.println(result);
    }
    public static int reverse(int x) {

        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE)
            return 0;
        int result = 0;
        int multiply = 10;
        while(x/10!=0)
        {
            int temp = x%10;
            result = (result*multiply)+temp;
            if(result==Integer.MAX_VALUE || result== Integer.MIN_VALUE)
                return 0;
            x/=10;
        }
        if(result> Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10)
            return 0;
        result = (result*multiply);
        result+=x;

        return result;
    }
}
