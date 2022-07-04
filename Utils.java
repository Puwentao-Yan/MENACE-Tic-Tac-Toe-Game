import java.util.Random;
import java.io.Console;

public class Utils {
	public static final Random generator = new Random();
	public static final Console console = System.console();
	public static final String NEW_LINE = System.getProperty("line.separator");


    /**
     * This method rotates array of size lines * columns referenced
     * by transformedBoard by 90 degree clockwise. For example, the
     * 3*3 game
     *
     * 1 | 2 | 3
     * ----------
     * 4 | 5 | 6
     * ----------
     * 7 | 8 | 9
     *
     * for which lines = 3 and columns = 3 is represented by the array
     * transformedBoard = {1,2,3,4,5,6,7,8,9}
     *
     * the method rotates it into the game
     *
     * 7 | 4 | 1
     * ----------
     * 8 | 5 | 2
     * ----------
     * 9 | 6 | 3
     *
     * that is, after the method, transformedBoard = {7,4,1,8,5,2,9,6,3}
     *
     * @param lines
     *  the number of lines in the game
     * @param columns
     *  the number of columns in the game
     * @param transformedBoard
     *  Reference to a 1 dimentional array of size columns x lines
     */


    public static void rotate(int lines, int columns, int[] transformedBoard){
        int temp = 0;
        int tempp = 0;
        int k = 0;
        int h = lines;
        int w = 2;
        int z = 1, f = 1;
        int rotateTimes = columns / 2;
        int col = columns;
        for(int j = 0; j < rotateTimes; j++){
            temp = transformedBoard[j*columns+j];
            transformedBoard[j*columns+j] = transformedBoard[h*columns-h];
            transformedBoard[h*columns-h] = transformedBoard[h*columns-z];
            transformedBoard[h*columns-z] = transformedBoard[f*columns-f];
            transformedBoard[f*columns-f] = temp;

            for(int i = 0; i < (col - 2); i++){
                tempp = transformedBoard[k*columns+k+1+i];
                transformedBoard[k*columns+k+1+i] = transformedBoard[(h-1)*columns - h-(i*columns)];
                transformedBoard[(h-1)*columns - h-(i*columns)] = transformedBoard[h*columns - w - i];
                transformedBoard[h*columns - w - i] = transformedBoard[w*columns-k-1+columns*i];
                transformedBoard[w*columns-k-1+columns*i] = tempp;
            }
            w ++;
            h --;
            k ++;
            z ++;
            f ++;
            col -= 2;

        }
    }

    /**
     * This method does an horizontal symmetry on array of size lines * columns referenced
     * by transformedBoard. For example, the
     * 3*3 game
     *
     *
     * 1 | 2 | 3
     * ----------
     * 4 | 5 | 6
     * ----------
     * 7 | 8 | 9
     *
     * for which lines = 3 and columns = 3 is represented by the array
     * transformedBoard = {1,2,3,4,5,6,7,8,9}
     *
     * the method transforms it into the game   
     *
     * 7 | 8 | 9
     * ----------
     * 4 | 5 | 6
     * ----------
     * 1 | 2 | 3
     *
     * that is, after the method, transformedBoard = {7,8,9,4,5,6,1,2,3}
     *
     * @param lines
     *  the number of lines in the game
     * @param columns
     *  the number of columns in the game
     * @param transformedBoard
     *  Reference to a 1 dimentional array of size columns x lines
     */

    public static  void horizontalFlip(int lines, int columns, int[] transformedBoard){
        int flipTimes = lines / 2;
        int a = 0;
        int temp = 0;
        int col = columns;
        int coln = columns;
        int count = 1;
        for(int i = 0; i < flipTimes; i++){
            for(int j=a; j < coln; j++){
                temp = transformedBoard[j];
                transformedBoard[j] = transformedBoard[transformedBoard.length - col];
                transformedBoard[transformedBoard.length - col] = temp;
                col--;
            }
            coln += columns;
            col = columns;
            count++;
            col = col * count;
            a += columns;
        }
    }

   /**
     * This method does an vertical symmetry on array of size lines * columns referenced
     * by transformedBoard. For example, the
     * 3*3 game
     *
     * 1 | 2 | 3
     * ----------
     * 4 | 5 | 6
     * ----------
     * 7 | 8 | 9
     *
     * for which lines = 3 and columns = 3 is represented by the array
     * transformedBoard = {1,2,3,4,5,6,7,8,9}
     *
     * the method transforms it into the game   
     *
     * 3 | 2 | 1
     * ----------
     * 6 | 5 | 4
     * ----------
     * 9 | 8 | 7
     *
     * that is, after the method, transformedBoard = {3,2,1,6,5,4,9,8,7}
     *
     * @param lines
     *  the number of lines in the game
     * @param columns
     *  the number of columns in the game
     * @param transformedBoard
     *  Reference to a 1 dimentional array of size columns x lines
     */

    public static  void verticalFlip(int lines, int columns, int[] transformedBoard){
        int flipTimes = columns / 2;
        int a = 0;
        int temp = 0;
        int col = columns;
        int count = 1;
        for(int i = 0; i < lines; i++){
            for(int j = a; j < (a + flipTimes); j++){
                temp = transformedBoard[j];
                transformedBoard[j] = transformedBoard[col - 1];
                transformedBoard[col - 1] = temp;
                col--;
            }
            count++;
            col = columns;
            col = columns * count;
            a += columns;
        }
        

    }

    private static void test(int lines, int columns){
    	int[] test;
    	test = new int[lines*columns];
    	for(int i = 0 ; i < test.length; i++){
    		test[i] = i;
    	}
    	System.out.println("testing " + lines + " lines and " + columns + " columns.");
    	System.out.println(java.util.Arrays.toString(test));
    	horizontalFlip(lines,columns,test);
    	System.out.println("HF => " + java.util.Arrays.toString(test));
    	horizontalFlip(lines,columns,test);
    	System.out.println("HF => " + java.util.Arrays.toString(test));
    	verticalFlip(lines,columns,test);
    	System.out.println("VF => " + java.util.Arrays.toString(test));
    	verticalFlip(lines,columns,test);
    	System.out.println("VF => " + java.util.Arrays.toString(test));
    	if(lines == columns){
    		for(int i = 0; i < 4; i++) {
		    	rotate(lines,columns,test);
		    	System.out.println("ROT => " + java.util.Arrays.toString(test));    			
    		}
    	}
    }

    public static void main(String[] args){
    	int[] test;
    	int lines, columns;

    	test(2,2);
    	test(2,3);
    	test(3,3);
    	test(4,3);
    	test(4,4);


    }
}