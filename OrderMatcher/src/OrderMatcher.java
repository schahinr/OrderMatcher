import java.util.*;

/*
 * OrderMatcher by Schahin Rajab
 * 
 * The user enters either a buy or a sell order by first typing in the
 * order type followed by quantity and price. The 'PRINT' command prints
 * out all available orders to the console in sorted order (lowest price
 * for sell on top and highest for buy).
 * 
 * A trade occurs if a buy order exist at equal or higher price to a sell
 * order in the order list. The trade reduces the volume of the both orders
 * as much as possible and an order can match several other orders if the
 * volume is large enough and the price is correct. Whenever there is a
 * trade a "TRADE volume@price" is printed out to the console. The price of
 * the trade is computed as the order that was in the order book first.
 * 
 */

public class OrderMatcher {
	
	public static void main(String[] args) {
		
		ArrayList<Buy> buyOrders = new ArrayList<Buy>();
		ArrayList<Sell> sellOrders = new ArrayList<Sell>();
		
		Scanner sc = new Scanner(System.in);
		Print p = new Print();
		Trade ex = new Trade();
		//timeStamp is used to make sense of which order was entered first
		int timeStamp = 0;
		
		while(true) {
		//Enter order type
		System.out.println("Enter 'BUY' or 'SELL' or 'PRINT: ");
		String orderType = sc.next();
		
		timeStamp++;
		
		//Enter sell order
		if(orderType.equals("SELL")) {
			System.out.println("You have selected a SELL order");
			System.out.print("Enter volume and then press enter: ");
			int volume = sc.nextInt();
			System.out.print("Enter price and then press enter: ");
			int price = sc.nextInt();
			sellOrders.add(new Sell(volume, price, timeStamp));
		}
		
		//Enter buy order
		if(orderType.equals("BUY")) {
			System.out.println("You have selected a BUY order");
			System.out.print("Enter volume and then press enter: ");
			int volume = sc.nextInt();
			System.out.print("Enter price and then press enter: ");
			int price = sc.nextInt();
			buyOrders.add(new Buy(volume, price, timeStamp));
		}
		
		//Print all orders in a sorted list
		if(orderType.equals("PRINT"))
			p.print(buyOrders, sellOrders);
	
		//Trade
	  	ex.trade(buyOrders, sellOrders);
		}
	}
}
