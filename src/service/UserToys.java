package service;

import model.FileType;
import model.Toy;
import model.TxtFormat;

import java.util.ArrayList;

public class UserToys {
    private final TxtFormat txtUserToys;
    private final ArrayList<Toy> userToys;

    public UserToys() {
        this.txtUserToys = new TxtFormat(FileType.TXT, "D:\\gb\\control_work_java\\control_wok_java\\src\\userToys.txt");
        this.userToys = this.txtUserToys.readFile();
    }

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

    public void showToys() {
        for (Toy toy : this.userToys) {
            System.out.println(toy);
        }
    }
}
