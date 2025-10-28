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
    public Node newnode;
    public LinkList(){  head = null;    }
//
    public void AddTail(int data){ //thêm vào cuối danh sách
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
    public void AddHead(int data){ //thêm vào đầu danh sách
        Node newnode = new Node(data);
        if (this.head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head= newnode;
        }
        
    }
    public void AddInsert(int data,int vitricanchen){ //thêm bất cứ đâu danh sách
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
        } else {
            Node temp = head;
            while (temp != null && temp.data != vitricanchen) { // di chuyển con trỏ đến nơi có data = vitricanchen
                temp = temp.next;
            }
            if (temp == null){  
		    System.out.println("Không tìm thấy node có giá trị " + vitricanchen + " để chèn sau.");
		    return;
	        }
            newnode.next = temp.next;
            temp.next = newnode ;
        }
        
    }
//
    public void Printlist(){ //in ra
        Node temp = head;
        while (temp != null) {
            System.out.print("["+temp.data+"]-->");
            temp = temp.next;
        }
        System.out.println();
    }
    
}