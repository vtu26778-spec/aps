class Solution {
    public int[][] floodFill(int[][] image, int i, int j, int color) {
        int oldColor = image[i][j];

        if(oldColor != color) dfs(image,i,j,color,oldColor);
        
        return image;
    }
    public void dfs(int[][] image, int i, int j, int color,int oldColor){
        if(i<0 || i >= image.length || j<0 || j >= image[0].length || image[i][j] != oldColor) return;

        image[i][j] = color;

        dfs(image,i+1,j,color,oldColor);
        dfs(image,i-1,j,color,oldColor);
        dfs(image,i,j+1,color,oldColor);
        dfs(image,i,j-1,color,oldColor);
    }
}