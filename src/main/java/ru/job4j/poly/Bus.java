package ru.job4j.poly;

public class Bus implements Transport {

    private double priceForLit = 46.25;

    public double getPriceForLit() {
        return priceForLit;
    }

    public void setPriceForLit(double priceForLit) {
        this.priceForLit = priceForLit;
    }

    @Override
    public void drive() {
        System.out.println("Driving");
    }

    @Override
    public void passengers(int num) {
        System.out.println(num);
    }

    @Override
    public double refuel(double liters) {
        return liters * priceForLit;
    }
}
