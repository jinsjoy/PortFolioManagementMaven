package com.fundWeightCalculator.FundWeightCalculatorProject;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.fundWeightCalculator.FundWeightCalculatorProject.calculator.PortfolioFundWeightCalculator;



@RunWith(JUnit4.class)
public class PortfolioFundManagerTest {

   
    
    public static PortfolioFundWeightCalculator g = new PortfolioFundWeightCalculator();

    @BeforeClass
    public static void makeGraphs() {
    	
    	g.addEdge("A", "B",1000);
    	g.addEdge("A", "C",2000);
    	g.addEdge("B", "D",500);
    	g.addEdge("B", "E",250);
    	g.addEdge("B", "F",250);
    	g.addEdge("C", "G",1000);
    	g.addEdge("C", "H",1000);      
    }
   
    List<String> testOutput1 = Arrays.asList("A,H,0.333", "A,G,0.333", "A,D,0.167", "A,F,0.083", "A,E,0.083","A,D,0.5", "B,F,0.25", "B,E,0.25", "C,H,0.5", "C,G,0.5");
    List<String> testOutput2 = Arrays.asList("A,H,333.333", "A,G,333.333", "A,D,83.333", "A,F,20.833", "A,E,20.833", "B,D,83.333", "B,F,20.833", "B,E,20.833", "C,H,333.333", "C,G,333.333");
    
    
    @Test
    public void findFundWeightOfPortFolio() {
    	List<String> output = g.fundWeightCalculator();
    	assertTrue(output.size() == testOutput1.size());
    }
    	
    
    
    @Test
    public void findEmvWeightedReturnOfPortFolio() {
    	List<String> output = g.fundWeightedReturn();
    	assertTrue(output.size() == testOutput2.size());
    }

 
}
