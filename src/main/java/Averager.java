package org.example.problemeinterviu;

import java.awt.geom.QuadCurve2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1. Given a List of Maps, write a method to average each of the properties independently.
//Exclude null values from the average in the parameter data.
//
//Example data:
// [ { "temperature": 44, "humidity": 12 },
// { "temperature": 23, "humidity": 34 },
// { "temperature": 34 },
// { "temperature": null }]
// The return value should be a single Map containing the averages, e.g.
//
//{"temperature": 21.0,“humidity”: 33}
//[1,2,3,4]
// [ Product, new Product]
// [ {t:1, h:2} ]
public class Averager {


    public static void main(String[] args) {
        List<Map<String, Integer>> weatherInfoList = List.of(
                Map.of("temperature", 44, "humidity", 12),
                Map.of("temperature", 23, "humidity", 34),
                Map.of("temperature", 34),
                Map.of("temperature", null)
        );
        System.out.println(weatherInfoList);
        Map<String, Double> result = getAverage(weatherInfoList);
        System.out.println(result);
    }

    //parcugem lista de elemente de tip map
    //parcurgem apoi fiecare map
    // si pentru fiecare cheie luam valoare
    //si calculam o media valorilor
    //salvam rezultatul  mediilor intr un hash map

    public static Map<String, Double> getAverage(List<Map<String, Integer>> weatherInfoList) {
        // {temperatura: averageT, humidity: averageH}
        // sum = s/n (suma/nr de elemente)
        // suma pt fiecare cheie
        // contor pt fiecare cheie
        // 2,,5,6 => 2+5/2 = 7/2= 3.5
        //3.5+6 = 9.5/2 = 4.25
        //2,5,6 = 2+5+6/3 =4.33

        //Pasul 1 : suma tututoro valorilor cheilor
        Map<String,Double> sum = new HashMap<>();
        Map<String,Integer> counter = new HashMap<>();
        Map<String,Double> average = new HashMap<>();
        for (int i = 0; i < weatherInfoList.size() ; i++) {
            //weatherInfoList[i] - Map<String, Integer>
            // map-ul 1: { "temperature": 44, "humidity": 12 },
            //map-ul 2: { "temperature": 23, "humidity": 34 },
            for (Map.Entry<String, Integer> entry: weatherInfoList.get(i).entrySet()) {
                // map-ul curent: { "temperature": 44, "humidity": 12 },
                // entry 1: temperature: 44
                //entry 2: humidity: 33
                // gata pral -doulea for / se incrementeaza in primul for la al doilea map si apoi foru-ul 2 o ia de la capat
                //cheia si valoarea curenta din try-ul curent (entry) - entry set din map-ul curent weatherInfoList.get(i) - Map
                String key = entry.getKey(); // temperature
                Double value = Double.valueOf(entry.getValue()); // 44
                if (value != null) {
                    //daca da adunam valoarea sa suma existenta din sum
                    //daca nu punem cheia vu valoarea initiala a sumei in rezultatul nostru de sume (sum)
                    if (!sum.containsKey(key)) {
                        sum.put(key, value);// prima iteratie: {temperature: 44}
                        counter.put(key, 1);
                    }
                    //exista cheia in rezultatul de sume (sum)
                    else {
                        //valoarea din sum pt key
                        Double val = sum.get(key);
                        // valoarea din map-ul curent:  value
                        Double valueSum= value + val;
                        sum.put(key, valueSum); // a 3 iteratie: {temperature: 44 +34}
                        counter.put(key, counter.get(key) + 1);
                    }
                }
            }

        }
        for (String key: sum.keySet() ) {
            Double actSum = sum.get(key);
            Integer actCounter = counter.get(key);
            Double averageActual = actSum/ actCounter;
            average.put(key, averageActual);
        }
        return average;
    }
}
