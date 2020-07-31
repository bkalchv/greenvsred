package mentorMateTask;

public class Position {
	private int columnNr;
	private int rowNr;
	
	
	
	public Position() { /* default position for now: 0,0 */
		columnNr = 0;
		rowNr = 0;
	}
	
	public int getRowNr() {
		return rowNr;
	}
	
	public void setRowNr(int y) {
		this.rowNr = y;
	}
	
	public int getColumnNr() {
		return columnNr;
	}
	
	public void setColumnNr(int x) {
		this.columnNr = x;
	}
	
	public void printPosition() {
		System.out.print(" [" + columnNr + ";" + rowNr + "]");
	}
	
	@Override
	public String toString() {
		String result = " [" + columnNr + ";" + rowNr + "]";
		return result;
	}
}
