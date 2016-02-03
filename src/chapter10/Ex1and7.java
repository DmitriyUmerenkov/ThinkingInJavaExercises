package chapter10;
import java.util.*; 

class Gerbil {
	static int count;
	int gerbilNumber;
	Gerbil(){ gerbilNumber=count++;}
	void hop() {System.out.println("Gerbil #"+gerbilNumber+" hopping.");}
}


public class Ex1and7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		ArrayList<Gerbil> Farm = new ArrayList<Gerbil>();
		for (int i=0;i<10;i++) Farm.add(new Gerbil());
		for (Gerbil g: Farm) g.hop();

		System.out.println(Farm);
		
		List SubFarm= Farm.subList(2, 5);
		Farm.removeAll(SubFarm);
		System.out.println(Farm);
*/
		
		Map<Integer, Gerbil> m = new HashMap<Integer, Gerbil>();
		for (int i=0;i<10;i++) {
			Gerbil g = new Gerbil();
			m.put(g.gerbilNumber, g);
				}
			
		Iterator<Integer> it = m.keySet().iterator(); 
		while (it.hasNext()) {
			Integer no= it.next();
		System.out.println(m.get(no));
		m.get(no).hop();
			
			
		}
		
	}

}
