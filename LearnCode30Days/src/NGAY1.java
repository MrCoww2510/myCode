public class NGAY1 {
    public static int SumN(int n){
        if (n == 1) {
            return 1;
        } else {
            return n + SumN(n-1);
        }
    }
    public static void main(String[] args) {
        System.out.println("Sum từ 1 đến 20 là :"+SumN(20));
    }
}