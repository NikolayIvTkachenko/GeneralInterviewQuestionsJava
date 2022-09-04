package Patterns.structural;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppDemo004_Composite {

    public static void main(String[] args) {

        //Composite
        //Мы распределяем внутри класса другие классы, какбы переносим част логики в другие классы, а эти классы становятся
        //полями данного класса.

    }
}

class File {
    String fileName;
}

class Folder {
    String name;
    Date creationDate;
    List<Folder> folders = new ArrayList<>();
    List<File> files = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    void addFolder(Folder folder) {
        folders.add(folder);
    }

    void removeFolder(Folder folder){
        folders.remove(folder);
    }

    List<Folder> getFolders() {
        return folders;
    }

    void addFile(File file) {
        files.add(file);
    }

    void removeFile(File file){
        files.remove(file);
    }

    List<File> getFilies(){
        return files;
    }

}
