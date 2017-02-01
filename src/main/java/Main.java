import java.io.File;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        AppSpamClassifier scInstance = new AppSpamClassifier();

        for(int i=0;i<args.length;i++) {
            System.out.println("\nInput file: " + (i+1));
            File f = new File(args[i]);
            scInstance.classifySpam(f.getAbsolutePath());
        }
    }
}
