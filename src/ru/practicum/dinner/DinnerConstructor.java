package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType; // поле класса - хэш-таблица: ключ - тип блюда, значение - список
    // блюд данного типа

    DinnerConstructor() {
        dishesByType = new HashMap<>();
    }

    Random random = new Random();

    boolean checkType(String dishType) { // есть ли тип блюд dishType в меню
        return dishesByType.containsKey(dishType);
    }

    void addDishByType(String dishType, String dish) { // добавление в меню блюда dish типа dishType
        if (checkType(dishType)) { // если такой тип уже есть в меню
            ArrayList<String> dishesOfThisType = dishesByType.get(dishType); // получаем из меню список типа dishType
            dishesOfThisType.add(dish); // добавляем блюдо
        } else {
            ArrayList<String> dishesOfThisType = new ArrayList<>(); // создаём список
            dishesOfThisType.add(dish); // добавляем блюдо
            dishesByType.put(dishType, dishesOfThisType); // добавляем тип-ключ и список-значение в хэш-таблицу
        }

    }

    void comboGeneration(int numberOfCombos, ArrayList<String> dishTypes) { // на входе: кол-во комбинаций и список типов
        ArrayList<ArrayList<String>> dinnerCombos = new ArrayList<>(numberOfCombos); // комбинации блюд будем хранить
        // в виде списка списков
        for (int i = 0; i < numberOfCombos; i++) { // инициация списка списков
            dinnerCombos.add(new ArrayList<>());
        }
        for (String dishType : dishTypes) { // перебираем все заданные типы
                ArrayList<String> dishesOfThisType = dishesByType.get(dishType); // получаем из меню список типа dishType
                for (int i = 0; i < numberOfCombos; i++) { // перебираем все нужные комбо
                    String dish = dishesOfThisType.get(random.nextInt(dishesOfThisType.size())); // случайное блюдо
                    // из списка типа dishType
                    ArrayList<String> combo = dinnerCombos.get(i); // получаем i-е комбо
                    combo.add(dish); // добавляем в него полученное случайное блюдо
                }
        }
        for (int i = 0; i < numberOfCombos; i++) { // вывод на экран полученных комбо
            ArrayList<String> combo = dinnerCombos.get(i); // получаем i-е комбо
            System.out.println("Вариант обеда " + (i + 1) + ":");
            System.out.println(String.join(", ", combo));
        }
    }
}