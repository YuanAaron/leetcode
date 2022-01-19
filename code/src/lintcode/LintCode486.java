package lintcode;

import java.util.*;

public class LintCode486 {

    public int[] mergeKSortedArrays(int[][] arrays) {
        List<Integer> res = new ArrayList<>();

        //Queue<int[]> queue = new PriorityQueue<>(arrays.length,(o1, o2)->o1[0]-o2[0]); // 默认是小根堆
        Queue<int[]> queue = new PriorityQueue<>(arrays.length, Comparator.comparingInt(o -> o[0]));

        //将K个数组的第一个元素都加入优先队列中
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length == 0) { //注意：这里对应{{},{}}情况，arrays[i]可以有，arrays[i][0]不可以
                continue;
            }
            // 优先队列的每个节点都是一个数组，三个元素分别是：这个点的值，所在数组的编号，在数组中的下标
            int[] node = new int[3];
            node[0] = arrays[i][0];
            node[1] = i;
            node[2] = 0; //默认为0，因此可以不写
            queue.offer(node);
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            res.add(node[0]);

            // 将当前节点所在的数组的下一个元素加入队列
            // 到达某个数组的最后一个元素
            if (node[2] == arrays[node[1]].length-1) {
                continue;
            }
            node[0] = arrays[node[1]][node[2]+1];
            node[2] = node[2] + 1;
            queue.offer(node);
        }
        // list转成int[]
        return res.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        int[][] arr = {{},{}};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]);
        }
    }
}
