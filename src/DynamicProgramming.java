import java.util.HashMap;
import java.util.Map;

class MemorizationExample {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

}


/**
💡 탑다운(Top-Down) 방식

- 재귀적으로 호출하여 문제를 해결하는 방식입니다.

- 재귀 호출을 사용하므로 스택 오버플로(Stack Overflow)문제가 발생 할 수 있습니다.
- 큰 문제를 작은 문제로 나누어 푸는 분할정복(Divide and Conquer) 방식과 비슷합니다.
다만 중복되는 작은 문제들을 한 번만 푸는 것이 특징입니다.

💡 해당 예시는 탑다운 방식을 이용하여 피보나치 수열을 계산하는 방식입니다.

- dp 배열을 메모이제이션용으로 사용하여 이전에 구한 값을 저장하고 중복 계산을 방지합니다.(메모이제이션)
- n이 1보다 작거나 같은 경우에는 n을 반환하고, 그 외의 경우에는 fib(n-1)과 fib(n-2)를 더한 값을 dp 배열에 저장한 후 반환합니다.
*/
class TopDownDP{
    static int[] dp = new int[100];

    public static int fib(int n) {
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];
        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }
}

/**
 * 피보나치수를 이용한 경우의 수 계산방법 : 재귀함수를 이용한 방법
 */

public class DynamicProgramming {
    public static int calcRecursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calcRecursiveFibonacci(n - 1) + calcRecursiveFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("계단을 오르는 방식 : " + calcRecursiveFibonacci(n + 1)); // 계단을 오르는 방식 : 5
    }
}
