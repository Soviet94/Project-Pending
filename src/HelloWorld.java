public class HelloWorld {
	
	public static BART_API bart = new BART_API();
	
    public static void main(String[] args) {
       System.out.println("Hello World!");
       System.out.println(bart.trainCount());
    }
}