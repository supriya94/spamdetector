public class User {
    private final String name;
    private int spam;
    private int friends;
    private int requests;

    User(String name) {
        this.name = name;
        spam = -1;
        friends = 0;
        requests = 0;
    }

    public String getName() {
        return name;
    }

    public int getRequests() {
        return requests;
    }

    public int getSpam() {
        return spam;
    }

    public int getFriends() {
        return friends;
    }

    public void addFriend() {
        friends++;
    }

    public void incRequests() {
        requests++;
    }

    public void incSpam() {
        if(getSpam() < 1)
            spam += 1;
    }

    public void decSpam() {
        if(spam > -1)
            spam -= 1;
    }
}
