import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

public class GasStation {

	public static void main(String [] args ) {
		// Welcome
		System.out.println(" Welcome! Please select one filling station number: 1, 2, 3, 4!");
		// Enter to select the gas station
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    int station;
		try {
			String stationResponse = bufferedReader.readLine();
			try {
				station = Integer.parseInt(stationResponse);
			} catch (NumberFormatException e) {
				station = 5;
			}
			while (station < 1 || station > 4) {
				System.out.println("Invalid input. The options are: 1, 2, 3, 4");
				try {
					stationResponse = bufferedReader.readLine();
					station = Integer.parseInt(stationResponse);
				} catch (NumberFormatException e) {
					station = 5;
				}								
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

			// Enter the gas types			
			Integer gasType;
			try {
				try {
					gasType = Integer.parseInt(bufferedReader.readLine());
				} catch (NumberFormatException e) {
					gasType = 4;
				}			
				while (gasType < 1  || gasType > 3) {	 		
					System.out.println("Invalid input. The options are: 1 - unleaded, 2 - plus, 3 - premium");
					try {
						gasType = Integer.parseInt(bufferedReader.readLine());
					} catch (NumberFormatException e) {
										
					}
				}
			    System.out.println("You selected: " + gasType);		     
			    
				// Enter the amount of gas
			    System.out.println("Please enter the amount of gas you want! Maximum amount is 35 gl");
				Double gallons;
				try {
					try {
						gallons = Double.parseDouble(bufferedReader.readLine());
					} catch (NumberFormatException e) {
						gallons = 36.0;						
					}
					while (gallons > 35 || gallons <= 0) {						
						System.out.println("Oops!!! Invalid input. Enter a number again! Max is 35 gl.");
						gallons = Double.parseDouble(bufferedReader.readLine());
					}
					
				    System.out.println(gallons + " gallons is being filled...");
				    System.out.println("Here is your receipt. Thank you!");
				    double subTotal = gallons * gasPrices.get(gasType);
				    String subTotalString = NumberFormat.getCurrencyInstance(Locale.US).format(subTotal);
				    double tax = 0.08 * subTotal;
				    String taxString = NumberFormat.getCurrencyInstance(Locale.US).format(tax);
				    double total = subTotal + tax;
				    String totalString = NumberFormat.getCurrencyInstance(Locale.US).format(total);
				    
				    System.out.println("Subtotal: " + subTotalString);
				    System.out.println("Tax: " + taxString);
				    System.out.println("Total: " + totalString);
				    
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
