package ru.prudei.hw2.box;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.prudei.hw2.model.fruit.Apple;
import ru.prudei.hw2.model.fruit.Orange;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    void compare() {
        Apple apple = new Apple(3);
        Apple apple2 = new Apple(2);

        Orange orange = new Orange(1);
        Orange orange2 = new Orange(4);

        Box <Apple> boxWithApples = new Box <>(apple, apple2);
        Box <Orange> boxWithOranges = new Box<>(orange, orange2);

        boolean actual = boxWithApples.compare(boxWithOranges);

        Assertions.assertTrue(actual);
    }

    @Test
    void addElement() {
        Apple apple = new Apple(1);
        Box <Apple> boxWithApples = new Box <>(apple);
        Apple apple2 = new Apple(2);
        boxWithApples.addElement(apple2);
        int actual = boxWithApples.getByIndex(1).getWeight();
        int expected = 2;
        boolean comparison = (actual == expected);
        Assertions.assertTrue(comparison);
    }


    @Test
    void moveTo() {
        Apple apple = new Apple(2);
        Apple apple2 = new Apple(3);

        Box<Apple> boxWithApples = new Box<>(apple);
        Box<Apple> boxWithApples2 = new Box<>(apple2);

        boxWithApples.moveTo(boxWithApples2);

        int actual = boxWithApples2.sum();
        int expected = 5;
        boolean comparison = (actual == expected);

        Assertions.assertTrue(comparison);

    }
}