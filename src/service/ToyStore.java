package service;

import model.FileType;
import model.Toy;
import model.TxtFormat;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;

public class ToyStore implements DataService {
    private TxtFormat txtDataBase;
    private ArrayList<Toy> toys;

    public ToyStore() {
        this.txtDataBase = new TxtFormat(FileType.TXT);
        this.toys = this.txtDataBase.readFile();
    }

    @Override
    public void addToy(Toy toy) {
        this.toys.add(toy);
        this.txtDataBase.writeFile(toys);
    }

    @Override
    public void changeToyWeight(int searchId, double weight) {
        for (Toy value : this.toys) {
            if (value.getId() == searchId) {
                value.setWeight(weight);
                this.txtDataBase.writeFile(this.toys);
                break;
            }
        }
    }

    @Override
    public Toy lottery() {
        if (this.toys.isEmpty()) {
            System.out.println("The store ran out of toys(");
            return null;
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
                if (randomWeight <= currentWeight) {
                    userToy = toy;
                    System.out.println(currentWeight);
                    break;
                }
            }
            if (userToy != null) {
                System.out.println("Congratulations you have won a toy: " + userToy.getName());
                userToy.setNumbersToys(userToy.getNumbersToys() - 1);
                if (userToy.getNumbersToys() <= 0) this.toys.remove(userToy);
                this.txtDataBase.writeFile(this.toys);
            } else {
                System.out.println("Unfortunately you didn't win anything (");
            }
            return userToy;
        }
    }
}
