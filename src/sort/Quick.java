package sort;

/*快速排序*/
public class Quick {
    public static void main(String[] args){
        int[] list={7,6,5,1,2,3,0,9,2,4};
        int[] a= list;
        quickSort(a,0,list.length-1);
        for(int value :a){
            System.out.println(value);
        }
    }
    public static void  quickSort(int[] a ,int left,int right){
        if(left<right){
            int dp=part(a,left,right);
            quickSort(a,left,dp-1);
            quickSort(a,dp+1,right);
        }
    }
    public static int  part(int[] a ,int left,int right){
        int temp =a[left];
        int i=left;
        int j=right;
        while(i<j){
            while(i<j && a[j]>=temp){
                j--;
                if(i<j){
                    a[i]=a[j];
                }
            }
            //a[i]=a[j]; //如果把a[i]=a[j]写在while外面，并不影响排序结果，但是会多一次赋值运算，浪费时间
            while(i<j && a[i]<=temp){
                i++;
                if(i<j){
                    a[j]=a[i];
                }
            }
            //a[j]=a[i]; //如果把a[j]=a[i]写在while外面，并不影响排序结果，但是会多一次赋值运算，浪费时间
        }
        a[i]=temp;
        return i;
    }
}
