import java.io.BufferedReader;
import java.io.FileReader;

public class AppSpamClassifier implements SpamClassifier {



    public void readActions(BufferedReader br, UserManager userManager) {
        String command;
        try {
            command = br.readLine();

            while (command != null) {
                String[] components = command.split(" ");
                User userA = userManager.addUser(components[1]);
                User userB = userManager.addUser(components[2]);

                Action action = new Action(components[0], userA, userB);

                userManager.actionResult(action);

                command = br.readLine();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void classifySpam(String filename) {
        UserManager userManager = new UserManager();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filename));
        }
        catch(Exception e) {
            e.printStackTrace();
            br = null;
        }
        readActions(br, userManager);

        userManager.printUserClassification();
    }

}
