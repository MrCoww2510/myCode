package test;
public class Search {
    public int Linearsearch(int[] arr,int data){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }     
        }
        return -1;
    }

    public int binarysearch(int[] arr,int data){
        int left = 0;
        int rigth = arr.length;
        while (left <= rigth) {
            int mid = (left + rigth)/2;
            if (data == arr[mid]) { return mid;        
            }else if(arr[mid]<data){ left = mid + 1;
            } else { rigth = mid - 1;}
        }
        return -1;
    }

    public int tenarysearch(int[] arr,int data){
        int left = 0;
        int rigth = arr.length-1;
        while (left <= rigth) {
            int mid1 =left+ (rigth - left)/3;
            int mid2 =rigth- (rigth - left)/3;
            if (arr[mid1]==data) {return mid1;}
            else if (arr[mid2]==data) {return mid2;}
            else if (data < arr[mid1]) {rigth = mid1 -1;}
            else if (data < arr[mid2] && data >arr[mid1]) {rigth = mid2 -1; left = mid1 +1;}
            else {left = mid2 +1;}
        }
        return -1;
    }

}
