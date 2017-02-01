package antispam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages users and user attributes based on actions
 */
public class UserManager {

    private final ArrayList<User> users = new ArrayList<User>();
    private final HashMap<String,User> names = new HashMap<String, User>();

    public User addUser(String name) {
        if(names.containsKey(name))
            return names.get(name);
        User user = new User(name);
        users.add(user);
        names.put(name, user);
        return user;
    }

    public void actionResult(Action action) {
        int id = action.getId();
        User a = action.getUserA();
        User b = action.getUserB();
        switch(id) {
            case 1: a.incRequests();

            case 2: a.addFriend();
                    b.addFriend();

            case 3: a.decSpam();           //Assuming spammer does not reject requests
                    b.incSpam();

            case 4: if(a.getSpam() != 1)   //Ignore spam report if userA is a spammer
                        b.incSpam();

            case 5: b.incSpam();
                    a.decSpam();

            case 6: a.incSpam();          //Assuming user accounts are suspended correctly
        }

    }
    public void printUserClassification() {
        ArrayList<User> notSpam = new ArrayList<User>();
        System.out.println("\nSpam:");
        for(User user : users) {
            if(user.getSpam() == 1)
                System.out.println(user.getName());
            else
                notSpam.add(user);
        }
        System.out.println("\nHam:");
        for(User nonSpamUser : notSpam)
            System.out.println(nonSpamUser.getName());
    }


}
