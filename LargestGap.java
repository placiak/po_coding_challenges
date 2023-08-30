import java.util.*;

public class LargestGap {
    public static void main(String...args){

        int[] arr = getNumbers();
        int[] myArr = removeDuplicates(arr);
        Arrays.sort(myArr);
        System.out.println(findGap(myArr));
    }

    public static int[] getNumbers(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of your array:");
        int arrayLength = scan.nextInt();
        int[] myArray = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            myArray[i] = scan.nextInt();
        }
        return myArray;
    }

    public static int[] removeDuplicates(int[] newArray){
        HashSet<Integer> newSet = new HashSet<>();
        for(int element : newArray){
            newSet.add(element);
        }
        int i = 0;
        int[] uniqueArray = new int[newSet.size()];
        for(int element : newSet){

            uniqueArray[i++] = element;
        }
        return uniqueArray;
    }


    public static int findGap(int[] gapArr){

        int maxGap = 0;
        int gap = 0;
        for(int i =0; i < gapArr.length-1; i++){
            gap = gapArr[i+1] - gapArr[i];
            if(gap>maxGap){
                maxGap = gap;
            }
            if(gapArr.length<2){
                return 0;
            }
        }
        return maxGap;
    }
}
