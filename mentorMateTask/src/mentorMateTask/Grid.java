package mentorMateTask;
import java.util.ArrayList;
import mentorMateTask.Cell;

public class Grid {
	private Cell[][] grid;
	private int columns;
	private int rows;
	
	public Grid(int columns, int rows) { // Grid Constructor; Generates an empty Grid(colorless); Columns as the first argument, rows as the second one, so that it fits the task's position format better
		this.columns = columns;
		this.rows = rows;
		this.grid = new Cell[rows][columns]; // Building the empty Grid as an array of arrays. Row by row;
		for(int row = 0; row < this.rows; row++) {
			for(int col = 0; col < this.grid[row].length; col++) {
				grid[row][col] = new Cell();
				grid[row][col].setPosition(col, row); // !CHECK .setPosition(int,int) OUT! Actually sets the position at grid[row][col]; Cell.setPosition(int, int) accepts the column number as the first argument, the column row as the second, so that the position format of the task is kept and is not as confusing. 
			}
		}
	}
	
	public Grid generateNextGenerationGrid() { // returns the next generation Grid of the current Grid object, based on the conditions, mentioned in the task
		Grid newgrid;
		newgrid = new Grid(this.columns, this.rows);
		
		for(int row = 0; row < newgrid.rows; row++) {
			for(int col = 0; col < newgrid.columns; col++) {
				newgrid.getGrid()[row][col] = new Cell();
				newgrid.getGrid()[row][col].setPosition(col, row);
				
				Cell tempCell = this.getCellAt(col, row);
				int greenNeighboursTempCell = this.getGreenNeighboursOfCell(tempCell);
				if(tempCell.getColor() == Color.RED) {
					if(greenNeighboursTempCell == 3 || greenNeighboursTempCell == 6) {
						newgrid.getCellAt(col, row).setColor(Color.GREEN);
					} else {
						newgrid.getCellAt(col, row).setColor(Color.RED);
					}
				} else if(tempCell.getColor() == Color.GREEN) {
					if(greenNeighboursTempCell == 2 || greenNeighboursTempCell == 3 || greenNeighboursTempCell == 6) {
						newgrid.getCellAt(col, row).setColor(Color.GREEN);
					} else {
						newgrid.getCellAt(col, row).setColor(Color.RED);
					}
				}
			}
		}
		return newgrid;
	}
	
	public ArrayList<Grid> generateNextGenerations(Grid gridGenerationZero,int n) { // returns an ArrayList containing all the N generations of the current object, including generationZero;
		ArrayList<Grid> allGenerations = new ArrayList<Grid>();
		allGenerations.add(gridGenerationZero);
		Grid gridGenerationN = gridGenerationZero.generateNextGenerationGrid();
		allGenerations.add(gridGenerationZero);
		if(n > 0) {
			for(int i = 0; i < n; i++) {
				allGenerations.add(gridGenerationN);
				gridGenerationN = gridGenerationN.generateNextGenerationGrid();
			}
		} else {
			throw new IllegalArgumentException("N can't be < 0");
		}
				
		return allGenerations;
	}
	
	public int howManyTimesGreen(ArrayList<Grid> allGenerations, Cell cellche) { // returns how many times a cell has been green from Generation Zero to Generation N
		int timesGreen = 0;
		for(Grid each: allGenerations) {
			if(each.getCellAt(cellche.getPosition().getColumnNr(), cellche.getPosition().getRowNr()).getColor() == Color.GREEN) {
				timesGreen++;
			}
		}
		
		return timesGreen;
	}

	public Cell[][] getGrid() { 
		return grid;
	}
	
	public Cell getCellAt(int column, int row) { // Accessing a Cell from the grid. Arguments are switched, so that the position format of the task is kept; 
		return grid[row][column]; // Actually accessing [row][column] and not [column][row], because usually matrices are being created row by row and not the opposite;
	}
	
	public ArrayList<Cell> getCellNeighboursArray(Cell cellche) { // returns an ArrayList containing Cells that are the neighbours of the argument cellche, no matter the color
		ArrayList<Cell> neighbours = new ArrayList<Cell>();
		Position cellchePosition = cellche.getPosition();
		boolean hasNeighbourAbove = false, hasNeighbourBelow = false, hasNeighbourLeft = false, hasNeighbourRight = false;
		
		if(cellchePosition.getRowNr() - 1 >= 0) { // has an neighbour above;
			hasNeighbourAbove = true;
			neighbours.add(this.getCellAt(cellche.getPosition().getColumnNr(), cellche.getPosition().getRowNr()-1));
		}
		if(cellchePosition.getRowNr() + 1 < this.rows) { //has a neighbour below;
			hasNeighbourBelow = true;
			neighbours.add(this.getCellAt(cellche.getPosition().getColumnNr(), cellche.getPosition().getRowNr()+1));
		}
		if(cellchePosition.getColumnNr() - 1 >= 0) { // has a left neighbour;
			hasNeighbourLeft = true;
			neighbours.add(this.getCellAt(cellche.getPosition().getColumnNr()-1, cellche.getPosition().getRowNr()));
		}
		if(cellchePosition.getColumnNr() + 1 < this.columns) { // has a right neighbour;
			hasNeighbourRight = true;
			neighbours.add(this.getCellAt(cellche.getPosition().getColumnNr()+1, cellche.getPosition().getRowNr()));
		}
		
		if(hasNeighbourAbove && hasNeighbourLeft) { // has a neighbour diagonally
			neighbours.add(this.getCellAt(cellche.getPosition().getColumnNr()-1, cellche.getPosition().getRowNr()-1));
		}
		if(hasNeighbourBelow && hasNeighbourLeft) { // has a neighbour diagonally
			neighbours.add(this.getCellAt(cellche.getPosition().getColumnNr()-1, cellche.getPosition().getRowNr()+1));
		}
		if(hasNeighbourBelow && hasNeighbourRight) { // has a neighbour diagonally
			neighbours.add(this.getCellAt(cellche.getPosition().getColumnNr()+1, cellche.getPosition().getRowNr()+1));
		}
		if(hasNeighbourAbove && hasNeighbourRight) { // has a neighbour diagonally
			neighbours.add(this.getCellAt(cellche.getPosition().getColumnNr()+1, cellche.getPosition().getRowNr()-1));
		}
				
		return neighbours;	
	}
	
	public int getGreenNeighboursOfCell(Cell cellche) { // returns the amount of green neighbours the argument cellche has
		int greenNeighbours = 0;
		ArrayList<Cell> neighbours= this.getCellNeighboursArray(cellche);
		for(Cell each: neighbours) {
			if(each.getColor() == Color.GREEN) {
				greenNeighbours++;
			}
		}
		
		return greenNeighbours;
	}
	
	public void printGrid() { // prints the Grid in the console; useful for debugging 
		if(this.grid.length != 0) {
			for(int row = 0; row < this.rows; row++) {
				if(row > 0) {
					System.out.println();
				}
				for(int col = 0; col < this.columns; col++) {
					if(this.getCellAt(col, row).getColor() != null) {
					System.out.print(this.getCellAt(col, row).getColor().getValue());
					this.getCellAt(col, row).getPosition().printPosition();
					System.out.print(" ");
					}
				}
			}
			System.out.println();
			System.out.println();
		} else {
			System.out.println("Grid is empty!; Cannot be printed.");
		}
	}
	
}
