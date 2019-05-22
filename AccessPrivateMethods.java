package allTests;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

import resources.ClassWithPrivateMethod;

public class AccessPrivateMethods {
	
	int a=10;
	static int b=15;
			

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		//To get the private method from a different class
		ClassWithPrivateMethod obj = new ClassWithPrivateMethod();
		//get the class of the object
		Class<?> class1 = obj.getClass();
		//from the class get the declared method
		Method method = class1.getDeclaredMethod("privateMethod", null);
		method.setAccessible(true);
		method.invoke(obj, null);
		
		//To get the private field from a different class
		Field field = class1.getDeclaredField("var1");
		field.setAccessible(true);
		System.out.println(field.get(obj));	
		
	}

}
