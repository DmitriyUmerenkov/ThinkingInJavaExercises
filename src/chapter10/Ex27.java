package chapter10;
import java.util.*;


class Command {
	Command (String st) {this.st=st;}
	String st;
	public void operation() {System.out.println(st);}
	
}

class Queeor {
	static Queue getCommandQueue() {
		Queue<Command> q = new LinkedList<Command>();
		for (int i=0;i<10;i++) q.add(new Command("Command no "+i));
		
		
		return q;
	}
	
}


public class Ex27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Command> q = Queeor.getCommandQueue();
		
		while (q.peek()!=null) {
			q.poll().operation();
		}

	}

}
