import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MagicSquares {
	public static boolean testMagic(String pathName) throws FileNotFoundException, IOException {

		boolean isMagic = false;
		int lastSum = -1;
		int linesInFile = 0;
		String line;
		
		String[][] array2D = new String[10][10]; // array size "10" is set for this assignment
		
		try {
			// Open the file
			BufferedReader reader = new BufferedReader(new FileReader(pathName));
			while ((line = reader.readLine()) != null) {
				
				// use "continue" for these text files have a "" string every other line
				if (line.equals("")) {
					continue;
				}
				// put strings into array
				array2D[linesInFile] = line.split("\t");
				linesInFile++;
			}
			reader.close();
		} catch (IOException e) {
			throw e;
		}

		int rowSum = 0;
		for (int i = 0; i < linesInFile; i++) {
			rowSum = 0;
			for (int j = 0; j < linesInFile; j++) {
				rowSum += Integer.parseInt(array2D[i][j]);
			}
			if (lastSum == -1) {
				lastSum = rowSum;
			} else if (lastSum != rowSum) {
				isMagic = false;
				break;
			}
		}
		System.out.println("row sum " + rowSum);

		int colSum = 0;
		for (int i = 0; i < linesInFile; i++) {
			colSum = 0;
			for (int j = 0; j < linesInFile; j++) {
				colSum += Integer.parseInt(array2D[j][i]);
			}
			if (lastSum == -1) {
				lastSum = colSum;
			} else if (lastSum != colSum) {
				isMagic = false;
				break;
			}
		}
		System.out.println("col sum: " + colSum);

		int diagnoalSum1 = 0;
		for (int i = 0; i < linesInFile; i++) {
			diagnoalSum1 += Integer.parseInt(array2D[i][i]);
		}
		System.out.println("diagnoal sum1: " + diagnoalSum1);

		int diagnoalSum2 = 0;
		for (int i = 0; i < linesInFile; i++) {
			diagnoalSum2 += Integer.parseInt(array2D[i][linesInFile - i - 1]);
		}
		System.out.println("diagnoal sum2: " + diagnoalSum2);

		/*
		 * for a real magic square, sum of the integers in each row, column and
		 * diagonal is equal.
		 */
		if ((rowSum != colSum) || (colSum != diagnoalSum1) || (diagnoalSum1 != diagnoalSum2)) {
			isMagic = false;
		}else{
			isMagic = true;
		}

		return isMagic;
	}

	public static void main(String[] args) {
		String[] fileNames = { "Mercury.txt", "Luna.txt" };
		for (String fileName : fileNames) {
			System.out.println(fileName + " is magic? ");
			try {
				if (testMagic(fileName)) {
					System.out.println("For the square in the file" + fileName
							+ ", sum of the integers in each row, column and diagonal is equal.");
					System.out.println("The square in " + fileName + " is a magic square.");
				}else {
					System.out.println("The square in " + fileName + " is not a magic square.");
				}
			} catch (FileNotFoundException e) {
				System.out.println("Can not find file: " + fileName +" cause: " +e.toString());
			} catch (IOException e) {
				System.out.println("Can not read file: " + fileName +" cause: " +e.toString());
			}
		}
	}
}
