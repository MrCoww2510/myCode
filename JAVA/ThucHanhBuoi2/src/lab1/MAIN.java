package lab1;
import java.util.Scanner;
public class MAIN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HinhChuNhat ABCD = new HinhChuNhat();
        ABCD.setChieudai(sc.nextDouble());
        ABCD.setChieurong(sc.nextDouble());
        ABCD.toString();
        sc.close();
        System.out.println(ABCD);
    }
}
