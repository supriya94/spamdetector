package antispam;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {

    private Action actionTester;
    private User user1;
    private User user2;
    @Before
    public void setUp() throws Exception {
        user1 = new User("Jane");
        user2 = new User("John");
        actionTester = new Action("friend_request_sent", user1, user2);
    }

    @Test
    public void testGetId() throws Exception {
        assertEquals(1, actionTester.getId());
    }

    @Test
    public void testGetUserA() throws Exception {
        assertEquals(user1, actionTester.getUserA());
    }

    @Test
    public void testGetUserB() throws Exception {
        assertEquals(user2, actionTester.getUserB());
    }
}