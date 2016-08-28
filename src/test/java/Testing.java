package com.cloudbees.aws.demo;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
public class Testing extends TestCase {

@Test 
public void Test()
  {
    System.out.println("testing done");
     Assert.assertEquals(5, 5);
  }

}
