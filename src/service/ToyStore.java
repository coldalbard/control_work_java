package service;

import model.FileType;
import model.Toy;
import model.TxtFormat;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;

public class ToyStore implements DataService{
    private TxtFormat txtDataBase;
    private TxtFormat txtUserToys;
    private ArrayList<Toy> toys;
    private ArrayList<Toy> userToys;

    public ToyStore() {
        this.txtDataBase = new TxtFormat(FileType.TXT);
        this.txtUserToys = new TxtFormat(FileType.TXT, "D:\\gb\\control_work_java\\control_wok_java\\src\\userToys.txt");
        this.userToys = this.txtUserToys.readFile();
        this.toys = this.txtDataBase.readFile();
    }

    @Override
    public void addToy(Toy toy) {
        toys.add(toy);
        this.txtDataBase.writeFile(toys);
    }

    @Override
    public void changeToyWeight(int searchId, double weight) {
        for (Toy value: this.toys) {
            if (value.getId() == searchId){
                value.setWeight(weight);
                this.txtDataBase.writeFile(this.toys);
                break;
            }
        }
    }

    @Override
    public void lottery() {
        if (this.toys.isEmpty()){
            System.out.println("В магазине закончились игрушки(");
        } else {
            double sumWeight = 0;
            for (Toy toy : this.toys) {
                sumWeight += toy.getWeight();
            }
            Random random = new Random();
            Double randomWeight = random.nextDouble() * sumWeight;
            DecimalFormat df = new DecimalFormat("#.##");
            randomWeight = Double.valueOf(df.format(randomWeight).replace(',', '.'));
            System.out.println(randomWeight);
            Toy userToy = null;
            double currentWeight = 0;
            for (Toy toy : this.toys) {
                currentWeight += toy.getWeight();
                if (randomWeight <= currentWeight){
                    userToy = toy;
                    System.out.println(currentWeight);
                    break;
                }
            }
            if (userToy != null){
                System.out.println("Поздравляем вы выиграли игрушку: " + userToy.getName());
                this.userToys.add(userToy);
                this.txtUserToys.writeFile(this.userToys);
                this.userToys = this.txtUserToys.readFile();
                this.toys.remove(userToy);
                this.txtDataBase.writeFile(this.toys);
            } else System.out.println("К сожалению вы ничего не выиграли(");
        }
    }
}
