package typeinfo;

import typeinfo.factory.*;
import java.util.*;
import util.TypeCounter;
import util.Null;

class Part {
	
public static class NullPart extends Part implements Null {
	private NullPart() {};
	public String toString() {return "NullPart";}
	}
public static final Part NULL = new NullPart();


	
public String toString() {
return getClass().getSimpleName();
}
static List<Class<? extends Part>> ClassList = 
new ArrayList<Class<? extends Part>>(Arrays.asList(
		FuelFilter.class,AirFilter.class,CabinAirFilter.class, OilFilter.class,
		FanBelt.class, PowerSteeringBelt.class, GeneratorBelt.class));

//Collections.addAll(ClassList, FuelFilter.class);


static List<Factory<? extends Part>> partFactories =
new ArrayList<Factory<? extends Part>>();

static {
// Collections.addAll() gives an "unchecked generic
// array creation ... for varargs parameter" warning.
partFactories.add(new FuelFilter.Factory());
partFactories.add(new AirFilter.Factory());
partFactories.add(new CabinAirFilter.Factory());
partFactories.add(new OilFilter.Factory());
partFactories.add(new FanBelt.Factory());
partFactories.add(new PowerSteeringBelt.Factory());
partFactories.add(new GeneratorBelt.Factory());

}

private static Random rand = new Random(47);
public static Part createRandom() {
	
/*	
int n = rand.nextInt(partFactories.size());
return partFactories.get(n).create();
*/
	int n = rand.nextInt(ClassList.size());
	try {
		return ClassList.get(n).newInstance();
	}
	catch(Exception e) { return null;} 

	

}
}
class Filter extends Part {}
class FuelFilter extends Filter {
// Create a Class Factory for each specific type:
public static class Factory
implements typeinfo.factory.Factory<FuelFilter> {
public FuelFilter create() { return new FuelFilter(); }
}
}
class AirFilter extends Filter {
public static class Factory
implements typeinfo.factory.Factory<AirFilter> {
public AirFilter create() { return new AirFilter(); }
}
}
class CabinAirFilter extends Filter {
public static class Factory
implements typeinfo.factory.Factory<CabinAirFilter> {
public CabinAirFilter create() {
return new CabinAirFilter();
}

}
}
class OilFilter extends Filter {
public static class Factory
implements typeinfo.factory.Factory<OilFilter> {
public OilFilter create() { return new OilFilter(); }
}
}
class Belt extends Part {}
class FanBelt extends Belt {
public static class Factory
implements typeinfo.factory.Factory<FanBelt> {
public FanBelt create() { return new FanBelt(); }
}
}
class GeneratorBelt extends Belt {
public static class Factory
implements typeinfo.factory.Factory<GeneratorBelt> {
public GeneratorBelt create() {
return new GeneratorBelt();
}
}
}
class PowerSteeringBelt extends Belt {
public static class Factory
implements typeinfo.factory.Factory<PowerSteeringBelt> {
public PowerSteeringBelt create() {
return new PowerSteeringBelt();
}
}
}
public class RegisteredFactories {
public static void main(String[] args) {

TypeCounter counter = new TypeCounter(Part.class);	
Part CurrentPart;

for(int i = 0; i < 10; i++)
{
	CurrentPart=Part.createRandom();
	System.out.println(CurrentPart);
	counter.count(CurrentPart);
}

counter.count(Part.NULL);

System.out.println(counter);
}


}