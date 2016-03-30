package annotations;

import java.util.*;
import atunit.*;

public class Ex8 {
	
	int value;
	
	private void setValue (int value) {this.value=value;}
	public int getValue () {return value;}
	
	@Test boolean getTest() {
		setValue(5);
		return (getValue()==value);
	}
	
	@Test boolean setTest() {
		setValue(5);
		return (value==5);
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
