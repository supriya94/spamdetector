package antispam;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * An implementation of Spam Classifier with input from a file
 */
public class AppSpamClassifier implements SpamClassifier {

    private UserManager userManager;

    public void decodeAction(String command) {

        String[] components = command.split(" ");
        User userA = userManager.addUser(components[1]);
        User userB = userManager.addUser(components[2]);

        Action action = new Action(components[0], userA, userB);

        userManager.actionResult(action);
    }

    public void classifySpam(String source) {
        userManager = new UserManager();
        BufferedReader br;
        String command;

        try {
            br = new BufferedReader(new FileReader(source));

            command = br.readLine();

            while (command != null) {
                decodeAction(command);

                command = br.readLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        userManager.printUserClassification();
    }

}
