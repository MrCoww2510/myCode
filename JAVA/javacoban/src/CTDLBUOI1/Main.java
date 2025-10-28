package CTDLBUOI1;

class Main extends LinkList {
    public static void main(String[] args) {
        LinkList ll = new LinkList();
        ll.AddTail(25);
        ll.Printlist();
        ll.AddTail(10);
        ll.Printlist();
        ll.AddTail(2005);
        ll.Printlist();
        ll.AddHead(838838231);
        ll.Printlist();
        ll.AddInsert(28012006,838838231);
        ll.Printlist();
    }
    
}