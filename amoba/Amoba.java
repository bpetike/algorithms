package amoba;

import java.util.Arrays;

public class Amoba {
    private static int TABLE_WIDTH = 30;
    private static int TABLE_HEIGHT = 30;

    private static char SIGN_EMPTY = '.';
    private static char SIGN_X = 'X';
    private static char SIGN_O = 'O';

    private static final int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    private char[][] gameField = new char[TABLE_WIDTH][TABLE_HEIGHT];

    public Amoba() {
	init();
	for (char[] is : gameField) {
	    System.out.println(Arrays.toString(is));
	}
	System.out.println(isEndGame());
    }

    public void init() {
	boolean isX = true;
	for (int j = 0; j < gameField.length; j++) {
	    for (int i = 0; i < gameField[j].length; i++) {
		double p = Math.random();
		if (p < 0.5) {
		    gameField[j][i] = SIGN_EMPTY;
		} else {
		    gameField[j][i] = isX ? SIGN_X : SIGN_O;
		    isX = !isX;
		}
	    }
	}
    }

    private int countEquals(int i, int j, int[] direction) {
	int count = 1;
	char actualField = gameField[i][j];
	if (actualField == SIGN_EMPTY) {
	    return 0;
	}
	while (count < 5) {
	    int di = i + direction[0] * count;
	    int dj = j + direction[1] * count;
	    if (di >= 0 && dj >= 0 && di < gameField.length && dj < gameField[di].length
		    && gameField[di][dj] == actualField) {
		count++;
	    } else {
		break;
	    }
	}

	return count;
    }

    public boolean isEndGame() {
	for (int j = 0; j < gameField.length; j++) {
	    for (int i = 0; i < gameField[j].length; i++) {
		for (int[] is : DIRECTIONS) {
		    if (countEquals(i, j, is) > 4) {
			return true;
		    }
		}
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	new Amoba();
    }
}
