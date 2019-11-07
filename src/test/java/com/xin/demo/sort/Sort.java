package com.xin.demo.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
@Slf4j
public class Sort {
    /**
     * 冒泡排序：
     * 给定一个N个元素的数组，冒泡法排序将：
     * 如果元素大小关系不正确，交换这两个数（在本例中为a> b），
     * 比较一对相邻元素（a，b），
     * 重复步骤1和2，直到我们到达数组的末尾（最后一对是第（N-2）和（N-1）项，因为我们的数组从零开始）
     * 到目前为止，最大的元素将在最后的位置。 然后我们将N减少1，并重复步骤1，直到N = 1。
     *
     * 比较和交换需要一个以常量为界的时间，我们称之为c。
     * （标准）Bubble Sort中有两个嵌套循环。
     * 外循环正好运行N次迭代。 但内部循环运行变得越来越短：
     *
     * 当 i = 0，（N-1）次迭代（比较和可能交换）时。
     * 当 i = 1，（N-2）次迭代时，...
     * 当 i =（N-2）时，1次迭代,
     * 当 i=（N-1），0迭代.
     * 因此，总迭代次数=（N-1）+（N-2）+ ... + 1 + 0 = N *（N-1）/ 2（推导）。
     * 总时间= c * N *（N-1）/ 2 = O（N ^ 2）。
     */
    @Test
    public void bubSort(){
        int[] arr = {23,45,11,2,16};
        for (int i = 0;i < arr.length;i++){ // 表示n次排序过程
            for (int j =  1; j < arr.length - i;j++){
                if(arr[j] < arr[j-1]){ // 每次排序过程的两两比较
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
