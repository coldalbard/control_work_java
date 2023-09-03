package model;

import java.text.ParseException;
import java.util.ArrayList;

public abstract class Format {
    private final FileType formatName;

    public Format(FileType formatName) {
        this.formatName = formatName;
    }

    public abstract ArrayList<Toy> readFile() throws ParseException;

    public abstract void writeFile(ArrayList<Toy> toys);

    public FileType getFormatName() {
        return formatName;
    }
}
