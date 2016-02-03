package typeinfo;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

class DynamicProxyHandler implements InvocationHandler {
private Object proxied;

private Map<Method, Integer> MethodCount= new HashMap<Method, Integer>();


public DynamicProxyHandler(Object proxied) {
this.proxied = proxied;
}
public Object
invoke(Object proxy, Method method, Object[] args)
throws Throwable {

if (MethodCount.get(method)==null) MethodCount.put(method, 1); 	
else MethodCount.put(method, MethodCount.get(method)+1);	
	
System.out.println("**** proxy: " + proxy.getClass() +
", method: " + method + ", args: " + args + "\n Total method calls: "+ 
		MethodCount.get(method));
//System.out.println("Proxy: "+ proxy);
if(args != null)
for(Object arg : args)
System.out.println(" " + arg);
return method.invoke(proxied, args);
}
}
class SimpleDynamicProxy {
public static void consumer(Interface iface) {
iface.doSomething();
iface.somethingElse("bonobo");
}
public static void main(String[] args) {
RealObject real = new RealObject();
consumer(real);
// Insert a proxy and call again:
Interface proxy = (Interface)Proxy.newProxyInstance(
Interface.class.getClassLoader(),
new Class[]{ Interface.class },
new DynamicProxyHandler(real));
consumer(proxy);
consumer(proxy);
consumer(proxy);
}
}