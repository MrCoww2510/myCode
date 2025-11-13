package tree;

public class Mybinarytree {
    private treeNode root;
    public Mybinarytree(){
        this.root = null;
    }
    public void init(){
        treeNode n0 = new treeNode(0);
        treeNode n1 = new treeNode(1);
        treeNode n2 = new treeNode(2);
        treeNode n3 = new treeNode(3);
        treeNode n4 = new treeNode(4);
        treeNode n5 = new treeNode(5);
        treeNode n6 = new treeNode(6);
        treeNode n7 = new treeNode(7);

        n0.left = n1; n0.right = n2;
        n1.left = n3; n1.right = n4;
        n2. right = n5;
        n4.left = n6; n4.right = n7;
        root = n0;
    }
}
