import java.util.*;

public class Print {
	
	public void print(ArrayList<Buy> buyOrders, ArrayList<Sell> sellOrders) {
		//Remove orders without volume
		for(int i = 0; i < buyOrders.size(); i++) {
	  		for(int j = 0; j < sellOrders.size(); j++) {
		if(buyOrders.get(i).volume == 0)
			buyOrders.remove(i);
		if(sellOrders.get(j).volume == 0)
			sellOrders.remove(j);
	  		}
		}
		
		//Sort sell orders in descending order
		Collections.sort(buyOrders, new Comparator<Buy>() {
			public int compare(Buy buy1, Buy buy2) {
				return Integer.valueOf(buy2.price).compareTo(buy1.price);
			}
		});
			
		//Sort buy orders in ascending order
		Collections.sort(sellOrders, new Comparator<Sell>() {
			public int compare(Sell sell1, Sell sell2) {
				return Integer.valueOf(sell1.price).compareTo(sell2.price);
			}
			});
		
		//Print orders
		System.out.println("--- SELL ---");
		for(int i = 0; i < sellOrders.size(); i++) {
		if(sellOrders.get(i).price > 0)
		System.out.println("SELL " + sellOrders.get(i).volume+"@"+sellOrders.get(i).price);
		}
		
		System.out.println("--- BUY ---");
		for(int i = 0; i < buyOrders.size(); i++) {
		if(buyOrders.get(i).price > 0)
		System.out.println("BUY " + buyOrders.get(i).volume+"@"+buyOrders.get(i).price);
		}
	}
}