public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] arr = {64, 32, 128, 1024, 512, 256};

        System.out.println("chọn");
        selectionSort(arr);

        for (int x : arr)
        {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("chèn");
        insertionSort(arr);

        for (int x : arr)
        {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("merges");
        mergeSort(arr,0,arr.length-1);

        for (int x : arr)
        {
            System.out.print(x + " ");
        }
         System.out.println();




    }

    static void selectionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i; 
            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

        /*

    6 8 3 5 9 10 7 8 4 6
    3 8 6 5 9 10 7 8 4 6
    3 4 6 5 9 10 7 8 8 6
    3 4 5 6 9 10 7 8 8 6
    3 4 5 6 6 10 7 8 8 9 
    3 4 5 6 6 7 10 8 8 9
    3 4 5 6 6 7 8 10 8 9
    3 4 5 6 6 7 8 8 10 9
    3 4 5 6 6 7 8 8 9 10  */

    static void insertionSort(int[] arr)
    {
    int n = arr.length;

    for (int i = 1; i < n; i++)
        {
        int key = arr[i];     
        int j = i - 1;

        while (j >= 0 && arr[j] > key)
        {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
        }
    }

    /*
    8 5 12 5 9 4 7 2 1 6 11 13
    5 8 12 5 9 4 7 2 1 6 11 13
    5 5 8 12 9 4 7 2 1 6 11 13
    5 5 8 9 12 4 7 2 1 6 11 13
    4 5 5 8 9 12 7 2 1 6 11 13
    4 5 5 7 8 9 12 2 1 6 11 13
    2 4 5 5 7 8 9 12 1 6 11 13
    1 2 4 5 5 7 8 9 12 6 11 13
    1 2 4 5 5 6 7 8 9 12 11 13
    1 2 4 5 5 6 7 8 9 11 12 13

    */

    static void mergeSort(int[] arr, int left, int right) 
    {
        if (left >= right)
        {
            return;
        }

        int mid = (left + right) / 2;
        // đệ quy
        mergeSort(arr, left, mid);       // sắp xếp nửa trái
        mergeSort(arr, mid + 1, right);  // sắp xếp nửa phải
        merge(arr, left, mid, right);    // trộn hai nửa đã sắp xếp
    }

    static void merge(int[] arr, int left, int mid, int right)
    {
    int n1 = mid - left + 1; //lấy số phần tử bên trái
    int n2 = right - mid;   // tương tự

    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++)
    {
        L[i] = arr[left + i];
    }

    for (int j = 0; j < n2; j++)
    {
        R[j] = arr[mid + 1 + j];
    }

    int i = 0, j = 0, k = left;

    while (i < n1 && j < n2)
    {
        if (L[i] <= R[j])
        {
            arr[k++] = L[i++];
        }
        else
        {
            arr[k++] = R[j++];
        }
    }

    while (i < n1)
    {
        arr[k++] = L[i++];
    }

    while (j < n2)
    {
        arr[k++] = R[j++];
    }
    }  

    static void max(int[] arr){
        int max = arr[0];
        int i=0;
        while (i++ < arr.length) {
            if (arr[i] > max) { 
                max = arr[i];              
            }
        }
    }

    static void shallsort(int[] arr){

    }

    int LinearSearch(int[] arr,int x){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return 1;}
        }
        return -1;
    }

    static int BinarySearch(int[] arr, int x){
        int mid = arr.length/2;
        if (arr[mid] == x) {
            return 1;
        } 
        else {
            if (x < mid) {
                for (int i = 0; i < mid; i++) {
                    if (arr[i] == x) {return 1;}
                }
            }
            else {
                for (int i = mid; i < arr.length; i++) {
                    if (arr[i] == x) {return 1;}
                }
                
            }
        }
        return -1; 
    }
}