package model;

public class Toy {
    private int id;
    private String name;
    private int numbersToys;
    private double weight;

    public Toy(int id, String name, int numbersToys, double weight) {
        this.id = id;
        this.name = name;
        this.numbersToys = numbersToys;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %.2f, %d", this.id, this.name, this.weight, this.numbersToys);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumbersToys() {
        return numbersToys;
    }

    public void setNumbersToys(int numbersToys) {
        this.numbersToys = numbersToys;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
