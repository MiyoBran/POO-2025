package tp4.barber;

import java.util.Date;

/**
 * Representación simple de un cliente para la versión 2.
 */
public class CustomerV2 {
    private final String name;
    private final Date inTime;

    public CustomerV2(String name) {
        this.name = name;
        this.inTime = new Date();
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    @Override
    public String toString() {
        return "CustomerV2{" + name + " at " + inTime + '}';
    }
}

