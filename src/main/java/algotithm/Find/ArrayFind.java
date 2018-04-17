package algotithm.Find;

import sun.jvm.hotspot.oops.BranchData;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/27 11:03
 */
public class ArrayFind {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        int[][] arr2 = {{}};
        System.out.println(find(1, arr2));

    }

    public static boolean find2(int target, int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int cell = array[i][i];
                if (cell == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find(int target, int[][] array) {
        if (array == null) {
            return false;
        }

        int rows = array.length;
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }

        int rowIndex = rows - 1;
        int colIndex = 0;

        while (rowIndex >= 0 && colIndex <= cols - 1) {
            int cell = array[rowIndex][colIndex];
            if (cell < target) {
                colIndex++;
            } else if (cell > target) {
                rowIndex--;
            } else {
                return true;
            }
        }
        return false;
    }
}
