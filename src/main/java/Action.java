/**
 * Created by supriya on 1/30/17.
 */
public class Action {
    private int id;
    private User userA;
    private User userB;

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

/*class RequestSent extends Action{
    RequestSent(User userA, User userB) { super(userA, userB); }

}

class RequestAccept extends Action {
    RequestAccept(User userA, User userB) { super(userA, userB); }
}

class RequestReject extends Action {
    RequestReject(User userA, User userB) { super(userA, userB); }
}

class SpamReportSent extends Action {
    SpamReportSent(User userA, User userB) { super(userA, userB); }
}

class SpamReportIgnore extends Action {
    SpamReportIgnore(User userA, User userB) { super(userA, userB); }
}

class SpamReportSuspend extends Action {
    SpamReportSuspend(User userA, User userB) { super(userA, userB); }
}   */