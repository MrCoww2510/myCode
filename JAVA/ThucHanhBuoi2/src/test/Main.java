package test;

class Main {

    public static void main(String[] args) {
        Sort xapxep = new Sort();
        Search timkiem = new Search();
        int[] base = {7,2,1,10,9,5,6,8,3,4};
        int[] arr = base.clone();
        System.err.println("interchangesort");
        xapxep.interchangesort(arr);
        System.out.println("LinearSearch");
        System.err.println(timkiem.Linearsearch(arr, 5));
        arr = base.clone();
        System.err.println("SelectionSort");
        xapxep.SelectionSort(arr);
        System.out.println("BinarySearch");
        System.out.println(timkiem.binarysearch(arr, 1));
        arr = base.clone();
        System.err.println("InsertionSort");
        xapxep.InsertionSort(arr);
        System.out.println("tenarySearch");
        System.out.println(timkiem.tenarysearch(arr, 6));
        arr = base.clone();
        System.err.println("BubbleSort");
        xapxep.BubbleSort(arr);
        
    }
    
}