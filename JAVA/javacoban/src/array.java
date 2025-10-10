/*2.1 Cho một mảng gồm 20 phần tử sau
[90, 88, 54, 14, 91, 97, 12, 34, 91, 98, 71, 35, 18, 12, 71, 21, 14, 12, 61, 93]
a) Tạo một mảng và lưu trữ các phần tử trên
b) In ra màn hình số lượng các số có trong mảng. Ví dụ: Số 90 có 1 số
c) Thay đổi tất cả phần tử 91 trong mảng thành 8
d) Cho biết vị trí các phần tử 14 có trong mảng, in ra màn hình
e) Cho biết phần tử 12 có tồn tại trong mảng hay không, nếu có hãy in ra màn
hình vị trí của các phần tử 12 và xóa phần tử này khỏi mảng
f) Thêm lại đúng số lượng phần tử 12 đã xóa vào mảng bắt đầu tại vị trí thứ 2
của mảng và in ra màn hình sau khi đã cập nhật
g) Cập nhật lại mảng sao cho mỗi phần tử là duy nhất trong mảng */
import java.util.*;
public class array {
    //main method
    public static void main(String[] args) {
        // Khai báo và khởi tạo mảng câu A
        Scanner sc = new Scanner(System.in);
        int[] arr = {90, 88, 54, 14, 91, 97, 12, 34, 91, 98, 71, 35, 18, 12, 71, 21, 14, 12, 61, 93};
        int[] arr2 = new int[arr.length];

        // Câu B: In ra
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Phần tử " + arr[i] + " có " + countOccurrences(arr, arr[i]) + " số");
        } 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 91) {
                arr[i] = 8;
            }
        }
        System.out.println("Mảng sau khi thay 91 bằng 8: " + Arrays.toString(arr));


        sc.close();
    }

    // Hàm đếm số lần xuất hiện của một số trong mảng
    public static int countOccurrences(int[] arr, int num) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        return count;
    }

}
