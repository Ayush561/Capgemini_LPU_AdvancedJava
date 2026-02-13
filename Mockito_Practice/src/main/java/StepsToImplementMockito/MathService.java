package StepsToImplementMockito;

public class MathService { //Business logic of calculator
	Calculator cal;
	
	public MathService(Calculator cal) {
		this.cal=cal;
	}
	
	public int doubleAddition(int a,int b) {
		return 2*cal.add(a, b);
	}

	
	
	
}
