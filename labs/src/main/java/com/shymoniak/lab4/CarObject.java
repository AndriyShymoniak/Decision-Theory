package com.shymoniak.lab4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarObject {
    private String objectName;
    private double price;
    private double year;
    private double mileage;
    private double fuelConsumption;

    public void convertValues() {
        this.price = (15000 - price) / 1000;
        this.year = (year - 2010);
        this.mileage = (220000 - mileage) / 1000;
        this.fuelConsumption = (15 - fuelConsumption);
    }

    public void updateValues(double maxPrice, double maxMileage) {
        price = 10 * price / maxPrice;
        mileage = 10 * mileage / maxMileage;
        price = roundNumber(price, 2);
        mileage = roundNumber(mileage, 2);
    }

    private static double roundNumber(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
