package CTDLBUOI1;

class Node {
    public int data;
    public Node next;
    public Node(){}
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class LinkList {
    public Node head;
    public LinkList(){  head = null;    }
    //thêm vào cuối danh sách
    public void AddTail(int data){ 
        Node newnode = new Node(data);
        if (this.head == null) {
            head = newnode;
        } else {
            Node Nodetemp = this.head;
            while (Nodetemp.next != null) //di chuyển con trỏ đến cuối danh sách
            {
                Nodetemp = Nodetemp.next;
            }
            Nodetemp.next = newnode ;
        }
    }
    //thêm vào đầu danh sách
    public void AddHead(int data){ 
        Node newnode = new Node(data);
        if (this.head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head= newnode;
        }
    }
    //thêm bất cứ đâu danh sách
    public void AddInsert(int data,int datacanchen){ 
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
        } else {
            Node temp = head;
            while (temp != null && temp.data != datacanchen) { // di chuyển con trỏ đến nơi có data = datacanchen
                temp = temp.next;
            }
            if (temp == null){  
		    System.out.println("Không tìm thấy node có giá trị " + datacanchen + " để chèn sau.");
		    return;
	        }
            newnode.next = temp.next;
            temp.next = newnode ;
        }
    }
    //in ra
    public void Printlist(){ 
        Node temp = head;
        while (temp != null) {
            System.out.print("["+temp.data+"]-->");
            temp = temp.next;
        }
        System.out.println();
    }
    // xoa vi tri bat ki
    public void delete(int datanodecanxoa){
        if (head == null) {
            System.out.println("Mảng rỗng không thể xóa");            
        }else{
            Node deltemp = head;
            if (head.data==datanodecanxoa) { //check xem vị trí xóa có phải là head khog
                head = head.next;       
                return;      
            }
            while ( deltemp.next != null && deltemp.next.data != datanodecanxoa) {
                deltemp = deltemp.next;           
            }
            if (deltemp.next == null) {
                System.out.println("không tìm ra vị trí cần xóa");
                return;
            }
            deltemp.next = deltemp.next.next;
        }
    }
    // đếm và trả về số lượng phần tử
    public int count(){
        int dem =0;
        Node temp = head;
        if (temp != null) {
            while (temp != null) {
            temp = temp.next;
            dem +=1;
        }
        return dem;
        } else {    return 0;}
    }
    //tìm vị trí node có data trùng với datacantim và in ra vị trí
    public void finddata(int datacantim){
        Node temp = head;
        if (temp != null ) {
            LinkList luuvitri = new LinkList();
            int dem =1;
            while (temp != null) {
                
                if (temp.data == datacantim) {
                    luuvitri.AddTail(dem);
                }
                temp = temp.next;
                dem ++;
            }
            if (luuvitri.head == null) {
                System.out.println("không có "+datacantim+" trong danh sách");
            }else{
                System.out.println("các vị trí của "+datacantim+" trong danh sách là:");
                luuvitri.Printlist();
            }            
        } else {System.out.println("danh sách rỗng không thể tìm");}
    }
    // Cập nhật node có data cần thay
    public void update(int dataBiThay, int dataDuocThay, int chose)
    {
    	Node temp = head;
    	boolean timThay = false;
    	if (temp == null) {
		    System.out.println("Danh sách rỗng, không thể thay thế.");
    		return;
    	}
    	switch (chose) {
		    case 0: // thay node đầu tiên có data trùng
			    while (temp != null && temp.data != dataBiThay) {
				    temp = temp.next;
    			}
	    		if (temp != null) {
		    		temp.data = dataDuocThay;
			    	timThay = true;
			    }
			    break;
		    case 1: // thay tất cả node trùng dataBiThay
    			while (temp != null) {
				    if (temp.data == dataBiThay) {
    					temp.data = dataDuocThay;
					    timThay = true;
				    }
				    temp = temp.next;
			    }
			    break;
		    default:
    			System.out.println("Giá trị chose không hợp lệ. Nhập 0 hoặc 1.");
			    return;
	    }
	    if (timThay)
    		System.out.println("Đã cập nhật giá trị " + dataBiThay + " thành " + dataDuocThay);
	    else
    		System.out.println("Không tìm thấy giá trị " + dataBiThay + " trong danh sách.");
    }   

}