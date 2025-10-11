public class NGAY4 {
    /* này là đệ quy */
    public static int DEQUYfibonaci(int n){
        if (n <= 1) {return n;}
        return DEQUYfibonaci(n-1)+DEQUYfibonaci(n-2);
    }

    /* này dùng for */
    public static void Forfibonaci(int n) {
        int[] arr = new int[n];
        arr[0]=0;
        if (n>1) {
            arr[1] = 1;
        }
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int n = 20;
        Forfibonaci(n); //nó in sẵn trong hàm nên viết 1 dòng này là ra

        System.out.println();
        // chưa có in trong hàm nên dùng for
        for (int i = 0; i < n; i++) {
            System.out.print(   DEQUYfibonaci(i)    + " ");
        }
        System.out.println();
    }
}