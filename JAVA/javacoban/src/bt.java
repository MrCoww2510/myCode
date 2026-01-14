public class bt {
    public static void main(String[] args) {
        int temp;
        int[] a = {12,2,8,5,1};
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i]>a[j]) {
                    temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}