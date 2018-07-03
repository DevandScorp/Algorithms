package Binary_Search;

public class Binary_Search {
    public static int binary_search(int[] arr,int x,int low,int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==x)return mid;
            else if(x<arr[mid])high = mid-1;
            else low = mid+1;
        }
        return -1;
//        int mid = low + (high-low)/2;
//        if(low>high)return -1;
//        if(x==arr[mid])return mid;
//        else if(x<arr[mid])return binary_search(arr,x,low,mid-1);
//        else if(x>arr[mid])return binary_search(arr,x,mid+1,high);
//        return -1;
    }
    public static void main(String[] args){
        int[] arr = new int[10];
        for(int i = 0;i<10;++i){
            arr[i] = i;
        }
        System.out.println(binary_search(arr,0,0,arr.length-1));
        System.out.println(binary_search(arr,1,0,arr.length-1));
        System.out.println(binary_search(arr,2,0,arr.length-1));
        System.out.println(binary_search(arr,3,0,arr.length-1));
        System.out.println(binary_search(arr,4,0,arr.length-1));
        System.out.println(binary_search(arr,5,0,arr.length-1));
        System.out.println(binary_search(arr,6,0,arr.length-1));
        System.out.println(binary_search(arr,7,0,arr.length-1));
        System.out.println(binary_search(arr,8,0,arr.length-1));
        System.out.println(binary_search(arr,9,0,arr.length-1));
        System.out.println(binary_search(arr,10,0,arr.length-1));
        System.out.println(binary_search(arr,-1,0,arr.length-1));


    }
}
