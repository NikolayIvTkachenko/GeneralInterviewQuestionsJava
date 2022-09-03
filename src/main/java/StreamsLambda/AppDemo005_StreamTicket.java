package StreamsLambda;

import java.util.ArrayList;

public class AppDemo005_StreamTicket {

    public static void main(String[] args) {

        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("A", 150));
        tickets.add(new Ticket("B", 90));

        Ticket minimumTicketPrice = tickets.stream().min(Ticket::compareTo).get();
        System.out.printf("Minimum price of ticket class %s: $%d%n", minimumTicketPrice.getTicketClass(), minimumTicketPrice.getPrices());

        Ticket maximumTicketPrice = tickets.stream().max(Ticket::compareTo).get();
        System.out.printf("Maximum price of ticket class %s: $%d%n", maximumTicketPrice.getTicketClass(), maximumTicketPrice.getPrices());






    }


}
