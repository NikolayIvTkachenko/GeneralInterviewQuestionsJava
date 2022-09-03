package StreamsLambda;

import java.util.stream.Stream;

public class Ticket implements Comparable {

    private String ticketClass;
    private int prices;

    public Ticket(String ticketClass, int prices) {
        this.ticketClass = ticketClass;
        this.prices = prices;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public int getPrices() {
        return prices;
    }

    @Override
    public int compareTo(Object obj) {
        if(this.prices > ((Ticket)obj).getPrices()){
            return 1;
        } else if (this.prices < ((Ticket)obj).getPrices()) {
            return -1;
        } else {
            return 0;
        }

    }
}
