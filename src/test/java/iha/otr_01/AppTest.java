package iha.otr_01;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

/**
 * Test class for this task
 *
 */

public class AppTest {
	App A = new App();
	TestIPAddress sct = null;
	App.IPAddress ip = null;
	TestIPAddress sctWork = new TestIPAddress();
	ArrayList<TestSetForIPAddressConstructors> ipSetList =
			 new ArrayList<TestSetForIPAddressConstructors>();
	
	
	public class TestIPAddress extends App {
		@SuppressWarnings("unused")
		public TestIPAddress(){
			IPAddress IP = new IPAddress();
			if (IP == null) throw new NullPointerException();
		}

		@SuppressWarnings("unused")
		public TestIPAddress(int a,int b,int c,int d){
			IPAddress IP = new IPAddress(a,b,c,d);
			if (IP == null) throw new NullPointerException();
		}

		@SuppressWarnings("unused")
		public TestIPAddress(String str){
			IPAddress IP = new IPAddress(str);
			if (IP == null) throw new NullPointerException();
		}
	
		public boolean TestIPAddressEquals(String a,String b){
			IPAddress ip1 = new IPAddress(a);
			IPAddress ip2 = new IPAddress(b);
			
			if (ip1.equals(ip2)) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean TestIPAddressHashCode(String a,String b){
			IPAddress ip1 = new IPAddress(a);
			IPAddress ip2 = new IPAddress(b);
			
			if (ip1.hashCode() == ip2.hashCode()) {
				return true;
			} else {
				return false;
			}
		}
	
		public boolean TestIPAddressToString(){
			IPAddress ip = new IPAddress(12,233,45,1);
			if ("12.233.45.1" == ip.toString()) {
				return true;
			} else {
				return false;
			}
		}
		/*
		public boolean TestIPAddressPrintIPToConsole(){
			IPAddress ip = new IPAddress(12,233,45,1);
			if ("12.233.45.1" == ip.printIPToConsole()) {
				return true;
			} else {
				return false;
			}
		}
		*/
	}
	
	public class TestSetForIPAddressConstructors {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		
		public TestSetForIPAddressConstructors(int a, int b, int c, int d){
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
		
		public String outString(){
			return "" + a + "." +  b + "." + c + "." +  d;
		}
		
	}
	
	@Before
	public void makeInizialitionData(){
		for (int a = -110;a < 300;a += 200)
			for (int b = -110;b < 300;b += 200)
				for (int c = -110;c < 300;c += 200)
					for (int d = -110;d < 300;d += 200)
						ipSetList.add(new TestSetForIPAddressConstructors(a,b,c,d));
	}
	
	@Test
    public void testCorrectCreation() {
		assertNotNull(A);
    }

	@Test
    public void testCorrectCreationSubClass() {
		sct = new TestIPAddress();
		assertNotNull(sct);
    }

	@Test
    public void testCorrectCreationSubClassWithIntegerParam() {
		int trueTest = 0;
		int falseTest = 0;
		
		for (TestSetForIPAddressConstructors item : ipSetList){
			try {
				sct = new TestIPAddress(item.a,item.b,item.c,item.d);
				if ((item.a == item.b) && 
				    (item.b == item.c) && 
				    (item.c == item.d)) {
					trueTest++;
				} else {
					falseTest++;
				}
			}
			catch(Exception e){
				falseTest++;
			}
		}
		
		if ((trueTest == 1) && (falseTest == 80)){
			assertTrue(true);
		} else {
			assertTrue(false);
		}
    }

	@Test
    public void testCorrectCreationSubClassWithStringParam() {
		int trueTest = 0;
		int falseTest = 0;
		
		for (TestSetForIPAddressConstructors item : ipSetList){
			try {
				sct = new TestIPAddress(item.outString());
				if ((item.a == item.b) && 
				    (item.b == item.c) && 
				    (item.c == item.d)) {
					trueTest++;
				} else {
					falseTest++;
				}
			}
			catch(Exception e){
				falseTest++;
			}
		}
		
		if ((trueTest == 1) && (falseTest == 80)){
			assertTrue(true);
		} else {
			assertTrue(false);
		}
    }

	@Test 
	public void testCorrectWorkingHashCode(){
		int trueTest =  0;
		int falseTest = 0;
		
		if (sctWork.TestIPAddressHashCode("2.34.1.175","2.34.1.175")) trueTest++;
	
		if (sctWork.TestIPAddressHashCode("12.134.1.175","12.134.1.175")) trueTest++;
	
		if (sctWork.TestIPAddressHashCode("1.255.78.255","1.255.78.255")) trueTest++;
	
		if (!sctWork.TestIPAddressHashCode("1.255.78.255","2.255.78.255")) falseTest++;

		if (!sctWork.TestIPAddressHashCode("1.0.78.255","2.55.78.255")) falseTest++;
		
		if (!sctWork.TestIPAddressHashCode("1.0.78.0","255.1.78.85")) falseTest++;
		
		if ((trueTest == 3) && (falseTest == 3)) {
			assertTrue(true);
		} else {
			assertFalse(true);
		}
	
	}
	
	@Test 
	public void testCorrectWorkingEquals(){
		int trueTest =  0;
		int falseTest = 0;
		
		if (sctWork.TestIPAddressEquals("2.34.1.175","2.34.1.175")) trueTest++;
	
		if (sctWork.TestIPAddressEquals("12.134.1.175","12.134.1.175")) trueTest++;
	
		if (sctWork.TestIPAddressEquals("1.255.78.255","1.255.78.255")) trueTest++;
	
		if (!sctWork.TestIPAddressEquals("1.255.78.255","2.255.78.255")) falseTest++;

		if (!sctWork.TestIPAddressEquals("1.0.78.255","2.55.78.255")) falseTest++;
		
		if (!sctWork.TestIPAddressEquals("1.0.78.0","255.1.78.85")) falseTest++;
		
		if ((trueTest == 3) && (falseTest == 3)) {
			assertTrue(true);
		} else {
			assertFalse(true);
		}
	
	}
	
	@Test
	public void testCorrectToString(){
		
	}
}	