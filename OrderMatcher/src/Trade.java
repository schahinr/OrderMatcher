import java.util.*;
/*
 * The trading function iterates through both ArrayLists to find a buy order that has a price higher than or equal to 
 * the price of a sell order. If such a match is found, a trade will occur where the volumes of both orders will be
 * reduced as much as possible. The price of the trade is computed as the order that was in the order book first
 * 
 * The priority of the orders to match is based on following;
 * 1. On the price that is best for the active order
 * 2. On the time the order was entered
 * 
 */
public class Trade {
	
	public void trade(ArrayList<Buy> buyOrders, ArrayList<Sell> sellOrders) {
	for(int i = 0; i < buyOrders.size(); i++) {
  		for(int j = 0; j < sellOrders.size(); j++) {
  			if(buyOrders.get(i).volume > 0 && sellOrders.get(j).volume > 0) {
  				
  				//Start trade if the buy order price is equal to or higher than the sell order price
  				if(buyOrders.get(i).price >= sellOrders.get(j).price) {
  					
  					//Check if the sell order was entered before the buy order
  					if(buyOrders.get(i).timeStamp > sellOrders.get(j).timeStamp) {
  						if(sellOrders.get(j).volume >= buyOrders.get(i).volume) {
  							System.out.println("TRADE " + buyOrders.get(i).volume + "@" + sellOrders.get(j).price);
  							sellOrders.get(j).volume = sellOrders.get(j).volume - buyOrders.get(i).volume;
  							buyOrders.get(i).volume = 0;
  						}
  						else {
  							System.out.println("TRADE " + sellOrders.get(j).volume + "@" + sellOrders.get(j).price);
  							buyOrders.get(i).volume = buyOrders.get(i).volume - sellOrders.get(j).volume;
  							sellOrders.get(j).volume = 0;
  						}
  					}
  					
  					//Check if the buy order was entered before the sell order
  					if(sellOrders.get(j).timeStamp > buyOrders.get(i).timeStamp) {
  						if(sellOrders.get(j).volume >= buyOrders.get(i).volume) {
  							System.out.println("TRADE " + buyOrders.get(i).volume + "@" + buyOrders.get(i).price);
  							sellOrders.get(j).volume = sellOrders.get(j).volume - buyOrders.get(i).volume;
  							buyOrders.get(i).volume = 0;
  						}
  						else {
  							System.out.println("TRADE " + sellOrders.get(j).volume + "@" + buyOrders.get(i).price);
  							buyOrders.get(i).volume = buyOrders.get(i).volume - sellOrders.get(j).volume;
  							sellOrders.get(j).volume = 0;
  						}
  					}
  				}
  			}
  		}
	}
	}
}