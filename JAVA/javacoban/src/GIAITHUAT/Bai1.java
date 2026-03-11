package GIAITHUAT;

    public class Bai1 {
        public static void main(String[] args) {
            int[] arr = {7,2,4,1,9,42,4,6,326};
            int[] arr2 = {7,2,4,1,9,42,4,6,326};
            System.out.println("selec");
            selectionSort(arr);
            System.out.println("insert");
            insertionSort(arr2);
        
        
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
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

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
            for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
}
