import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Search {
    public static List<File> getFilesFromADirectory(File path, File nameOrExtension){
        List<File> returns = new ArrayList<>();
        if (path.isDirectory()){
            File[] tempFiles = path.listFiles();
            if (tempFiles != null){
                for (File f : tempFiles) {
                    if (f.isDirectory()) getFilesFromADirectory(f, nameOrExtension);
                    else {
                        if (f.getName().toLowerCase().contains(nameOrExtension.getName().toLowerCase())){
                            returns.add(f);
                            System.out.println(f.getAbsolutePath());
                        }
                    }
                }
            }
        }
        return returns;
    }
}
