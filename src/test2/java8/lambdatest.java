package test2.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.sun.org.apache.xpath.internal.functions.Function;

public class lambdatest{
	public static void main(String[] args) {
		String[] atp = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro" };
		List<String> players = Arrays.asList(atp);

		// 以前的循环方式
		for (String player : players) {
			System.out.print(player + "; ");
		}

		// 使用 lambda 表达式以及函数操作(functional operation)
		players.forEach((player) -> System.out.print(player + "; "));

		// 在 Java 8 中使用双冒号操作符(double colon operator)
		players.forEach(System.out::println);
		
		players.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	// 使用匿名内部类  
//	btn.setOnAction(new EventHandler<ActionEvent>() {  
//	          @Override  
//	          public void handle(ActionEvent event) {  
//	              System.out.println("Hello World!");   
//	          }  
//	    });  
//	   
	// 或者使用 lambda expression  
	//btn.setOnAction(event -> System.out.println("Hello World!"));
	public void lambdaRunable() {
		// 1.1使用匿名内部类  
		new Thread(new Runnable() {  
		    @Override  
		    public void run() {  
		        System.out.println("Hello world !");  
		    }  
		}).start();  
		  
		// 1.2使用 lambda expression  
		new Thread(() -> System.out.println("Hello world !")).start();  
		  
		// 2.1使用匿名内部类  
		Runnable race1 = new Runnable() {  
		    @Override  
		    public void run() {  
		        System.out.println("Hello world !");  
		    }  
		};  
		  
		// 2.2使用 lambda expression  
		Runnable race2 = () -> System.out.println("Hello world !");  
	}
	
}
