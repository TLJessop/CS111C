package VideoCodeAlong;

import java.util.Objects;

public class FileItem {

    private String name;
    private  int size;

    public FileItem(String name, int size){
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return name ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileItem fileItem = (FileItem) o;
        return size == fileItem.size &&
                name.equals(fileItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}//FileItem
