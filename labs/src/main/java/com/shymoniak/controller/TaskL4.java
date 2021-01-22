package com.shymoniak.controller;

import com.shymoniak.model.lab4.CarObject;
import com.shymoniak.model.lab4.Expert;
import com.shymoniak.tools.Constants;
import com.shymoniak.tools.GSONFileReader;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class TaskL4 {

    public void run() {
        GSONFileReader<CarObject> gson = new GSONFileReader();
        List<CarObject> cars = gson.readFromFile(new File(Constants.LAB4_FILE_DIRECTORY), CarObject[].class);
        for (CarObject car : cars) {
            car.convertValues();
        }
        double maxPrice = cars.stream().map(el -> el.getPrice()).max(Double::compare).get();
        double maxMileage = cars.stream().map(el -> el.getMileage()).max(Double::compare).get();

        for (CarObject car : cars) {
            car.updateValues(maxPrice, maxMileage);
        }

        List<Expert> experts = fillExperts(cars);
        printTable(experts, cars);
        getAverageExpertPoints( experts);

    }

    private void printTable(List<Expert> experts, List<CarObject> cars) {
        for (Expert expert: experts) {
            printExpert(expert, cars);
        }
        System.out.println();
    }

    private void printExpert(Expert expert, List<CarObject> cars){
        System.out.println("\nExpert:" + expert.getName());
        List<String> optionsStrings = new ArrayList<>();
        optionsStrings.add("1       Вартість                ");
        optionsStrings.add("2       Рік випуску             ");
        optionsStrings.add("3       Пробіг                  ");
        optionsStrings.add("4       Розхід палива           ");
        optionsStrings.add("5       Особисте вподобання     ");
        optionsStrings.add("Сума                            1");
        List<String> optionsList2 = new ArrayList<>();
        optionsList2.add("price");
        optionsList2.add("year");
        optionsList2.add("mileage");
        optionsList2.add("fuelConsumption");
        optionsList2.add("personalPreferences");

        System.out.println("№       Параметр                Вага                А               Б               В                   Г                   Д                   Е");
        System.out.print("                                      ");
        for (int j = 0; j < cars.size(); j++) {
            System.out.print("          " + cars.get(j).getObjectName());
        }
        System.out.println();
        System.out.print(optionsStrings.get(0) + expert.getCoefficients().get(optionsList2.get(0)));
        for (int j = 0; j < cars.size(); j++) {
            System.out.print("             |" + cars.get(j).getPrice());
        }
        System.out.println();
        System.out.print(optionsStrings.get(1) + expert.getCoefficients().get(optionsList2.get(1)));
        for (int j = 0; j < cars.size(); j++) {
            System.out.print("              |" + cars.get(j).getYear());
        }
        System.out.println();
        System.out.print(optionsStrings.get(2) + expert.getCoefficients().get(optionsList2.get(2)));
        for (int j = 0; j < cars.size(); j++) {
            System.out.print("             |" + cars.get(j).getMileage());
        }
        System.out.println();
        System.out.print(optionsStrings.get(3) + expert.getCoefficients().get(optionsList2.get(3)));
        for (int j = 0; j < cars.size(); j++) {
            System.out.print("              |" + cars.get(j).getFuelConsumption());
        }
        System.out.println();
        System.out.print(optionsStrings.get(4) + expert.getCoefficients().get(optionsList2.get(4)));
        for (int j = 0; j < expert.getPreferences().size(); j++) {
            System.out.print("              |" + expert.getPreferences().get(cars.get(j).getObjectName()));
        }
        System.out.println();
        System.out.print(optionsStrings.get(5));
        for (int j = 0; j < expert.getPreferences().size(); j++) {
            System.out.print("              |" + expert.getCarSum().get(j));
        }
        System.out.println();
    }

    private ArrayList<Expert> fillExperts(List<CarObject> cars) {
        ArrayList<Expert> result = new ArrayList<>();
        Map<String, Double> preferencesEx1 = new HashMap<>();
        preferencesEx1.put("Audi A4", 6.0);
        preferencesEx1.put("BMW 3", 8.0);
        preferencesEx1.put("Volvo S60", 7.0);
        preferencesEx1.put("Honda Civic", 8.0);
        preferencesEx1.put("Ford Focus", 6.0);
        preferencesEx1.put("WV Passat B7", 7.0);
        Map<String, Double> coefficientsEx1 = new HashMap<>();
        coefficientsEx1.put("price", 0.25);
        coefficientsEx1.put("year", 0.3);
        coefficientsEx1.put("mileage", 0.15);
        coefficientsEx1.put("fuelConsumption", 0.2);
        coefficientsEx1.put("personalPreferences", 0.1);

        Map<String, Double> preferencesEx2 = new HashMap<>();
        preferencesEx2.put("Audi A4", 8.0);
        preferencesEx2.put("BMW 3", 9.0);
        preferencesEx2.put("Volvo S60", 6.0);
        preferencesEx2.put("Honda Civic", 7.0);
        preferencesEx2.put("Ford Focus", 4.0);
        preferencesEx2.put("WV Passat B7", 5.0);
        Map<String, Double> coefficientsEx2 = new HashMap<>();
        coefficientsEx2.put("price", 0.1);
        coefficientsEx2.put("year", 0.3);
        coefficientsEx2.put("mileage", 0.3);
        coefficientsEx2.put("fuelConsumption", 0.1);
        coefficientsEx2.put("personalPreferences", 0.2);

        Map<String, Double> preferencesEx3 = new HashMap<>();
        preferencesEx3.put("Audi A4", 8.0);
        preferencesEx3.put("BMW 3", 7.0);
        preferencesEx3.put("Volvo S60", 8.0);
        preferencesEx3.put("Honda Civic", 7.0);
        preferencesEx3.put("Ford Focus", 6.0);
        preferencesEx3.put("WV Passat B7", 7.0);
        Map<String, Double> coefficientsEx3 = new HashMap<>();
        coefficientsEx3.put("price", 0.25);
        coefficientsEx3.put("year", 0.15);
        coefficientsEx3.put("mileage", 0.25);
        coefficientsEx3.put("fuelConsumption", 0.3);
        coefficientsEx3.put("personalPreferences", 0.05);

        ArrayList<Double> sumDecisionsEx1 = calculateCarSumDecisions(preferencesEx1, coefficientsEx1, cars);
        ArrayList<Double> sumDecisionsEx2 = calculateCarSumDecisions(preferencesEx2, coefficientsEx3, cars);
        ArrayList<Double> sumDecisionsEx3 = calculateCarSumDecisions(preferencesEx2, coefficientsEx3, cars);
        Expert expert1 = new Expert("Expert 1 (баланс)", preferencesEx1, coefficientsEx1, sumDecisionsEx1);
        Expert expert2 = new Expert("Expert 2 (новизна)", preferencesEx2, coefficientsEx2, sumDecisionsEx2);
        Expert expert3 = new Expert("Expert 3 (практичність)", preferencesEx3, coefficientsEx3, sumDecisionsEx3);
        result.add(expert1);
        result.add(expert2);
        result.add(expert3);
        return result;
    }

    private ArrayList<Double> calculateCarSumDecisions(Map<String, Double> preferences, Map<String, Double> coefficients, List<CarObject> cars){
        ArrayList<Double> resultList = new ArrayList<>();
        List<String> paramsList = new ArrayList<>();
        paramsList.add("price");
        paramsList.add("year");
        paramsList.add("mileage");
        paramsList.add("fuelConsumption");
        paramsList.add("personalPreferences");
        List<String> carsNamesList = new ArrayList<>();
        carsNamesList.add("Audi A4");
        carsNamesList.add("BMW 3");
        carsNamesList.add("Volvo S60");
        carsNamesList.add("Honda Civic");
        carsNamesList.add("Ford Focus");
        carsNamesList.add("WV Passat B7");

        CarObject currentCar;
        double sum = 0;
        int counter = 0;
        for (int i = 0; i < preferences.size(); i++) {
            currentCar = cars.get(i);
            sum += currentCar.getPrice()*coefficients.get(paramsList.get(0));
            sum += currentCar.getYear()*coefficients.get(paramsList.get(1));
            sum += currentCar.getMileage()*coefficients.get(paramsList.get(2));
            sum += currentCar.getFuelConsumption()*coefficients.get(paramsList.get(3));
            sum += preferences.get(carsNamesList.get(counter))*coefficients.get(paramsList.get(4));
            sum = roundNumber(sum, 2);
            resultList.add(sum);
            counter++;
            sum = 0;
        }
        return resultList;
    }

    private static double roundNumber(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void getAverageExpertPoints(List<Expert> experts){
        List<String> carsNamesList = new ArrayList<>();
        carsNamesList.add("Audi A4");
        carsNamesList.add("BMW 3");
        carsNamesList.add("Volvo S60");
        carsNamesList.add("Honda Civic");
        carsNamesList.add("Ford Focus");
        carsNamesList.add("WV Passat B7");

        ArrayList<Double> averagePointsList = new ArrayList<>();
        for (int iVar = 0; iVar <carsNamesList.size() ; iVar++) {
            int finalIVar = iVar;
            averagePointsList.add(experts.stream().map(el -> el.getCarSum().get(finalIVar)).mapToDouble(el -> el).average().orElse(-1));
            System.out.println("Average value for " + carsNamesList.get(finalIVar) + " = " + averagePointsList.get(finalIVar));
        }
        Double maxValue = averagePointsList.stream().max(Double::compareTo).get();
        int indexOfBest = averagePointsList.indexOf(maxValue);
        System.out.println("\nSo the best options is " + carsNamesList.get(indexOfBest) + " = " + averagePointsList.get(indexOfBest));
        System.out.println("========================================\n");
    }
}