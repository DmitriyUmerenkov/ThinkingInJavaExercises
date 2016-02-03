package typeinfo;

import static util.Print.*;
interface Interface {
void doSomething();
void somethingElse(String arg);
}
class RealObject implements Interface {
public void doSomething() { print("doSomething"); }
public void somethingElse(String arg) {
print("somethingElse " + arg);
}
}
class SimpleProxy implements Interface {
private Interface proxied;
private int SomethingCounter=0;
private int SomethingElseCounter=0;
public SimpleProxy(Interface proxied) {
this.proxied = proxied;
}
public void doSomething() {
print("SimpleProxy doSomething, count " + SomethingCounter++);
proxied.doSomething();
}
public void somethingElse(String arg) {
print("SimpleProxy somethingElse " + arg+ " count "+ SomethingElseCounter++);
proxied.somethingElse(arg);
}
}
class SimpleProxyDemo {
public static void consumer(Interface iface) {
iface.doSomething();
iface.somethingElse("bonobo");
}
public static void main(String[] args) {
consumer(new RealObject());
SimpleProxy Proxy=new SimpleProxy(new RealObject());
consumer(Proxy);
consumer(Proxy);
consumer(Proxy);
}
}
