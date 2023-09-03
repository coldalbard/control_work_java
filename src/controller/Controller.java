package controller;

import model.Toy;
import service.ToyStore;
import service.UserToys;
import view.View;

public class Controller {
    private final ToyStore toyStore;
    private final UserToys userToys;

    public Controller() {
        this.userToys = new UserToys();
        this.toyStore = new ToyStore();
    }

    public int mainPage(){
        return View.mainPage();
    }

    public void addToy() {
        this.toyStore.addToy(View.addToy());
        System.out.println("Toy added");
    }

    public void changeToyWeight() {
        Number[] idWeight = View.weightChange();
        int id = idWeight[0].intValue();
        double weight = idWeight[1].doubleValue();
        this.toyStore.changeToyWeight(id, weight);
        System.out.println("The weight of the toy has been changed");
    }

    public void lottery() {
        View.Drawing();
        Toy toy = this.toyStore.lottery();
        if (toy != null) {
            this.userToys.addToy(toy);
        }
    }

    public void showToys() {
        View.showToys();
        this.userToys.showToys();
    }
}
