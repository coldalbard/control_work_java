package model;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @apiNote абстрактный класс Format, предназначен для наследования
 * поведения записи и чтения, для разных форматов
 * formatName - формат файла
 */
public abstract class Format {
    private final FileType formatName;

    public Format(FileType formatName) {
        this.formatName = formatName;
    }

    public abstract ArrayList<Toy> readFile();

    public abstract void writeFile(ArrayList<Toy> toys);

    public FileType getFormatName() {
        return formatName;
    }
}
