package tp4.barber;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

// cambiar para que use ArrayBlockingQueue en lugar de LinkedList
public class Bshop{
	private int nchair;
	private ArrayBlockingQueue<Customer> blockingQueueCostumers;

	public Bshop() {
		nchair = 3;
		blockingQueueCostumers = new ArrayBlockingQueue<Customer>(nchair);
	}

	public void cutHair() throws InterruptedException {
		Customer customer = null;
		System.out.println("Barber waiting for customer.");
		try {
			// take() bloquea hasta que haya un cliente
			customer = blockingQueueCostumers.take();
		} catch (InterruptedException iex) {
			Thread.currentThread().interrupt();
			iex.printStackTrace();
			return;
		}

		long duration = 0;
		try {
			System.out.println("Cuting hair of Customer : " + customer.getName());
			duration = (long) (Math.random() * 10);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException iex) {
			Thread.currentThread().interrupt();
			iex.printStackTrace();
		}
		System.out
				.println("Completed Cuting hair of Customer : " + customer.getName() + " in " + duration + " seconds.");
	}

	public void add (Customer customer) throws InterruptedException{
		System.out.println("Customer : " + customer.getName() + " entering the shop at " + customer.getInTime());
    /*
    if(blockingQueueCostumers.size() == nchair){
      System.out.println("No chair available for customer " + customer.getName());
      System.out.println("Customer " + customer.getName() + " Exits...");
      return;
    }
    blockingQueueCostumers.put(customer);
    */



		// intentar agregar sin bloquear; si ya está lleno, el cliente se va
		//boolean added =
   if(blockingQueueCostumers.size() < nchair) {
     blockingQueueCostumers.put(customer);
     System.out.println("Customer : " + customer.getName() + " got the chair.");
   } else {
      System.out.println("No chair available for customer " + customer.getName());
      System.out.println("Customer " + customer.getName() + " Exits...");
   }

		/*if (!added) {
			System.out.println("No chair available for customer " + customer.getName());
			System.out.println("Customer " + customer.getName() + "Exits...");
			return;
		}*/

	}
}
