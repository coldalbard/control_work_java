package service;

import controller.Controller;

public class Connection {
    private final Controller controller = new Controller();

    public void programRun() {
        System.out.println("Welcome to the toy store!");
        int run = 0;
        while (run != 5) {
            run = controller.mainPage();
            System.out.println();
            switch (run) {
                case 1 -> controller.lottery();
                case 2 -> controller.showToys();
                case 3 -> controller.addToy();
                case 4 -> controller.changeToyWeight();
                case 5 -> System.out.println("All the best!");
            }
        }
    }
}
