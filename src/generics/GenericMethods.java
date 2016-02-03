package generics;

public class GenericMethods {
public <T, K> void f(T x, K y, Object z) {
System.out.println(x.getClass().getName()+" "+y.getClass().getName()+" "+z.getClass().getName());
}
public static void main(String[] args) {
GenericMethods gm = new GenericMethods();
gm.f("",1,2);
gm.f(1,gm," ");
gm.f(1.0, 1.0, 1.0);
gm.f(1.0F, 11, "fgf");
gm.f('c', 'c', 'c');
gm.f(gm, gm, gm);
}
}