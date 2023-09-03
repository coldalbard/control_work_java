package service;

import model.Toy;

public interface DataService {
    void addToy(Toy toy);

    void changeToyWeight(int searchId, double weight);

    Toy lottery();
}
