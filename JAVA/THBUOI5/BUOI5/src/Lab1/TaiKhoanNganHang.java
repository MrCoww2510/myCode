package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class TaiKhoanNganHang {
	private double SoDu;
	private String MaPin;
	private ArrayList<String> LSGD;

	// ================= CONSTRUCTOR =================
	TaiKhoanNganHang(String MaPin, double SoDuBD) {
		this.MaPin = MaPin;
		this.SoDu = SoDuBD;
		this.LSGD = new ArrayList<>(); // FIX QUAN TRỌNG
	}

	// ================= HIỂN THỊ LỊCH SỬ =================
	public void hienThiLSGD() {
		System.out.println("===== LỊCH SỬ GIAO DỊCH =====");
		if (LSGD.isEmpty()) {
			System.out.println("Chưa có giao dịch!");
			return;
		}
		for (String gd : LSGD) {
			System.out.println(gd);
		}
	}

	// ================= NẠP TIỀN =================
	public void naptien(Scanner sc) {
		System.out.print("Nhập mã PIN: ");
		String tam = sc.nextLine();
		if (tam.equals(this.MaPin)) {
			System.out.print("Nhập số tiền muốn nạp: ");
			double tam1 = Double.parseDouble(sc.nextLine());
			this.SoDu += tam1;
			LSGD.add("Nạp +" + tam1 + " VND");
			System.out.println("Nạp thành công!");
		} else {
			System.out.println("Sai mã PIN!");
		}
	}

	// ================= RÚT TIỀN =================
	public void ruttien(Scanner sc) {
		System.out.print("Nhập mã PIN: ");
		String tam = sc.nextLine();
		if (tam.equals(this.MaPin)) {
			System.out.print("Nhập số tiền muốn rút: ");
			double tam1 = Double.parseDouble(sc.nextLine());
			if (tam1 <= this.SoDu) {
				this.SoDu -= tam1;
				LSGD.add("Rút -" + tam1 + " VND");
				System.out.println("Rút thành công!");
			} else {
				System.out.println("Không đủ tiền!");
			}
		} else {
			System.out.println("Sai mã PIN!");
		}
	}
}