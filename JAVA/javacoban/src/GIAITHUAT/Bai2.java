package GIAITHUAT;

public class Bai2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
            System.out.println(TimSoThieu(arr, 0));
       
    }

    static int TimSoThieu(int[] A, int N)
    {
        int left = 0;
        int right = A.length - 1;
        int error = -1; 

        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (A[mid] != mid + 1)
            {
                error = mid;
                right = mid - 1; 
            }
            else
            {
                left = mid + 1;
            }
        }
        
        if (error == -1)
        {
            return N;
        }
        return error + 1;
    }

}
