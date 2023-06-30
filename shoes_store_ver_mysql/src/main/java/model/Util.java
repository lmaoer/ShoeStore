package model;
import java.util.*;

public class Util {
	public Util() {
		
	}
	
	public static double totalPrice(List<Order> list) {
		double s = 0;
		for(Order o: list) {
			double cost = costAfterDiscount(o.getProduct().getCost(), o.getProduct().getDiscount());
			s += o.getQuantity()*cost;
		}
		return s;
	}
	
	public static double costAfterDiscount(int cost, int discount) {
		return cost-cost*discount/100;
	}
}
