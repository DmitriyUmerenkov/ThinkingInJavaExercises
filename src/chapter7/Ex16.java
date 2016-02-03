package chapter7;

import static util.Print.*;

class AlertStatus{
	
	public void Alert(){};
	
}

class GreenAlert extends AlertStatus {
	
	public void Alert() {print("All clear");}
		
}

class YellowAlert extends AlertStatus {
	
	public void Alert() {print("Danger coming");}
		
}
class RedAlert extends AlertStatus {
	
	public void Alert() {print("Imminent danger");}
		
}



class Starship
{

	AlertStatus status = new GreenAlert();	
 
	public void GoToGreen() {status = new GreenAlert();	}
	public void GoToYellow() {status = new YellowAlert();	}
	public void GoToRed() {	status = new RedAlert();	}
	
	public void Status() {status.Alert();}
	
	

}


public class Ex16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Starship Enterprise = new Starship();
		Enterprise.Status();
		Enterprise.GoToYellow();
		Enterprise.Status();
		Enterprise.GoToRed();
		Enterprise.Status();
	}

}
