package org.example;

import static java.lang.Math.round;

public class CalculateStockQuantity {
    int qty1, qty2;

    void calculateStockQuantity(double price1, double price2, double balance){
        int qtyMax1 = (int) (balance / price1);
        int expQty1 = 0, expQty2 = 0;
        double addAmount = 10;
        double leftover;
        double balanceNew = balance + addAmount;
        double minLeftover = balanceNew;

        for (qty1 = 0; qty1 <= qtyMax1; qty1++) {
            qty2 = (int) ((balanceNew - qty1*price1) / price2);
            leftover = (balanceNew - qty1*price1 - qty2*price2);
            if (leftover < minLeftover) {
                minLeftover = leftover;
                expQty1 = qty1;
                expQty2 = qty2;

            }
        }
        System.out.println("Quantity for share 1 : " + expQty1);
        System.out.println("Quantity for share 2 : " + expQty2);
        System.out.println("Total balance used   : " + round((expQty1*price1 + expQty2*price2)*100.0)/100.0);
        System.out.println("Additional investment: " + round((addAmount - minLeftover)*100.0)/100.0);
    }
}

class Main {
    public static void main (String[] args) {
        double price1 = 1012.6;
        double price2 = 1022.82;
        double balance = 50000;

        CalculateStockQuantity buyPower = new CalculateStockQuantity();
        buyPower.calculateStockQuantity(price1, price2, balance);
    }
}