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
			
			//List types of gas
			HashMap<Integer, Double> gasPrices = new HashMap<Integer, Double>();
			gasPrices.put(3, 4.59);
			gasPrices.put(2, 3.59);
			gasPrices.put(1, 2.59);
						
			System.out.println("Please select the number of the type of gas you want:");
			System.out.println("1. Unleaded - $2.59/gl");
			System.out.println("2. Plus - $3.59/gl");
			System.out.println("3. Premium - $4.59/gl");
//			System.out.println(gasPrices);
			// Enter the gas types			
			Integer gasType;
			try {
				gasType = Integer.parseInt(bufferedReader.readLine()); 
				if (gasType < 1  || gasType > 3) {	 		
					System.out.println("Invalid input. The options are: 1 - unleaded, 2 - plus, 3 - premium");
					gasType = Integer.parseInt(bufferedReader.readLine());				
				}
			    System.out.println("You selected: " + gasType);		     
			    
				// Enter the amount of gas
			    System.out.println("Please enter the amount of gas you want! Maximum amount is 35 gl");
				Double gallons;
				try {
					gallons = Double.parseDouble(bufferedReader.readLine());
					if (gallons > 35) {
						System.out.println("Oops!!! Max amount is 35 gallons. Put your amount again!");
						gallons = Double.parseDouble(bufferedReader.readLine());
					}
					
				    System.out.println(gallons + " gallons is being filled...");
				    System.out.println("Here is your receipt. Thank you!");
				    double subTotal = gallons * gasPrices.get(gasType) ;
				    String subTotalString = String.format("%.4g%n", subTotal);
				    double tax = 0.08 * subTotal;
				    String taxString = String.format("%.3g%n", tax);
				    double total = subTotal + tax;
				    String totalString = String.format("%.4g%n", total);
				    
				    System.out.println("Subtotal: $" + subTotalString);
				    System.out.println("Tax: $" + taxString);
				    System.out.println("Total: $" + totalString);
				    
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
