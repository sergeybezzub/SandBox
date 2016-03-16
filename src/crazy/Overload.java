package crazy;

class A {
	int a;
}

class B extends A{
	int b;
}
class C extends B{
	int c;
}

public class Overload{
	  public void method(Object o) {
	    System.out.println("o");
	  }
	  public void method(B b) {
	    System.out.println("b");
	  }
	  public void method(A a) {
		    System.out.println("a");
		  }
	  
	  public void method(C a) {
		    System.out.println("c");
		  }

	  public static void main(String args[]) {
	    Overload test = new Overload();
	    test.method(null);
	  }
	}