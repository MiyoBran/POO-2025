package tp4.barber;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

// cambiar para que use ArrayBlockingQueue en lugar de LinkedList
public class Customer implements Runnable
{
    private String name;
    private Date inTime;

    private Bshop shop;

    public Customer(Bshop shop)
    {
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
    public void run()
    {
      try {
        goForHairCut();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    private synchronized void goForHairCut() throws InterruptedException {
        shop.add(this);
    }
}
