package model;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @apiNote Класс TxtFormat дочерний класс Format, нужен для записи
 * в файл в формате txt, и чтения из файла
 * formatName - формат файла
 * filePath - путь к файлу
 */
public class TxtFormat extends Format {
    private String filePath;

    public TxtFormat(FileType formatName, String filePath) {
        super(formatName);
        this.filePath = filePath;
    }

    public TxtFormat(FileType formatName) {
        super(formatName);
        this.filePath = "D:\\gb\\control_work_java\\control_wok_java\\src\\dataBase.txt";
    }

    /**
     * @apiNote Метод для чтения из файла
     * @return ArrayList<Toy> res Массив из Игрушек
     */
    @Override
    public ArrayList<Toy> readFile() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Toy> res = new ArrayList<>();
        try (FileReader reader = new FileReader(this.filePath)) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                if (c != ' ') sb.append(Character.toString(c));
            }
        } catch (Exception ex) {
            return res;
        }
        for (String str : sb.toString().split("\n")) {
            String[] toy = str.split(",");
            try {
                NumberFormat format = NumberFormat.getInstance(Locale.US);
                Number number = format.parse(toy[3]);
                res.add(new Toy(Integer.parseInt(toy[0]), toy[1], Integer.parseInt(toy[2]), number.doubleValue()));
            } catch (Exception e) {
                return res;
            }
        }
        return res;
    }

    /**
     * @apiNote Метод для записи игрушек в файл
     * @param toys входной массив игрушек для записи
     */
    @Override
    public void writeFile(ArrayList<Toy> toys) {
        File newFile = new File(this.filePath);
        try {
            if (!newFile.exists()) newFile.createNewFile();
            PrintWriter out = new PrintWriter(newFile);
            for (Toy toy : toys) {
                out.append(toy.toString());
                out.append("\n");
            }
            out.close();
        } catch (Exception e) {
            System.out.println("Неверно указан исходный или конечный файл(");
        }
    }
}
