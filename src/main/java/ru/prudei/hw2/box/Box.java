package ru.prudei.hw2.box;

import ru.prudei.hw2.model.fruit.Fruit;

import java.util.Arrays;

public class Box<T extends Fruit> {

    private T [] content;

    public Box(T... content) {
        this.content = content;
    }

    public T[] getContent() {
        return content;
    }

    public T getByIndex (Integer i) {
        return content[i];
    }

    public int sum () {
        int base = 0;
        if (content == null) {
            return base;
        } else {

            for (T t : content) {
                base += t.getWeight();
            }
            return base;
        }
    }

    public void addElement(Object object) {
        content = Arrays.copyOf(content, content.length + 1);
        content[content.length - 1] = (T) object;
    }

    public boolean compare (Box<?> other) {
        return other.sum() == sum();
    }

    public void moveTo (Box<T> other){
        for (int i = 0; content.length > i; i++) {
            other.content=Arrays.copyOf(other.content, other.content.length + 1);
            other.content[other.content.length - 1] = content[i];
        }
        content = null;
    }
}
