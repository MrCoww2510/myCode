public class NGAY3 {
    public static Double Maxx(Double[] a) {
        double z = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > z) { z = a[i];} }
        return z;
    }
    public static void main(String[] args) {
        Double[] arr = new Double[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random()*100+1;
            System.out.println(arr[i]+" ");
        }

        System.out.println(String.format("%.2f",Maxx(arr)));
    }
}
