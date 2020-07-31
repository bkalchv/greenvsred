package mentorMateTask;
import mentorMateTask.Position;
import mentorMateTask.Color;



public class Cell {
	private Position position;
	private Color color;
	
	public Cell() {
		position = new Position();
	}
	
	public Cell(Color col) {
		this.color = col;
	}
	
	public Cell(Position pos, Color col) {
		this.position = pos;
		this.color = col;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setPosition(int columnNr, int rowNr) { // sets a position, so that it represents a position, as given in the task [X;Y], X - columnNr, Y - rowNr 
		if(this.position == null) {
			Position newPosition = new Position();
			newPosition.setColumnNr(columnNr);
			newPosition.setRowNr(rowNr);
			this.position = newPosition;
		} else {
		this.position.setColumnNr(columnNr);
		this.position.setRowNr(rowNr);
		}
	}
	
	public void setColor(Color col) {
		this.color = col;
	}
	
	public void printCell() {
		System.out.print("Cell at:");
		this.position.printPosition();
		System.out.print(", color: ");
		this.color.printColor();
	}
	
	@Override
	public String toString() {
		String result = this.color.toString() + " Position:" + this.position.toString();
		return result;
	}
}
