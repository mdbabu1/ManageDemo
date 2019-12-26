package system;



import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;


public class AllTests {
	public Property property = null;
    
	/**
	     * This is a before method which will run before every method to initialize 
	     * the HardwareStore class
	     * 
	     */
	    @Before
	    public void createMethodEnvironment(){
	        property = new Property();
	    }

	    /**
	     * this is a after method which will run after every method has been tested 
	     * and will make the HardwareStore object null
	     */
	    @After
	    public void clearMethodEnvironment(){
	        property = null;
	    }

	    /**
	     * Test of getAddress method, of class Property.
	     */
	    @Test
	    public void testGetAddress() {
	        property = new Property("5656 University Circle", "Jan 02nd, 1995");
	        String expResult = "5656 University Circle";
	        String result = property.getAddress();
	        assertEquals(expResult, result);
	    }

	    /**
	     * Test of getDate method, of class Property.
	     */
	    @Test
	    public void testGetDate() {
	        property = new Property("5656 University Circle", "Jan 02nd, 1995");
	        String expResult = "Jan 02nd, 1995";
	        String result = property.getDate();
	        assertEquals(expResult, result);
//	        System.out.println("getDate");
//	        Property instance = new Property();
//	        Date expResult = null;
//	        Date result = instance.getDate();
//	        assertEquals(expResult, result);
//	        // TODO review the generated test code and remove the default call to fail.
//	        fail("The test case is a prototype.");
	    }
	    
	    public Message message = null;
	    
	    /**
	         * This is a before method which will run before every method to initialize 
	         * the HardwareStore class
	         * 
	         */
	        @Before
	        public void createMethodEnvironment1(){
	            message = new Message();
	        }

	        /**
	         * this is a after method which will run after every method has been tested 
	         * and will make the HardwareStore object null
	         */
	        @After
	        public void clearMethodEnvironment1(){
	            message = null;
	        }

	        /**
	         * Test of getMessage method, of class Message.
	         */
	        @Test
	        public void testGetMessage() {
	            message = new Message("I got ur message", "1");
	            String expResult = "I got ur message";
	            String result = message.getMessage();
	            assertEquals(expResult, result);
	        }

	        

	        /**
	         * Test of getReciever method, of class Message.
	         */
	        @Test
	        public void testGetReciever() {
	            message = new Message("I got ur message", "A04785461");
	            String expResult = "A04785461";
	            String result = message.getReciever();
	            assertEquals(expResult, result);
//	            System.out.println("getReciever");
//	            Message instance = new Message();
//	            String expResult = "";
//	            String result = instance.getReciever();
//	            assertEquals(expResult, result);
//	            // TODO review the generated test code and remove the default call to fail.
//	            fail("The test case is a prototype.");
	        }
	        
	        public MaintRequest maint;
	        
	        /**
	             * This is a before method which will run before every method to initialize 
	             * each class
	             * 
	             */
	            @Before
	            public void createMethodEnvironment11(){
	                maint = new MaintRequest();
	            }

	            /**
	             * this is a after method which will run after every method has been tested 
	             * and will make the HardwareStore object null
	             */
	            @After
	            public void clearMethodEnvironment11(){
	                maint = null;
	            }

	            /**
	             * Test of getIssue method, of class MaintRequest.
	             */
	            @Test
	            public void testGetIssue() {
	                maint.setIssue("Please fix my flush problem");
	                String expResult = "Please fix my flush problem";
	                String result = maint.getIssue();
	                assertEquals(expResult, result);
//	                System.out.println("getIssue");
//	                MaintRequest instance = new MaintRequest();
//	                String expResult = "";
//	                String result = instance.getIssue();
//	                assertEquals(expResult, result);
//	                // TODO review the generated test code and remove the default call to fail.
//	                fail("The test case is a prototype.");
	            }

	            /**
	             * Test of getStatus method, of class MaintRequest.
	             */
	            @Test
	            public void testGetStatus() {
	                maint.setStatus(false);
	                boolean expResult = false;
	                boolean result = maint.getStatus();
	                assertEquals(expResult, result);
//	                System.out.println("getStatus");
//	                MaintRequest instance = new MaintRequest();
//	                boolean expResult = false;
//	                boolean result = instance.getStatus();
//	                assertEquals(expResult, result);
//	                // TODO review the generated test code and remove the default call to fail.
//	                fail("The test case is a prototype.");
	            }
	            
	            public Lease lease = null;
	            
	            /**
	                 * This is a before method which will run before every method to initialize 
	                 * the HardwareStore class
	                 * 
	                 */
	                @Before
	                public void createMethodEnvironment111(){
	                    lease = new Lease();
	                }

	                /**
	                 * this is a after method which will run after every method has been tested 
	                 * and will make the HardwareStore object null
	                 */
	                @After
	                public void clearMethodEnvironment111(){
	                    lease = null;
	                }
	                
	                /**
	                 * Test of getLeaseStart method, of class Lease.
	                 */
	                @Test
	                public void testGetLeaseStart() {
	                    lease = new Lease();
	                    lease.setLeaseStart("May 02nd, 2019");
	                    String expResult = "May 02nd, 2019";
	                    String result = lease.getLeaseStart();
	                    assertEquals(expResult, result);
	                    
//	                    System.out.println("getLeaseStart");
//	                    Lease instance = new Lease();
//	                    Date expResult = null;
//	                    Date result = instance.getLeaseStart();
//	                    assertEquals(expResult, result);
//	                    // TODO review the generated test code and remove the default call to fail.
//	                    fail("The test case is a prototype.");
	                }

	                /**
	                 * Test of getLeaseEnd method, of class Lease.
	                 */
	                @Test
	                public void testGetLeaseEnd() {
	                    lease = new Lease();
	                    lease.setLeaseEnd("May 01st, 2020");
	                    String expResult = "May 01st, 2020";
	                    String result = lease.getLeaseEnd();
	                    assertEquals(expResult, result);
	                    
//	                    System.out.println("getLeaseEnd");
//	                    Lease instance = new Lease();
//	                    Date expResult = null;
//	                    Date result = instance.getLeaseEnd();
//	                    assertEquals(expResult, result);
//	                    // TODO review the generated test code and remove the default call to fail.
//	                    fail("The test case is a prototype.");
	                }

	                /**
	                 * Test of getRentPrice method, of class Lease.
	                 */
	                @Test
	                public void testGetRentPrice() {
	                    lease = new Lease();
	                    lease.setRentPrice(2400);
	                    Double expResult = 2400.00;
	                    Double result = lease.getRentPrice();
	                    assertEquals(expResult, result);
	                }
	                
	                public Client client = null;
	                
	                /**
	                     * This is a before method which will run before every method to initialize 
	                     * the HardwareStore class
	                     * 
	                     */
	                    @Before
	                    public void createMethodEnvironment1111(){
	                        client = new Client();
	                    }

	                    /**
	                     * this is a after method which will run after every method has been tested 
	                     * and will make the HardwareStore object null
	                     */
	                    @After
	                    public void clearMethodEnvironment1111(){
	                        client = null;
	                    }

	                    /**
	                     * Test of getClientId method, of class Client.
	                     */
	                    @Test
	                    public void testGetClientId() {
	                        client = new Client(1, "Owais", "222Chavez", "Austin", "Texas", "78233", "5127729119", "o@txstate.edu", "owner");
	                        int expResult = 1;
	                        int result = client.getClientId();
	                        assertEquals(expResult, result);
	                        // TODO review the generated test code and remove the default call to fail.
	                    }

	                    /**
	                     * Test of getName method, of class Client.
	                     */
	                    @Test
	                    public void testGetName() {
	                        client = new Client(1, "Owais", "222Chavez", "Austin", "Texas", "78233", "5127729119", "o@txstate.edu", "owner");
	                        String expResult = "Owais";
	                        String result = client.getName();
	                        assertEquals(expResult, result);
	                    }

	                    /**
	                     * Test of getAddress method, of class Client.
	                     */
	                    @Test
	                    public void testGetAddress1() {
	                        client = new Client(1, "Owais", "222 Chavez", "Austin", "Texas", "78233", "5127729119", "o@txstate.edu", "owner");
	                        String expResult = "222 Chavez";
	                        String result = client.getAddress();
	                        assertEquals(expResult, result);
	                    }

	                    /**
	                     * Test of getCity method, of class Client.
	                     */
	                    @Test
	                    public void testGetCity() {
	                        client = new Client(1, "Owais", "222 Chavez", "Austin", "Texas", "78233", "5127729119", "o@txstate.edu", "owner");
	                        String expResult = "Austin";
	                        String result = client.getCity();
	                    }

	                    /**
	                     * Test of getState method, of class Client.
	                     */
	                    @Test
	                    public void testGetState() {
	                        client = new Client(1, "Owais", "222 Chavez", "Austin", "Texas", "78233", "5127729119", "o@txstate.edu", "owner");
	                        String expResult = "Texas";
	                        String result = client.getState();
	                        assertEquals(expResult, result);
	                        

	                    }

	                    /**
	                     * Test of getZip method, of class Client.
	                     */
	                    @Test
	                    public void testGetZip() {
	                        client = new Client(1, "Owais", "222 Chavez", "Austin", "Texas", "78233", "5127729119", "o@txstate.edu", "owner");
	                        String expResult = "78233";
	                        String result = client.getZip();
	                        assertEquals(expResult, result);
	                    }

	                    /**
	                     * Test of getPhone method, of class Client.
	                     */
	                    @Test
	                    public void testGetPhone() {
	                        client = new Client(1, "Owais", "222 Chavez", "Austin", "Texas", "78233", "5127729119", "o@txstate.edu", "owner");
	                        String expResult = "5127729119";
	                        String result = client.getPhone();
	                        assertEquals(expResult, result);
	                    }

	                    /**
	                     * Test of getEmail method, of class Client.
	                     */
	                    @Test
	                    public void testGetEmail() {
	                        client = new Client(1, "Owais", "222 Chavez", "Austin", "Texas", "78233", "5127729119", "o_l41@txstate.edu", "owner");
	                        String expResult = "o_l41@txstate.edu";
	                        String result = client.getEmail();
	                        assertEquals(expResult, result);
	                    }

	                    /**
	                     * Test of getUserType method, of class Client.
	                     */
	                    @Test
	                    public void testGetUserType() {
	                        client = new Client(1, "Owais", "222 Chavez", "Austin", "Texas", "78233", "5127729119", "o_l41@txstate.edu", "owner");
	                        String expResult = "owner";
	                        String result = client.getUserType();
	                        assertEquals(expResult, result);
	                    }

	
}
