package suanfa.paixu;

public class paixu {
	
	/**
	 * 快速排序 （分治,交换）
	 */
	public static void quickSort(int a[],int l,int r){
	     if(l>=r)
	       return;
	     int i = l; int j = r; int key = a[l];//选择第一个数为key

	     while(i<j){

	         while(i<j && a[j]>=key)//从右向左找第一个小于key的值
	             j--;
	         if(i<j){
	             a[i] = a[j];
	             i++;
	         }

	         while(i<j && a[i]<key)//从左向右找第一个大于key的值
	             i++;

	         if(i<j){
	             a[j] = a[i];
	             j--;
	         }
	     }
	     //i == j
	     a[i] = key;
	     quickSort(a, l, i-1);//递归调用
	     quickSort(a, i+1, r);//递归调用
	 }
	
	/**
	 * 冒泡排序(交换)
	 */
	public static void bubbleSort(int arr[]) {
	    boolean didSwap;
	    for(int i = 0, len = arr.length; i < len - 1; i++) {
	        didSwap = false;
	        for(int j = 0; j < len - i - 1; j++) {
	            if(arr[j + 1] < arr[j]) {
	                int sem=0;
	                sem=arr[j];
	                arr[j]=arr[j+1];
	                arr[j+1]=sem;
	                didSwap = true;
	            }
	        }
	        if(didSwap == false)
	            return;
	    }    
	}
	
	/**
	 * 直接插入排序（打牌）
	 */
	public static void  insert_sort(int array[],int lenth){

		   int temp;

		   for(int i=0;i<lenth-1;i++){
		       for(int j=i+1;j>0;j--){
		           if(array[j] > array[j-1]){
		               temp = array[j-1];
		               array[j-1] = array[j];
		               array[j] = temp;
		           }else{         //不需要交换
		               break;
		           }
		       }
		   }
		}
	/**
	 * 直接选择排序(打擂台) 
	 */
	public static void select_sort(int array[],int lenth){

		   for(int i=0;i<lenth-1;i++){

		       int minIndex = i;
		       for(int j=i+1;j<lenth;j++){
		          if(array[j]<array[minIndex]){
		              minIndex = j;
		          }
		       }
		       if(minIndex != i){
		           int temp = array[i];
		           array[i] = array[minIndex];
		           array[minIndex] = temp;
		       }
		   }
		}
}
