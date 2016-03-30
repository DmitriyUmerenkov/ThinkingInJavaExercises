package generics;

import java.util.*;

class Building {}
class House extends Building {}


public class ClassTypeCapture<T> {
  Class<T> kind;
  
  Map<String, Class<?>> mapkind = new HashMap<String, Class<?>>();
  
  void addType(String typename, Class<?> kind) {
	  mapkind.put(typename, kind);
  }
  
  Object createNew(String typename) {
	  if (mapkind.get(typename)==null) return "Error, no such class";
	  else  try {return mapkind.get(typename).newInstance();} 
	  catch (Exception e) {return "Some other error";} 
	  
	  
  }
  
  
  
  public ClassTypeCapture(Class<T> kind) {
    this.kind = kind;
  }

public boolean f(Object arg) {
return kind.isInstance(arg);
}



public static void main(String[] args) {
ClassTypeCapture<Building> ctt1 =
  new ClassTypeCapture<Building>(Building.class);
System.out.println(ctt1.f(new Building()));
System.out.println(ctt1.f(new House()));
ClassTypeCapture<House> ctt2 =
  new ClassTypeCapture<House>(House.class);
System.out.println(ctt2.f(new Building()));
System.out.println(ctt2.f(new House()));

ctt1.addType("House", new House().getClass());

System.out.println(ctt1.createNew("House"));
System.out.println(ctt1.createNew("Building"));


}



} 
