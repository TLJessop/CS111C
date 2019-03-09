package VideoCodeAlong;

public class RecursiveFileItemTest {

    public static void main(String[] args) {

        FileItem file1 = new FileItem("a", 1);
        FileItem file2 = new FileItem("b", 2);
        FileItem file3 = new FileItem("c", 3);
        FileItem file4 = new FileItem("d", 4);
        FileItem file5 = new FileItem("e", 5);
        FileItem file6 = new FileItem("f", 6);
        FileItem file8 = new FileItem("g", 7);
        FileItem file9 = new FileItem("h", 8);
        FileItem file7 = new FileItem("i", 9);
        FileItem file10 = new FileItem("j", 10);
        FileItem file11 = new FileItem("k", 11);

        Folder folder1 = new Folder("folder1");
        Folder folder2 = new Folder("folder2");
        Folder folder3 = new Folder("folder3");
        Folder folder4 = new Folder("folder4");
        Folder folder5 = new Folder("folder5");
        Folder folder6 = new Folder("folder6");

        folder1.addFolder(folder2);
        folder1.addFolder(folder3);
        folder3.addFolder(folder4);
        folder3.addFolder(folder5);
        folder5.addFolder(folder6);

        folder1.addFile(file1);
        folder1.addFile(file2);
        folder2.addFile(file3);
        folder3.addFile(file4);
        folder3.addFile(file5);
        folder4.addFile(file6);
        folder5.addFile(file7);
        folder2.addFile(file8);
        folder3.addFile(file9);
        folder6.addFile(file10);
        folder5.addFile(file11);

        printFolderContents(folder1);


   }//main


    public static void printFolderContents(Folder topFolder){
        helpPrintContents(topFolder,0);
    }

    private static void helpPrintContents(Folder topFolder, int indent){
        for (int i = 0; i < indent ; i++) {
            System.out.print("  ");
        }

        System.out.print("Files in " + topFolder.getName() +"\t");
        System.out.println(topFolder.getFiles());

        for (Folder folder: topFolder.getFolders()
             ) {
            helpPrintContents(folder, indent +1);
        }
    }

}//RecursiveFileItemTest
