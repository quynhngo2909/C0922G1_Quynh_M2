package ss2_Loop_Array.loop_array_excersize;

public class PrimeSmallerThan100 {
    public static void main(String[] args) {
        int N = 2;
        for (; N < 100; N++) {
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(N);
            }
        }
    }
}
