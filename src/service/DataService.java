package service;

import model.Toy;

public interface DataService {
    void addToy(Toy toy);
    void changeToy(int searchId, Toy toy);
    Toy lottery();
}
