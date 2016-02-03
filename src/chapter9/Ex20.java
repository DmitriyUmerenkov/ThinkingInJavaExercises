package chapter9;

interface EmergencyExit {
	void getOut();
	
	class Exits{
		void exitDoor(){System.out.println("Exit by the door");}
		void exitWindow(){System.out.println("Exit by the window");}
		static void checkExits(EmergencyExit e) {e.getOut();}
		
		
		}
	}

class FireExit implements EmergencyExit {

	@Override
	public void getOut() {
		// TODO Auto-generated method stub
		System.out.println("Exit by the fire exit");
		
	}
	
}


class House implements EmergencyExit {

	Exits evacuate=new Exits();
	@Override
	public void getOut() {
		// TODO Auto-generated method stub
		evacuate.exitDoor();
		evacuate.exitWindow();
	}
	
}



public class Ex20 {

	static public void main(String[] Args) {
		House aHouse=new House();
		aHouse.getOut();
		EmergencyExit.Exits.checkExits(aHouse);;	
	}
	
}
