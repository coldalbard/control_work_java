package model;

import service.ToyStore;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        ArrayList<Toy> toys = new ArrayList<>(Arrays.asList(new Toy(1, "name", 8, 8.0), new Toy(2, "name", 2, 2.0)));
        TxtFormat txt = new TxtFormat(FileType.TXT);
        txt.writeFile(toys);
        ArrayList<Toy> arr = txt.readFile();
        System.out.println(arr);
        ToyStore ts = new ToyStore();
        ts.lottery();
    }
}
