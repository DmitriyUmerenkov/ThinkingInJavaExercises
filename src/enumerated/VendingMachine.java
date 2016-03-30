package enumerated;

import java.util.*;
import util.*;
import static enumerated.Input.*;
import static util.Print.*;
enum Category {
  MONEY(NICKEL, DIME, QUARTER, DOLLAR),
  ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
  QUIT_TRANSACTION(ABORT_TRANSACTION),
  SHUT_DOWN(STOP);
  private Input[] values;
  Category(Input... types) { values = types; }
  private static EnumMap<Input,Category> categories =
    new EnumMap<Input,Category>(Input.class);
  static {
    for(Category c : Category.class.getEnumConstants())
      for(Input type : c.values)
        categories.put(type, c);
  }
  public static Category categorize(Input input) {
    return categories.get(input);
  }
}
public class VendingMachine {
  private static State[] state = new State[] {State.RESTING, State.RESTING};
  private static int[] amount = new int[] {0,0};
  private static Input[] selection = new Input[] {null, null};
 
  enum StateDuration { TRANSIENT } // Tagging enum
  interface Handler {default public void next(Input input, int machine) {} default public void next(int machine) {} default public void output(){}}
  
  static EnumMap<State, Handler> machState[] = new EnumMap[] {new EnumMap<State, Handler>(State.class),new EnumMap<State, Handler>(State.class)};
  
  static {
	  machState[0].put(State.RESTING, new Handler() {
		  public void next(Input input, int machine) {
        switch(Category.categorize(input)) {
          case MONEY:
        	  print("Money from rest, recieved: "+input.amount());
            amount[machine] += input.amount();
            state[machine] = State.ADDING_MONEY;
            break;
          case SHUT_DOWN:
            state[machine] = State.TERMINAL;
default: }
}});
  
	  machState[0].put(State.ADDING_MONEY, new Handler() {

		        public void next(Input input, int machine) {
		          switch(Category.categorize(input)) {
		            case MONEY:
		              amount[machine] += input.amount();
		              print("Added "+ input.amount() + " current amount:"+ amount[machine]);
		              break;
		            case ITEM_SELECTION:
		              selection[machine] = input;
		              if(amount[machine] < selection[machine].amount())
		                print("Insufficient money for " + selection[machine]);
		              else state[machine] = State.DISPENSING;
		              break;
		            case QUIT_TRANSACTION:
		              state[machine] = State.GIVING_CHANGE;
		              break;
		            case SHUT_DOWN:
		              state[machine] = State.TERMINAL;
		  default: }
		  } 
  });
  
	  machState[0].put(State.DISPENSING, new Handler() {
		    public void next(int machine) {
		         print("here is your " + selection[machine]);
		         amount[machine] -= selection[machine].amount();
		         state[machine] = State.GIVING_CHANGE;
		 }  	  
	  });
	  
	  machState[0].put(State.GIVING_CHANGE, new Handler() {
		  
		  public void next(int machine) {
	    	  if(amount[machine] > 0) {

	    	  	print("Your change: " + amount[machine]);
	    	  amount[machine] = 0; }
	    	          state[machine] = State.RESTING;
	    	        }		  
	  });
	  
	  machState[0].put(State.TERMINAL, new Handler() {
		  public void output() { print("Halted"); } 
	  });  
  
  machState[1]=machState[0].clone();
  }
  	  
  enum State {
    RESTING,
    ADDING_MONEY,
    DISPENSING(StateDuration.TRANSIENT),
    GIVING_CHANGE(StateDuration.TRANSIENT),
    TERMINAL;

	  private boolean isTransient = false;
    
    State() {}
    State(StateDuration trans) { isTransient = true; }
    void output() { print(amount); }
  }
  
  
  static void run(Generator<Input> gen, int machine) {
   
	  while(state[machine] != State.TERMINAL) {
 		machState[machine].get(state[machine]).next(gen.next(), machine);
        while(state[machine].isTransient)
    		machState[machine].get(state[machine]).next(machine);
        machState[machine].get(state[machine]).output();
      } 
}
  public static void main(String[] args) {
    Generator<Input> gen = new RandomInputGenerator();
    if(args.length == 1)
      gen = new FileInputGenerator(args[0]);
    run(gen,1);
} 
  

}






// For a basic sanity check:
class RandomInputGenerator implements Generator<Input> {
  public Input next() { return Input.randomSelection(); }
}
// Create Inputs from a file of ‘;’-separated strings:
class FileInputGenerator implements Generator<Input> {
  private Iterator<String> input;
  public FileInputGenerator(String fileName) {
    input = new TextFile(fileName, ";").iterator();
  }
  public Input next() {
    if(!input.hasNext())
      return null;
    return Enum.valueOf(Input.class, input.next().trim());
  }
}
