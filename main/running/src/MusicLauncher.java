import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MusicLauncher {

    // Method for users to input their username
    public static String InputUsername(){
        final String saved_usernames_filepath = "username_file/usernames.txt";
        String username = "";
        Set<String> usernames = new HashSet<>();

        // Enforcing username length requirements
        while(username.length() > 20 || username.length() < 2) {
            System.out.print("\nEnter a Username: ");
            username = new Scanner(System.in).nextLine().trim();
            if (username.length() > 20 || username.length() < 2) {
                System.out.println("This is an invalid username. Please try again.");
                MusicPlayer.Border();
            }
        }

        // Reads username file, adds new username or finds existing username
        try(BufferedReader reader = new BufferedReader(new FileReader(saved_usernames_filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                usernames.add(line.trim());
            }
            reader.close();

            // If username is already located in file, the user is prompt.
            if (usernames.contains(username)) {
                System.out.printf("Username is already saved. You have signed in, '%s'.\n ", username);
                MusicPlayer.Border();

                // Else, a new username is saved in the file
            } else {
                FileWriter writer = new FileWriter(saved_usernames_filepath, true);
                writer.write(username + "\n");
                writer.close();
                System.out.printf("Username has been saved. Welcome '%s' to the VIBES family. \n", username);
                MusicPlayer.Border();
            }
        }
        catch (IOException e){
            System.out.println("Error has occurred saving your username. Input/Output Error.");
        }
        return username;
    }

    static {
        System.out.println("Initializing VIBES Music Launcher. Please wait...");
    }


    // Main Function
    public static void main(String[] args) {
        MusicPlayer.Border();
        System.out.println("The Launcher is currently running. Follow the instructions below -> ");
        String username = InputUsername();

        // Menu to open music player or quit the launcher.
        while(true){
            System.out.print("""
                    
                    THE VIBES LAUNCHER VERSION 1.1
                    A. Run Vibes Software
                    B. Quit the Launcher
                    
                    Enter your choice:\s""");

            Scanner input = new Scanner(System.in);
                char option = input.next().toUpperCase().charAt(0);

                // If user types 'A' - > opens a new music player object.
                switch(option){
                    case 'A':
                        System.out.printf("The music player will load now. " +
                                "Thank you \"%s\" for using VIBES.\n", username);
                        MusicPlayer.Border();
                        new MusicPlayer();
                        break;

                    // If user types 'B' - > music launcher is terminated.
                    case 'B':
                        MusicPlayer.Border();
                        System.out.printf("\nThe launcher will close now. " +
                                "Thank you \"%s\" for using this launcher.", username);
                        input.close();
                        System.exit(0);

                    // Else, a prompt to enter valid input is printed.
                    default:
                        System.out.println("This option is invalid. Please try again.");
                        MusicPlayer.Border();
                }
            }
        }
    }
