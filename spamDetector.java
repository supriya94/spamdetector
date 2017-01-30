import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/* spam = -1 --> Not spammer
   spam = 0 --> Maybe spammer
   spam = 1 --> Spammer
 */
class User {
    String name;
    int spam, friends, requests;

    User(String name) {
        this.name = name;
        spam = -1;
        friends = 0;
        requests = 0;
    }

    void incSpam() {
        if(spam < 1)
            spam += 1;
    }

    void decSpam() {
        if(spam > -1)
            spam -= 1;
    }

    void addFriend() {
        friends++;
    }

    void incRequests() {
        requests++;
    }
}


public class spamDetector {
    static ArrayList<User> users;
    static HashMap<String,User> names;
    static BufferedReader br;

    spamDetector(){
        users = new ArrayList<User>();
        names = new HashMap<String,User>();
    }

    public static int getAction(String actionName) {
        if(actionName.contentEquals("friend_request_sent"))
            return 1;
        if(actionName.contentEquals("friend_request_accept"))
            return 2;
        if(actionName.contentEquals("friend_request_reject"))
            return 3;
        if(actionName.contentEquals("spam_report"))
            return 4;
        if(actionName.contentEquals("spam_report_ignore"))
            return 5;
        return 6;
    }

    public static User addUser(String name) {
        User temp = new User(name);
        users.add(temp);
        return temp;
    }

    public static void decodeAction(int action, String userA, String userB) {
        User a = names.get(userA), b = names.get(userB);
        if(action == 1)
            a.incRequests();
        else if(action == 2) {
            a.addFriend();
            b.addFriend();
        }
        else if(action == 3) {
            a.decSpam();      //Assuming spammer does not reject requests
            b.incSpam();
        }
        else if(action == 4) {
            if(a.spam != 1)   //Ignore spam report if userA is a spammer
                b.incSpam();
        }
        else if(action == 5) {
            b.incSpam();
            a.decSpam();
        }
        else
            a.incSpam();  //Assuming user accounts are suspended correctly
    }

    public static void readFile(String filename) {
        String command = "";
        try {
            br = new BufferedReader(new FileReader(filename));
            command = br.readLine();

            while (command != null) {
                String[] components = command.split(" ");
                int action = getAction(components[0]);
                String userA = components[1], userB = components[2];
                if(!names.containsKey(userA))
                    names.put(userA, addUser(userA));
                if(!names.containsKey(userB))
                    names.put(userB, addUser(userB));

                decodeAction(action, userA, userB);

                command = br.readLine();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        ArrayList<User> notSpam = new ArrayList<User>();
        System.out.println("\nSpam:");
        for(User u : users) {

            //Spammer might not have any friends
            if(u.friends == 0)
                u.incSpam();

            //Spammer sends too many friend requests
            if(u.requests > users.size()/2)
                u.incSpam();

            if(u.spam == 1)
                System.out.println(u.name);
            else
                notSpam.add(u);
        }
        System.out.println("\nHam:");
        for(User u : notSpam)
            System.out.println(u.name);
    }

    public static void  main(String[] args) {
        for(int i=0;i<args.length;i++) {
            spamDetector sdInstance = new spamDetector();
            System.out.println("\nInput file: " + (i+1));
            sdInstance.readFile(args[i]);
        }
    }
}

