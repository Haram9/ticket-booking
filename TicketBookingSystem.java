package CourseWork1;

import java.io.File; // Allows handling file operations
import java.io.FileNotFoundException;
import java.io.FileWriter; // Allows writing to files
import java.io.IOException; // Handles I/O exceptions
import java.util.InputMismatchException; // Handles invalid user inputs
import java.util.Scanner; // Allows user input and file reading

/*Algorithm:
 *  Displays a yes or no question, loops until proper input is given
 *  If yes, code runs through the custom option, asking users for custom inputs and write those values given in tickets[2].txt file
 *  Scans inputs, loops,giving users 5 attempts before exiting the program to enter a valid input, specifically integer and double values
 *  Calculates specific and total revenue from the custom inputs
 *  Displays the calculated values, as Pounds,till 2 decimal places
 *  If no, scans the tickets.txt file and displays the default values
 *  Calculates and displays specific and total revenue, as Pounds,till 2 decimal places
 *  Closes scanner     */

        public class TicketBookingSystem 
        {
       
    	static Scanner scan = new Scanner(System.in); // Scanner for user input
        public static void main(String[] args) throws IOException, FileNotFoundException 
        {
        while (true) // Main loop to prompt user until valid input is provided
        { 
        	
        	System.out.println("***Ticket Booking System***");
            System.out.println("Hello User, Do you wish to specify the ticket prices? (yes/no)");
            String choice = scan.nextLine().trim().toLowerCase(); // Normalize user input to lower case for consistency

        if (choice.equals("y") || choice.equals("yes"))
        {
                // Declare variables for ticket prices and bookings
                double ticketP1 = 0, ticketP2 = 0, ticketP3 = 0, ticketP4 = 0; // Ticket prices for different categories
                int bookingA1 = 0, bookingA2 = 0, bookingA3 = 0, bookingA4 = 0; // Number of bookings for each category

                // Initialize input attempt counter
                int attempts = 0; // Tracks number of input attempts
                final int maxAttempts = 3; // Maximum allowed attempts for user input

         while (attempts < maxAttempts) // Loop to validate user input within a limited number of attempts
         { 
                try {
                        // Prompt user for ticket prices and bookings for each category
                        System.out.println("Please enter ticket price for VIP:");
                        ticketP1 = scan.nextDouble(); // Ticket price for VIP

                        System.out.println("Please enter the number of bookings for VIP:");
                        bookingA1 = scan.nextInt(); // Number of VIP bookings

                        System.out.println("Please enter ticket price for Regular:");
                        ticketP2 = scan.nextDouble(); // Ticket price for Regular

                        System.out.println("Please enter the number of bookings for Regular:");
                        bookingA2 = scan.nextInt(); // Number of Regular bookings

                        System.out.println("Please enter ticket price for Balcony:");
                        ticketP3 = scan.nextDouble(); // Ticket price for Balcony

                        System.out.println("Please enter the number of bookings for Balcony:");
                        bookingA3 = scan.nextInt(); // Number of Balcony bookings

                        System.out.println("Please enter ticket price for General Admission:");
                        ticketP4 = scan.nextDouble(); // Ticket price for General Admission

                        System.out.println("Please enter the number of bookings for General Admission:");
                        bookingA4 = scan.nextInt(); // Number of General Admission bookings

                        break; // Exit loop on successful input
                        
                     }
                       catch (InputMismatchException e) // Handle invalid input by displaying a warning and increasing the attempt counter
                     {
                       attempts++;
                       
                       System.out.printf("Invalid input. Please enter numbers only. (%d/%d attempts)\n", attempts, maxAttempts);
                       scan.nextLine(); // Clear invalid input buffer
                       if (attempts == maxAttempts)// Exit program if maximum attempts are reached
                     {
                            
                            System.out.println("Maximum attempts reached. Exiting program.");
                            return;
                     }
                     }
                     }

                        // Write the user-provided values to the file
                       File ticketFile = new File("C:\\Users\\DE\\eclipse-workspace\\Lab04\\src\\CourseWork1\\tickets[2].txt");
                       try (FileWriter writer = new FileWriter(ticketFile))
                       {
                       writer.write("Custom Ticket Prices and Bookings:\n");
                       writer.write(String.format("VIP: Price: %.2f, Bookings: %d\n", ticketP1, bookingA1));
                       writer.write(String.format("Regular: Price: %.2f, Bookings: %d\n", ticketP2, bookingA2));
                       writer.write(String.format("Balcony: Price: %.2f, Bookings: %d\n", ticketP3, bookingA3));
                       writer.write(String.format("General Admission: Price: %.2f, Bookings: %d\n", ticketP4, bookingA4));
                       System.out.println("Custom values successfully written to 'tickets.txt'.");
                       }
                       catch (IOException e)  // Handle file writing errors
                       {
                   
                        System.out.println("An error occurred while writing to the file.");
                       }

                 // Calculate revenue for each category
                double price1 = ticketP1 * bookingA1; // Revenue for VIP
                System.out.printf("Revenue for VIP: £%.2f%n", price1);

                double price2 = ticketP2 * bookingA2; // Revenue for Regular
                System.out.printf("Revenue for Regular: £%.2f%n", price2);

                double price3 = ticketP3 * bookingA3; // Revenue for Balcony
                System.out.printf("Revenue for Balcony: £%.2f%n", price3);

                double price4 = ticketP4 * bookingA4; // Revenue for General Admission
                System.out.printf("Revenue for General Admission: £%.2f%n", price4);

                // Calculate total revenue
                double totalRevenue = price1 + price2 + price3 + price4; // Total revenue across all categories
                System.out.printf("Total Revenue: £%.2f%n", totalRevenue);
                break; // Exit the main loop after processing
                
            }
                else if (choice.equals("n") || choice.equals("no"))
            {
                // Display default ticket prices and calculate revenue
                System.out.println("Reading default or custom prices from the file:");
                File ticketFile = new File("C:\\Users\\DE\\eclipse-workspace\\Lab04\\src\\CourseWork1\\tickets[1].txt");

                try (Scanner fileScanner = new Scanner(ticketFile))
                    {
                    while (fileScanner.hasNextLine()) // Loop to read file content line by line
                    { 
                        System.out.println(fileScanner.nextLine());
                    }

                    // Default revenue calculations
                    double vipRevenue = 150 * 40; // Revenue for VIP
                    double regularRevenue = 80 * 120; // Revenue for Regular
                    double balconyRevenue = 100 * 75; // Revenue for Balcony
                    double generalRevenue = 50 * 200; // Revenue for General Admission

                    // Print revenue for each category
                    System.out.printf("Default Revenue for VIP: £%.2f%n", vipRevenue);
                    System.out.printf("Default Revenue for Regular: £%.2f%n", regularRevenue);
                    System.out.printf("Default Revenue for Balcony: £%.2f%n", balconyRevenue);
                    System.out.printf("Default Revenue for General Admission: £%.2f%n", generalRevenue);

                    // Calculate and display total default revenue
                    double totalDefaultRevenue = vipRevenue + regularRevenue + balconyRevenue + generalRevenue;
                    System.out.printf("Total Default Revenue: £%.2f%n", totalDefaultRevenue);
                    } 
                     break; // Exit the main loop after processing
                
                }
                else  
                {
                // Handle invalid input for initial choice
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
                }

                // Close the scanner to release resources
                   scan.close();
        }
        }

