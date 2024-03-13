class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;
        List<Integer> ans = new ArrayList<>();
        while(ans.size() < matrix.length*matrix[0].length){
            if(ans.size() == matrix.length*matrix[0].length) break;
            rowLeftToRight(up, left, right, ans, matrix);
            if(ans.size() == matrix.length*matrix[0].length) break;
            columnTopToBot(right, up+1, down-1, ans, matrix);
            if(ans.size() == matrix.length*matrix[0].length) break;
            rowRightToLeft(down, right, left, ans, matrix);
            if(ans.size() == matrix.length*matrix[0].length) break;
            columnBotToTop( left, down-1, up+1, ans, matrix);
            
            left++;
            right--;
            up++;
            down--;
        }
        return ans;
    }

    public void rowLeftToRight(int rownum, int start, int end, List<Integer> ans, int[][] matrix){
        for(int i = start;i<=end;i++){
            ans.add(matrix[rownum][i]);
        }
    }

    public void rowRightToLeft(int rownum, int start, int end, List<Integer> ans, int[][] matrix){
        for(int i = start;i>=end;i--){
            ans.add(matrix[rownum][i]);
        }
    }

    public void columnTopToBot(int colnum, int start, int end, List<Integer> ans, int[][] matrix){
        for(int i = start;i<=end;i++){
            ans.add(matrix[i][colnum]);
        }
    }

    public void columnBotToTop(int colnum, int start, int end, List<Integer> ans, int[][] matrix){
        for(int i = start;i>=end;i--){
            ans.add(matrix[i][colnum]);
        }
    }
}