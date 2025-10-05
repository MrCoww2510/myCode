import java.util.Scanner;


public class caesar {
    public String maHoa(String str, int n){
        String str1 = "";
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char)('A' + (c - 'A' + n) % 26);
            } else if (c >= 'a' && c <= 'z') {
                c = (char)('a' + (c - 'a' + n) % 26);
            }
            str1 = str1 + c;
        }
        return str1;
    }

    public String giaiMa(String str, int n){
        String str1 = "";
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char)('A' + (c - 'A' - n + 26) % 26);
                } else if (c >= 'a' && c <= 'z') {
                c = (char)('a' + (c - 'a' - n + 26) % 26);
            }
        str1 = str1 + c;
    }
    return str1;
    }
    public void vecCan(String str){
        for(int i=0;i<26;i++){
            System.out.println(giaiMa(str,i));
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        String str="Home is where the heart is";
        System.out.print("Nhap so nguyen n: ");
        n = scanner.nextInt();
        String str1=new caesar().maHoa(str, n);
        System.out.println("Chuoi sau khi ma hoa: "+str1);
        new caesar().vecCan(str1);
        // String str2=new caser().giaiMa(str1, n);
        // System.out.println("Chuoi sau khi giai ma: "+str2);
        scanner.close();
    }
   
}