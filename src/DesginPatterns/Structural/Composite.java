package DesginPatterns.Structural;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

public class Composite {
    public static void main(String[] args) {

        File file1 = new File("Resume.pdf");
        File file2 = new File("Photo.jpg");

        Folder documents = new Folder("Documents");
        documents.add(file1);

        Folder rootFolder = new Folder("Root");
        rootFolder.add(documents);
        rootFolder.add(file2);

        rootFolder.showDetails();
    }
}
