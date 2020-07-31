package mentorMateTask;
import mentorMateTask.Grid;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try(Scanner gridSizeColumnsScanner = new Scanner(System.in);
			Scanner gridSizeRowsScanner = new Scanner(System.in);
			Scanner RowContentLineScanner = new Scanner(System.in);
			Scanner cellCoordinatesScannerX = new Scanner(System.in);
			Scanner cellCoordinatesScannerY = new Scanner(System.in);
			Scanner nScanner = new Scanner(System.in);) {
		
		System.out.print("Enter the number of desired columns: ");
		int columns = gridSizeColumnsScanner.nextInt();
				
		System.out.print("Enter the number of desired rows: ");
		int rows = gridSizeRowsScanner.nextInt();
		
		//Creation of an empty grid sized columns x rows
		Grid grid = new Grid(columns,rows);
		
		System.out.println("Enter " + rows + " lines of strings long " + columns  + " characters (0s and 1s): ");
		for(int i = 0; i < rows; i++) {
			String line = RowContentLineScanner.nextLine(); // RowContentLineScanner - each line is a row in the matrix
			char[] lineArray = line.toCharArray(); 
			if(lineArray.length > columns) {
				throw new IllegalArgumentException("Illegal Input!");
			}
			for(int z = 0; z < lineArray.length; z++) {
				if(lineArray[z] != '0' && lineArray[z] != '1') {
					throw new IllegalArgumentException("Illegal Input!");
				}
			}
			for(int j = 0; j < columns; j++) {
				if(lineArray[j] == '0') {
					grid.getCellAt(j, i).setColor(Color.RED);
				} else if(lineArray[j] == '1') {
					grid.getCellAt(j, i).setColor(Color.GREEN);
				}
			}
		}
				
		System.out.print("\nEnter the coordinates of the Cell to be observed: \n x1 = ");
		int cellCoordinatesX = cellCoordinatesScannerX.nextInt();
		if(cellCoordinatesX > columns) {
			throw new IllegalArgumentException("X can't be larger than " + columns + "; Exceeds Grid's size");	
		}

		
		System.out.print(" y1 = ");
		int cellCoordinatesY = cellCoordinatesScannerY.nextInt();
		if(cellCoordinatesY > rows) {
			throw new IllegalArgumentException("Y can't be larger than " + rows + "; Exceeds Grid's size");
		}
		System.out.println("\nEnter the amount of Generations to be generated: ");
		
		System.out.print(" N = ");
		int n = nScanner.nextInt();
			
		System.out.println("\n GenerationZero: ");
		grid.printGrid();
		
		ArrayList<Grid> allGenerationsOfGrid = grid.generateNextGenerations(grid, n);
		System.out.print("The chosen cell at" + grid.getCellAt(cellCoordinatesX, cellCoordinatesY).getPosition() + " is green |" + grid.howManyTimesGreen(allGenerationsOfGrid, grid.getCellAt(cellCoordinatesX, cellCoordinatesY)) + "| times in " + (n+1) + " Generations(" + n + " +  GenerationZero)"); // n+1, because of GenerationZero being included.
	}
	}

}
