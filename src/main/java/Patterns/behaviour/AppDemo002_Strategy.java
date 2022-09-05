package Patterns.behaviour;

public class AppDemo002_Strategy {

    public static void main(String[] args) {

        //First version
        System.out.println("First Version");
        boolean fullStrategy = true;
        double price = 1000;
        double priceItem = (fullStrategy) ? new FullPrice().getPrice(price) : new DiscountHalfPrice().getPrice(price);
        System.out.println(priceItem);

        //Second version
        System.out.println("Second Version");
        StorePlace storePlace = new StorePlace(new DiscountHalfPrice());
        double priceDiscount = storePlace.getPrice(price);
        storePlace = new StorePlace(new FullPrice());
        double priceFull = storePlace.getPrice(price);
        System.out.println("priceDiscount = " + priceDiscount);
        System.out.println("priceFull = " + priceFull);
    }
}

interface StrategyPrice {
    double getPrice(double price);
}

class FullPrice implements StrategyPrice {

    @Override
    public double getPrice(double price) {
        return price;
    }
}

class DiscountHalfPrice implements StrategyPrice {

    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}

class StorePlace {
    StrategyPrice strategyPrice;

    public StorePlace(StrategyPrice strategyPrice){
        this.strategyPrice = strategyPrice;
    }

    public double getPrice(double price){
        return strategyPrice.getPrice(price);
    }
}