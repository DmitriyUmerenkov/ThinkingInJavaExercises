package enumerated;

import java.util.*;

import enumerated.Mail.GeneralDelivery;
import util.*;
import static util.Print.*;


class Mail {
  // The NO’s lower the probability of random selection:
  enum GeneralDelivery {YES,NO1,NO2,NO3,NO4,NO5}
  enum Scannability {UNSCANNABLE,YES1,YES2,YES3,YES4}
  enum Readability {ILLEGIBLE,YES1,YES2,YES3,YES4}
  enum Address {INCORRECT,OK1,OK2,OK3,OK4,OK5,OK6, IN_FORWARDING_LIST}
  enum ReturnAddress {MISSING,OK1,OK2,OK3,OK4,OK5}
  GeneralDelivery generalDelivery;
  Scannability scannability;
  Readability readability;
  Address address;
  ReturnAddress returnAddress;
  static long counter = 0;
  long id = counter++;
  public String toString() { return "Mail " + id; }
  public String details() {
    return toString() +
      ", General Delivery: " + generalDelivery +
      ", Address Scanability: " + scannability +
      ", Address Readability: " + readability +
      ", Address Address: " + address +
      ", Return address: " + returnAddress;
  }
  // Generate test Mail:
  public static Mail randomMail() {
    Mail m = new Mail();
    m.generalDelivery= Enums.random(GeneralDelivery.class);
    m.scannability = Enums.random(Scannability.class);
    m.readability = Enums.random(Readability.class);
    m.address = Enums.random(Address.class);
    m.returnAddress = Enums.random(ReturnAddress.class);
    return m;
  }
  public static Iterable<Mail> generator(final int count) {
    return new Iterable<Mail>() {
      int n = count;
      public Iterator<Mail> iterator() {
        return new Iterator<Mail>() {
          public boolean hasNext() { return n-- > 0; }
          public Mail next() { return randomMail(); }
          public void remove() { // Not implemented
            throw new UnsupportedOperationException();
          }
}; }
}; }
}
public class PostOffice {
  enum MailHandler {
    GENERAL_DELIVERY {
      boolean handle(Mail m) {
        switch(m.generalDelivery) {
          case YES:
        	  switch(m.address) {
        	  case IN_FORWARDING_LIST: return false;
        	  default:print("Using general delivery for " + m);
              return true;
        	  }

          default: return false;
}
        
}
    },
    MACHINE_SCAN {
      boolean handle(Mail m) {
        switch(m.scannability) {
          case UNSCANNABLE: return false;
          default:
            switch(m.address) {
              case INCORRECT: return false;
              case IN_FORWARDING_LIST: print("Forwarding "+ m + " automatically"); return true;
              default:
                print("Delivering "+ m + " automatically");
                return true;
            }
} }
    },
    VISUAL_INSPECTION {
      boolean handle(Mail m) {
        switch(m.readability) {
          case ILLEGIBLE: return false;
          default:
            switch(m.address) {
              case INCORRECT: return false;
              case IN_FORWARDING_LIST: print("Forwarding "+ m + " normally"); return true;
              default:
                print("Delivering " + m + " normally");
                return true;
            }
} }
    },
    RETURN_TO_SENDER {
      boolean handle(Mail m) {
        switch(m.returnAddress) {
          case MISSING: return false;
          default:
            print("Returning " + m + " to sender");
            return true;
        }
} };
    abstract boolean handle(Mail m);
  }
  static void handle(Mail m) {
    for(MailHandler handler : MailHandler.values())
      if(handler.handle(m))
        return;
    print(m + " is a dead letter");
  }

  
 interface Handler {
	 
	 boolean handle(Mail m);
 } 
  
  
  

  
  
  
  
  
  
  
  
  
  public static void main(String[] args) {
    for(Mail mail : Mail.generator(5)) {
      print(mail.details());
      handle(mail);
      print("*****");
} 
   print("*****And now with enummap!*****");
   
  
   
   
   
   
   
   
    EnumMap<MailHandler, Handler> gd = new EnumMap<MailHandler, Handler>(MailHandler.class);
   
    gd.put(MailHandler.GENERAL_DELIVERY , new Handler() {
    	public boolean handle(Mail m) {
	        switch(m.generalDelivery) {
	          case YES:
	        	  switch(m.address) {
	        	  case IN_FORWARDING_LIST: return false;
	        	  default:print("Using general delivery for " + m);
	              return true;
	        	  }

	          default: return false;
	}
	        
	}
	    });
	    
	    
    gd.put(MailHandler.MACHINE_SCAN, new Handler() {
	   public   boolean handle(Mail m) {
	        switch(m.scannability) {
	          case UNSCANNABLE: return false;
	          default:
	            switch(m.address) {
	              case INCORRECT: return false;
	              case IN_FORWARDING_LIST: print("Forwarding "+ m + " automatically"); return true;
	              default:
	                print("Delivering "+ m + " automatically");
	                return true;
	            }
	} }
	    });
    
    gd.put(MailHandler.VISUAL_INSPECTION, new Handler() {
	      public boolean handle(Mail m) {
	        switch(m.readability) {
	          case ILLEGIBLE: return false;
	          default:
	            switch(m.address) {
	              case INCORRECT: return false;
	              case IN_FORWARDING_LIST: print("Forwarding "+ m + " normally"); return true;
	              default:
	                print("Delivering " + m + " normally");
	                return true;
	            }
	} }
	    });
    
    gd.put(MailHandler.RETURN_TO_SENDER, new Handler() {
	      public boolean handle(Mail m) {
	        switch(m.returnAddress) {
	          case MISSING: return false;
	          default:
	            print("Returning " + m + " to sender");
	            return true;
	        }
	} });    
    

    letter:
   for(Mail mail : Mail.generator(35)) {	   
	   print("*****");

	   print(mail.details());
	   for (Handler h: gd.values())
		   if (h.handle(mail)) continue letter; 
    	print ("Dead Letter");
        
    	
  } 
   
  
  
  }
}