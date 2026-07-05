package HDTTHBUOI1;

import java.util.Scanner;

public class ONTAP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// câu 1
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			if (checkSNT(i)) {
				System.out.println(i + " ");
			}
		}
		// câu 2
		int[] a = { 3, 4, 7, 2, 8, 9 };
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				s += a[i];
			}
		}
		System.out.println("tổng số chẵn " + s);
		// câu 3
		int chon;
		do {
			System.out.println("Nhập từ 1 đến 7, nhập 0 để thoát: ");
			chon = sc.nextInt();
			switch (chon) {
				case 1:
					System.out.println("chủ nhật");
					break;
				case 2:
					System.out.println("Thứ hai");
					break;
				case 3:
					System.out.println("Thứ ba");
					break;
				case 4:
					System.out.println("Thứ tư");
					break;
				case 5:
					System.out.println("Thứ năm");
					break;
				case 6:
					System.out.println("Thứ sáu");
					break;
				case 7:
					System.out.println("Thứ bảy");
					break;
				case 0:
					System.out.println("Thoát");
					break;

				default:
					System.out.println("nhập sai nhập lại: ");
					break;
			}
		} while (chon != 0);

		sc.close();
	}

	// câu 1
	public static boolean checkSNT(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}