package Patterns.structural;

public class AppDemo002_Adapter {

    public static void main(String[] args) {

        AmericanSocket americanSocket = new SimpleAmericanSocket();
        TVSet tvSet = new TVSet();
        EuroSocket euroSocket = new SocketAdapter(americanSocket);
        tvSet.watchTV(euroSocket);

    }

}

interface EuroSocket {
    void getPower();
}

interface AmericanSocket {
    void getPower();
}

class SocketAdapter implements EuroSocket {

    AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket){
        this.americanSocket = americanSocket;
    }

    @Override
    public void getPower() {
        americanSocket.getPower();
    }
}

class SimpleAmericanSocket implements AmericanSocket {
    @Override
    public void getPower() {
        System.out.println(" get 110 volt");
    }
}

class TVSet {
    public void watchTV(EuroSocket euroSocket){
        euroSocket.getPower();
    }
}
