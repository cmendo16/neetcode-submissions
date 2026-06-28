class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>(); // values we have seen for cols, rows, and subboxes
        for(int i = 0; i < 9; i++) { 
            for(int j = 0; j < 9; j++) { 
                char val = board[i][j]; 
                if(val == '.') continue; 

                String keyRow = "r" + i + val;
                String keyCol = "c" + j + val;
                String keySubBox = "b" + (i/3) + (j/3) + val;

                if(!seen.contains(keyRow)) {
                    seen.add(keyRow); 
                } else if(seen.contains(keyRow)) {
                    return false; 
                }

                if(!seen.contains(keyCol)) {
                    seen.add(keyCol);
                } else if(seen.contains(keyCol)) {
                    return false; 
                }

                if(!seen.contains(keySubBox)) {
                    seen.add(keySubBox);
                } else if(seen.contains(keySubBox)) {
                    return false; 
                }

                
            }

            
        }

        return true;
    }
}
