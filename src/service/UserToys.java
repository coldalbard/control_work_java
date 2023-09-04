package service;

import model.FileType;
import model.Toy;
import model.TxtFormat;

import java.util.ArrayList;

/**
 * @apiNote Класс UserToys, для добавления выигрыша пользователя в файл(массив)
 * или чтения из файла, для формирования массива
 * txtUserToys - "БД с игрушками" которые пользователь уже ывиграл
 * userToys - список игрушек из "БД" пользователя
 */
public class UserToys {
    private final TxtFormat txtUserToys;
    private final ArrayList<Toy> userToys;

    public UserToys() {
        this.txtUserToys = new TxtFormat(FileType.TXT, "D:\\gb\\control_work_java\\control_wok_java\\src\\userToys.txt");
        this.userToys = this.txtUserToys.readFile();
    }

    /**
     * @param toy сама игрушка
     * @apiNote Метод для добавления игрушек пользователю
     */
    public void addToy(Toy toy) {
        boolean flag = false;
        for (Toy value : this.userToys) {
            if (toy.getId() == value.getId()) {
                flag = true;
                value.setNumbersToys(value.getNumbersToys() + 1);
                this.txtUserToys.writeFile(this.userToys);
                break;
            }
        }
        if (!flag) {
            toy.setNumbersToys(1);
            this.userToys.add(toy);
            this.txtUserToys.writeFile(this.userToys);
        }
    }

    /**
     * @apiNote Метод для вывода игрушек на экран пользователя
     */
    public void showToys() {
        for (Toy toy : this.userToys) {
            System.out.println(toy);
        }
    }
}
