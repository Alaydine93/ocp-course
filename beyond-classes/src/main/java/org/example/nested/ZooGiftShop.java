package org.example.nested;

public class ZooGiftShop {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        var sale = new SaleTodayOnly() {
            int dollarsOff(){return 1;}
        };
        return basePrice - sale.dollarsOff();
    }
}
