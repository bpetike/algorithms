package spiral;


public class ClockwiseSpiral {
    public static int[][] createSpiral(int n)
    {
	int[][] result = new int[n][n];
	if (n < 1)
	{
	    return result;
	}
	int k = 1, top = 0, bottom = n-1, left = 0, right = n-1;
	int number = 1;
	while (number < n * n + 1) {
	    for (int i = left; i <=right; i++) {
		result[top][i] = number++;
		
	    }
	    for (int i = top + 1; i <= bottom; i++) {
		result[i][right] = number++;
	    }
	    
	    for (int i = right - 1; i >= left; i--) {
		result[bottom][i] = number++;
	    }
	    
	    
	    for (int i = bottom - 1; i >= top + 1; i--)
	    {
		result[i][left] = number++;
	    }
	    top++;
	    bottom--;
	    left++;
	    right--;
	}
	
	
	return result;
    }
    
    public static void main(String[] args) {
	long beginning = System.currentTimeMillis();
	int[][] matrix = ClockwiseSpiral.createSpiral(20000);
	long end = System.currentTimeMillis();
//	for (int i = 0; i < matrix.length; i++) {
//	    System.out.println(Arrays.toString(matrix[i]));	    
//	}
	System.out.println(beginning);
	System.out.println(end);
	System.out.println(end - beginning);
    }
}
