package test.Exception;

public class myException {
	public static void main(String[] args) throws Exception {
		try {
			
			try {
				throw new Sneeze();
				
			} catch (Annoyance a) {
				System.out.println("Caught Annoyance");
				throw a;
			}
			
			
		}catch(Sneeze e) {
			System.out.println("Caught  Sneeze");
		}
		finally {
			System.out.println("Hello World!");
		}
	}
}

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}