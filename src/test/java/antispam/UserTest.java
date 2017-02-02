package antispam;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User userTester;

    @Before
    public void setUp() throws Exception {
        userTester = new User("Jane Doe");
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Jane Doe", userTester.getName());
    }

    @Test
    public void testGetRequests() throws Exception {
        assertEquals(0, userTester.getRequests());
    }

    @Test
    public void testGetSpam() throws Exception {
        assertEquals(-1, userTester.getSpam());
    }

    @Test
    public void testGetFriends() throws Exception {
        assertEquals(0, userTester.getFriends());
    }

    @Test
    public void testAddFriend() throws Exception {
        userTester.addFriend();
        assertEquals(1, userTester.getFriends());
    }

    @Test
    public void testIncRequests() throws Exception {
        userTester.incRequests();
        assertEquals(1, userTester.getRequests());
    }

    @Test
    public void testIncSpam() throws Exception {
        userTester.incSpam();
        assertEquals(0, userTester.getSpam());
    }

    @Test
    public void testDecSpam() throws Exception {
        userTester.decSpam();
        assertEquals(-1, userTester.getSpam());
    }

    @Test
    public void testSetSpam() throws Exception {
        userTester.setSpam(0);
        assertEquals(0, userTester.getSpam());
    }
}