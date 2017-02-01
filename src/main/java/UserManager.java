import java.util.ArrayList;
import java.util.HashMap;

public class UserManager {

    private ArrayList<User> users = new ArrayList<User>();
    private HashMap<String,User> names = new HashMap<String, User>();

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
        if(id == 1)
            a.incRequests();
        else if(id == 2) {
            a.addFriend();
            b.addFriend();
        }
        else if(id == 3) {
            a.decSpam();      //Assuming spammer does not reject requests
            b.incSpam();
        }
        else if(id == 4) {
            if(a.getSpam() != 1)   //Ignore spam report if userA is a spammer
                b.incSpam();
        }
        else if(id == 5) {
            b.incSpam();
            a.decSpam();
        }
        else
            a.incSpam();  //Assuming user accounts are suspended correctly
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
