public class NGAY5 {
    public static void DemSoLanXuatHien(int[] arr) {
        int n = arr.length;
        int dem = 0;
        boolean[] dadem = new boolean[n]; // cắm cờ mấy đứa trùng

        for (int i = 0; i < n; i++) {
            if (dadem[i]) { continue;}
            for (int j = 0; j < n; j++) {
                if (arr[i]==arr[j]) {
                    dem += 1;   
                    dadem[j] = true;          
                }
            }
            System.out.println(arr[i]+" xuất hiện "+dem+" lần");
            dem = 0;
        }
    }

    public static void main(String[] args) {
        //tự nhập dữ liệu
        int[] save = new int[20];
        for (int i = 0; i < save.length; i++) {
            save[i]= (int)(Math.random()*100+1);
        }
        DemSoLanXuatHien(save);
    }
}
