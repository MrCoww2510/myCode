public class NGAY2 {
    public static String Daochuoi(String str) {
        String dao = "";
        for (int i = str.length()-1; i >= 0; i--) {
            dao += str.charAt(i);
        }
        return dao;
    }
    public static void main(String[] args) {
        String ChuoiCanDao = "anhyeuemnhieulam";
        System.out.println(Daochuoi(ChuoiCanDao));
    }
}