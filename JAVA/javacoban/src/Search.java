public class Search {
    public static void main(String[] args) {
        int[] arr = {10,14,19,26,27,31,33,35,42,44};
        System.out.println("sort");
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("search");
        System.out.println(BinarySearch(arr,31));
        System.out.println("search");
        System.out.println(ternarySearch(arr,31));
        System.out.println("search");
        System.out.println(jumpSearch(arr,31));
        System.out.println("search");
        System.out.println(LinearSearch(arr,31));
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pivotIndex = partition(arr, low, high); 

            quickSort(arr, low, pivotIndex - 1);  
            quickSort(arr, pivotIndex + 1, high); 
        }
    } 

    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high]; 
        int i = low - 1;       

        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; 
    } 


    static int LinearSearch(int[] arr,int x){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;}
        }
        return -1;
    }

    static int BinarySearch(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;

	while (left <= right)
	{
		int mid = (left + right) / 2;

		if (arr[mid] == x)
		{
			return mid;
		}
		else if (x < arr[mid])
		{
			right = mid - 1;
		}
		else
		{
			left = mid + 1;
		}
	}

	return -1;
    }

    static int ternarySearch(int[] arr,int x){
        int left = 0;
	    int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int mid1 = left + (right-left)/3;
            int mid2 = right - (right-left)/3;
            if (arr[mid1]==x) { return mid1;}
            if (arr[mid2]==x) { return mid2;}
            if (arr[mid1]>arr[mid2]) { right = mid2;} else { left = mid1; }
            }
        return -1;
    }

    static int jumpSearch(int[] arr, int x)
    {
	int n = arr.length;
	int step = (int)Math.sqrt(n);
	int prev = 0;

	while (prev < n && arr[Math.min(step, n) - 1] < x)
	{
		prev = step;
		step += (int)Math.sqrt(n);

		if (prev >= n)
		{
			return -1;
		}
	}

	for (int i = prev; i < Math.min(step, n); i++)
	{
		if (arr[i] == x)
		{
			return i;
		}
	}

	return -1;
    }

}
