import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GasStation {

	public static void main(String [] args ) {
		// Welcome
		System.out.println(" Welcome! Please select one filling station number: 1, 2, 3, 4!");
		// Enter to select the gas station
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    int station;
		try {
			station = Integer.parseInt(bufferedReader.readLine());
			while (station < 1 || station > 4) {
				System.out.println("Invalid input. The options are: 1, 2, 3, 4");
				station = Integer.parseInt(bufferedReader.readLine());									
			}
			
			System.out.println("You are at Station: " + station);
			
			// Enter the gas types
			HashMap<String, Double> gasPrices = new HashMap<String, Double>();
			gasPrices.put("unleaded", 2.59);
			gasPrices.put("plus", 3.59);
			gasPrices.put("premium", 4.59);
			
			System.out.println("Please select the type of gas!");
			System.out.println(gasPrices);
		
		    String gasType;
			try {
				gasType = bufferedReader.readLine();
			    System.out.println("You selected: " + gasType);
			    System.out.println("Please enter the amount of gas you want!");
			    
				// Enter the amount of gas
				Double gallons;
				try {
					gallons = Double.parseDouble(bufferedReader.readLine());
				    System.out.println(gallons + " gallons is being filled...");
				    System.out.println("Here is your receipt. Thank you!");
				    double subTotal = gallons * gasPrices.get(gasType);
				    double tax = 0.08 * subTotal;
				    double total = subTotal + tax;
				    
				    System.out.println("Subtotal: " + subTotal);
				    System.out.println("Tax: " + tax);
				    System.out.println("Total: " + total);
				    
				} catch (IOException e) {
					e.printStackTrace();
				} 
			    
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}   
		
		
		
 
	}

	
	 
			 
	

}
