class Solution {
    public void setZeroes(int[][] matrix) {
        boolean colz = false;
        boolean rowz = false;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        rowz = true;
                    }
                    if(j==0){
                        colz = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                Arrays.fill(matrix[i],0);
            }
        }
        for(int j = 1;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                for(int i = 0;i<matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowz){
            Arrays.fill(matrix[0],0);
        }
        if(colz){
            for(int i = 0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}