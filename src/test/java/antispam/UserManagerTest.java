package antispam;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserManagerTest {

    private UserManager umTester;
    private Action testAction;
    private User user1;
    private User user2;

    @Before
    public void setUp() throws Exception {
        umTester = new UserManager();
        user1 = new User("Jane");
        user2 = new User("John");
    }

    @Test
    public void testAddUser() throws Exception {
        umTester.addUser(user1.getName());
        assertEquals(1, umTester.users.size());

        umTester.addUser(user2.getName());
        assertEquals(2, umTester.users.size());

        umTester.addUser(user1.getName());
        assertEquals(2, umTester.users.size());
    }

    @Test
    public void testActionResult() throws Exception {
        testAction = new Action("friend_request_sent", user1, user2);
        umTester.actionResult(testAction);
        assertEquals(1, user1.getRequests());
    }

}