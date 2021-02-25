class Incrementer extends Thread{
	final int I;
	final Counter c;

	public Incrementer(int i,Counter c){
		this.I = i;
		this.c = c; 
	}

	public void run(){
		for (int i = 0; i < I ;i++ ) {
			this.c.i++;
		}
		
	}
}

class Counter{
	public int i;

	public Counter(){
		this.i = 0;
	}

	public void increment(){
		this.i++;
	}

	public void imprime(){
		System.out.println(this.i);
	}
}

class Main{
	public static void main(String[] args) throws InterruptedException{
		final int N = Integer.parseInt(args[0]);
		final int I = Integer.parseInt(args[1]);
		Counter c = new Counter();
		Thread ar[] = new Thread[N];
		for (int i = 0; i < N ; i++ ) {
			ar[i] = new Incrementer(I,c);
			ar[i].start();
		}
		
		for (int i = 0; i < N ; i++ ) {
			ar[i].join();
		}

		c.imprime();

	}
}