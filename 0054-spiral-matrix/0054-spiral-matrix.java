class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int colBegin = 0;
        int rowBegin = 0;

        int colEnd = matrix[0].length - 1;
        int rowEnd = matrix.length - 1;

        while (colBegin <= colEnd && rowBegin <= rowEnd) {
            // →  left to right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // ↓  top to bottom
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            // ←  right to left
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            // ↑  bottom to top
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
                colBegin++;
            }
        }

        return res;
    }
}