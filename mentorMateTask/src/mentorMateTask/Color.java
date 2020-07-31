package mentorMateTask;

public enum Color {
	GREEN(1),
	RED(0);
	
	private final int value;

	Color(int i) {
		this.value = i;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void printColor() {
		System.out.print(this.toString());
	}
	
	@Override 
	public String toString() {
		String result = this.getValue() + "(" + this.name().toString() + ")";
		return result;
	}
	
}
