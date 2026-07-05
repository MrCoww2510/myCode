// Ngày 1: Viết chương trình tính tổng 1 → n mà không dùng for hay while. (gợi ý: đệ quy)

// Ngày 2: Viết hàm đảo ngược chuỗi thủ công (không dùng [::-1] hay hàm có sẵn).

// Ngày 3: Viết hàm tìm số lớn nhất trong danh sách bằng tay, không max().

// Ngày 4: Tính số Fibonacci thứ n (cả 2 cách: đệ quy và vòng lặp).

// Ngày 5: Tự code hàm count() để đếm số lần xuất hiện của phần tử trong mảng.

// Ngày 6: Nhập danh sách số, in ra danh sách không trùng (tự lọc, không set()).

// Ngày 7: Viết lại tất cả bài trên nhưng bằng Java hoặc C++.
// 👉 Mục tiêu: hiểu “một ngôn ngữ là gì” và “cách tư duy ngôn ngữ khác nhau ra sao.”
import java.util.Scanner;

public class T7Ngay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = 0;
		for (int i = 0; i < n; i++) {
			s = s + i;
		}
		System.out.println(s);
		sc.close();
	}
}
