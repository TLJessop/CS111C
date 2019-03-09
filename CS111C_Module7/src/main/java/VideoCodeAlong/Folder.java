package VideoCodeAlong;

import java.util.ArrayList;
import java.util.List;

public class Folder {

    private List<FileItem> files;
    private List<Folder> folders;
    private String name;

    public Folder(String name){
        this.name = name;

        files = new ArrayList<>();
        folders = new ArrayList<>();
    }

    public List<FileItem> getFiles() {
        return files;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "name='" + name + '\'' +
                '}';
    }

    public void addFile(FileItem file){
        files.add(file);
    }

    public void addFolder(Folder folder){
        folders.add(folder);
    }

    public int getSizeOfFiles(){
        int size =0;

        for (FileItem file: files) {
            size += file.getSize(); System.out.println(size);
        }
        return size;
    }

    public boolean containsFile(FileItem searchFile){
        for (FileItem file: files) {
            if (file.equals(searchFile)) return true;
        }
        return false;
    }
}//Folder
