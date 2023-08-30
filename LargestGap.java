import java.util.*;

public class LargestGap {
    public static void main(String...args){

        int[] arr = getNumbers();
        int[] myArr = removeDuplicates(arr);
        Arrays.sort(myArr);
        int gapSize = findGap(myArr);
        System.out.println("The largest gap for this array is: " + gapSize);
     
    }

    public static int[] getNumbers(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of your array:");
        int arrayLength = scan.nextInt();
        clearScreen();
        int[] myArray = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            System.out.println("Enter array element value:");
            myArray[i] = scan.nextInt();
            clearScreen();
            
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
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
            
}
}
