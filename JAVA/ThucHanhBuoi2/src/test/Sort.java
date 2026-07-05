package test;
public class Sort {
    //InterchangeSort
    public void interchangesort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            for (int print = 0; print < arr.length; print++) {
                System.out.print(arr[print]+" ");}
            System.err.println();
        }
    }
    //SelectionSort
    public void SelectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                } 
            }
            int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                
            for (int print = 0; print < arr.length; print++) {
                System.out.print(arr[print]+" ");}
            System.err.println();
        }
    }
    //InsertionSort
    public void InsertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j>0 && arr[j-1] > arr[j]) {
                int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                j--;
            }
            for (int print = 0; print < arr.length; print++) {
                System.out.print(arr[print]+" ");}
            System.err.println();
        }
    }
    //BubbleSort
    public void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            print(arr);
        }
    }
    //mergesort
    public void MergeSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int mid = left + (right - left) / 2;
            MergeSort(arr, left, mid);
            MergeSort(arr, mid + 1, right);
            Merge(arr, left, mid, right);
        }
    }
    //merge
    public void Merge(int[] arr, int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
}

    //shell sort
    public void ShellSort(int[] arr)
    {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i++)
            {
                int temp = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap] > temp)
                {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }

            print(arr);
        }
    }









    //print
    public static void print(int[] arr){
        for (int print = 0; print < arr.length; print++) {
                System.out.print(arr[print]+" ");}
            System.err.println();
    }
}
