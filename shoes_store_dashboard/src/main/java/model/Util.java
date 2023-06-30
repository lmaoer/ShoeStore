package model;
import java.io.Console;
import java.text.NumberFormat;
import java.util.*;


import dal.ProductDAO;

public class Util {
	public Util() {
		
	}
	public static double costAfterDiscount(int cost, int discount) {
		return cost-cost*discount/100;
	}
	
}
