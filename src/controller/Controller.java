package controller;

import model.Toy;
import service.ToyStore;
import service.UserToys;
import view.View;

/**
 * @apiNote Класс Controller, предназначен для совмещения реализаций
 * service и view частей приложения
 * toyStore - магазин игрушек
 * userToys - игрушки пользователя
 */
public class Controller {
    private final ToyStore toyStore;
    private final UserToys userToys;

    public Controller() {
        this.userToys = new UserToys();
        this.toyStore = new ToyStore();
    }

    /**
     * @apiNote Метод для вывода меню в консоль
     * @return View.mainPage() выбор пользователя из меню
     */
    public int mainPage(){
        return View.mainPage();
    }

    /**
     * @apiNote Метод для добавления игрушку в "БД" и массив магазина
     */
    public void addToy() {
        this.toyStore.addToy(View.addToy());
        System.out.println("Toy added");
    }

    /**
     * @apiNote Метод, для изменения веса игрушки
     */
    public void changeToyWeight() {
        Number[] idWeight = View.weightChange();
        int id = idWeight[0].intValue();
        double weight = idWeight[1].doubleValue();
        this.toyStore.changeToyWeight(id, weight);
        System.out.println("The weight of the toy has been changed");
    }

    /**
     * @apiNote Метод, для розыгрыша игрушки и вручения ее пользователю
     */
    public void lottery() {
        View.Drawing();
        Toy toy = this.toyStore.lottery();
        if (toy != null) {
            this.userToys.addToy(toy);
        }
    }

    /**
     * @apiNote Метод, для вывода игрушек пользователя в консоль
     */
    public void showToys() {
        View.showToys();
        this.userToys.showToys();
    }
}
