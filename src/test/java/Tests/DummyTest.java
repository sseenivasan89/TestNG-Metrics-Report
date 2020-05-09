package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DummyTest {
  @Test
  public void testOnDummy() {
	  System.out.println("Dummy");	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");	  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");	
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");	
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");	
  }

}
