package service;

import model.Toy;

/**
 * @apiNote Интерфейс DataService, если классы имплементируют интерфейс,
 * то обязуются реализовать методы интерфейса(если класс не абстрактный)
 */
public interface DataService {
    void addToy(Toy toy);

    void changeToyWeight(int searchId, double weight);

    Toy lottery();
}
