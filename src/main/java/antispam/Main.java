package antispam;

import java.io.File;

/**
 * Main class to run spam classifier
 */
public class Main {

    public static void main(String[] args) {
        AppSpamClassifier scInstance = new AppSpamClassifier();

        for(int i=0;i<args.length;i++) {
            System.out.println("\nInput file: " + args[i]);
            File f = new File(args[i]);
            scInstance.classifySpam(f.getAbsolutePath());
        }
    }
}
