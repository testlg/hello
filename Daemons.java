import java.util.concurrent.*;
import java.lang.*;
//import static net.mindview.util.Print.*;

class Daemon implements Runnable
{
	private Thread[]t=new Thread[10];
	public void run()
	{
		for(int i = 0;i<t.length;i++)
		{
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.print("DaemonSpawn"+i+" started. ");
		}
		for(int i=0;i<t.length;i++)
			System.out.print("t["+i+"].isDaemon()="+t[i].isDaemon()+",");
		while(true)
			Thread.yield();

	}
}
class DaemonSpawn implements Runnable
{
	//final int a=1;
	public void run(){
		while(true){
			try
			{
				//System.out.println();
				Thread.sleep(10000);

			}
			catch (InterruptedException e)
			{
				System.out.print("-------");
			}
		}
	}
}

class Daemons 
{
	public static void main(String[] args) 
	{
		Thread d=new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.print("d.isDaemon()="+d.isDaemon()+",");
			try
			{
				Thread.sleep(100000);
			}
			catch (InterruptedException e)
			{
				System.out.print("-------");
			}
	
	}
}
