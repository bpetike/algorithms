package sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuChecker {

    public boolean checkSolution(int[][] table) {
	if (!checkSize(table)) {
	    return false;
	}
	
	System.out.println("Rows valid: " + checkRows(table));
	System.out.println("Cols valid: " + checkCols(table));
	System.out.println("BlocksS valid: " + checkBlocks(table));
	return (checkRows(table) && checkCols(table) && checkBlocks(table));
    }

    private boolean checkBlocks(int[][] table) {
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		int[] block = createBlockArray(table, j, i);
		if (checkNumbers(block)) {
		    return false;
		}
	    }
	}
	return true;
    }

    private boolean checkCols(int[][] table)
    {
	for (int i = 0; i < table[0].length; i++) {
	    int[] currentCol = createCol(table, i);
	    if (checkNumbers(currentCol))
	    {
		return false;
	    }
	}
	return true;
    }
    
    private int[] createCol(int[][] table, int colIndex) {
	int[] col = new int[table.length];
	for (int i = 0; i < table.length; i++) {
	    int[] row = table[i];
	    col[i] = row[colIndex];
	}
	return col;
    }

    private boolean checkRows(int[][] table) {
	for (int i = 0; i < table.length; i++) {
	    if (checkNumbers(table[i])) {
		return false;
	    }
	}
	return true;
    }

    private int[] createBlockArray(int[][] table, int blockRowIndex, int blockColIndex) {
	int[] cell = new int[9];
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		cell[i * 3 + j] = table[blockRowIndex * 3 + i][blockColIndex * 3 + j];
	    }
	}
	return cell;
    }

    private boolean checkSize(int[][] table) {
	int length = 0;
	if (table.length == 9) {
	    for (int i = 0; i < table.length; i++) {
		if (table[i].length == 9) {
		    length++;
		}
	    }
	}
	return length == 9 ? true : false;
    }

    private boolean checkNumbers(int[] array) {
	Integer[] a = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }
        Set<Integer> hashSet = new HashSet<Integer>(Arrays.asList(a));
        return hashSet.size() != array.length;
    }

}
