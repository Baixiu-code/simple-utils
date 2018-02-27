package test.base.structure.algorithm;


/**
 * @author chenfanglin
 * @desc quick sort
 * @date 2018年02月27日
 */
public class TestQuickSortStandard {

    public static void main(String[] args) {
        int[] arrays={6,2,39,12,32,2};
        quickSort(arrays,0,5);
        for (int i=0;i<arrays.length;i++) {
            System.out.println(arrays[i]);
        }
    }

    public static void quickSort(int[] arrays,int startIndex,int endIndex){
        if(startIndex>endIndex){
            return;
        }
        int standIndex=getPartitionIndex(arrays,startIndex,endIndex);
        //left partition Recursion
        quickSort(arrays,startIndex,standIndex-1);
        //right partition Recursion
        quickSort(arrays,standIndex+1,endIndex);
    }

    /**
     * get partition
     * @param arrays
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static  int getPartitionIndex(int[] arrays,int startIndex,int endIndex){
        int standValue=arrays[startIndex];
        while (startIndex<endIndex){
            while (startIndex<endIndex && arrays[endIndex]>=standValue){
                endIndex--;
            }
            arrays[startIndex]=arrays[endIndex];
            while (startIndex<endIndex && arrays[startIndex]<=standValue){
                startIndex++;
            }
            arrays[endIndex]=arrays[startIndex];
        }
        arrays[startIndex]=standValue;
        return startIndex;
    }

}
