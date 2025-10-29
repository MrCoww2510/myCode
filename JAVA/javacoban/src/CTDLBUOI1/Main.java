package CTDLBUOI1;
class Main extends LinkList {
    public static void main(String[] args) {
        LinkList ll = new LinkList();
        System.out.println("===== THÊM PHẦN TỬ VÀO DANH SÁCH =====");
		ll.AddTail(25);
		ll.AddTail(10);
		ll.AddTail(2005);
        ll.AddTail(10);
        ll.AddTail(10);
        ll.AddTail(10);
		ll.AddHead(999);
        ll.AddTail(10);
		ll.AddInsert(50, 25); // chèn 50 sau node có data = 25
		ll.Printlist();

		System.out.println("\n===== ĐẾM SỐ LƯỢNG PHẦN TỬ =====");
        System.out.println("số lượng phần tử là: "+ll.count());

		System.out.println("\n===== TÌM KIẾM PHẦN TỬ =====");
		ll.finddata(10);
		ll.finddata(999);
		ll.finddata(404); // không có trong danh sách

		System.out.println("\n===== XÓA PHẦN TỬ =====");
		ll.delete(999); // xóa đầu
		ll.Printlist();

		ll.delete(2005); // xóa cuối
		ll.Printlist();

		ll.delete(10); // xóa giữa
		ll.Printlist();

		ll.delete(404); // xóa phần tử không có
		ll.Printlist();

		ll.update(10, 99, 0);
		ll.Printlist();

		System.out.println("\n===== KIỂM TRA LẠI SỐ PHẦN TỬ =====");
		System.out.println("Số lượng phần tử hiện tại: " + ll.count());
    }
}