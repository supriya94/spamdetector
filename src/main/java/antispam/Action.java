package antispam;

/**
 * Class to hold details of each action
 */
public class Action {
    private final int id;
    private final User userA;
    private final User userB;

    Action(String action, User userA, User userB) {
        id = initializeId(action);
        this.userA = userA;
        this.userB = userB;
    }

    public int initializeId(String action) {
        if(action.contentEquals("friend_request_sent"))
            return 1;
        if(action.contentEquals("friend_request_accept"))
            return 2;
        if(action.contentEquals("friend_request_reject"))
            return 3;
        if(action.contentEquals("spam_report"))
            return 4;
        if(action.contentEquals("spam_report_ignore"))
            return 5;
        return 6;

    }

    public int getId() { return id; }

    public User getUserA() { return userA; }

    public User getUserB() { return userB; }
}
