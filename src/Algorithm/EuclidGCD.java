package Algorithm;

import java.util.Scanner;

public class EuclidGCD {
    static int gcd(int x, int y){
        if (y == 0){
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    static int lcm(int x, int y){
        return (x*y/gcd(x,y));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 입력 : ");
        int x = sc.nextInt();
        System.out.println("정수 입력 : ");
        int y = sc.nextInt();
        System.out.println("최대 공약수 : " + gcd(x,y));

        System.out.println("최소 공배수 : " + lcm(x,y));
    }

}
