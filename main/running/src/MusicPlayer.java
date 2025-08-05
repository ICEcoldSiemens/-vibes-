import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MusicPlayer {

    // Function to draw border to separate sections
    static void Border() {
        for (int i = 0; i < 200; i++) {
            System.out.print('-');
        }
        System.out.print("\n");
    }

    // Function to display main menu display to choose music genre.
    static void MainMenuDisplay(){
        System.out.print("""
              \s
               VIBES MUSIC MAIN MENU: CHOOSE A MUSIC GENRE TO LISTEN TO
               1. Hip Hop \s
               2. Rock
               3. K-Pop
               4. EDM
               5. Funk
               6. Exit Program
               Enter a number:\s""");
        int option = new Scanner(System.in).nextInt();
        playMusicGenre(option);
    }

    // User chooses a music genre and a playlist is played.
    static void playMusicGenre(int option) {
        while (true) {
            switch (option) {
                case 1:
                    Border();
                    System.out.println("\nYou have chosen the HipHop playlist. ENJOY!");
                    new HipHop();

                case 2:
                    Border();
                    System.out.println("\nYou have chosen the Rock playlist. ENJOY!");
                    new Rock();

                case 3:
                    Border();
                    System.out.println("\nYou have chosen the K-Pop playlist. ENJOY!");
                    new KPop();

                case 4:
                    Border();
                    System.out.println("\nYou have chosen the EDM playlist. ENJOY!");
                    new EDM();

                case 5:
                    Border();
                    System.out.println("\nYou have chosen the Funk playlist. ENJOY!");
                    new Funk();

                case 6:
                    Border();
                    System.out.println("\nThe software will close now. Thank you for using the VIBES software.");
                    System.exit(0);

                default:
                    System.out.println("This is not a valid option. Please try again.");
                    Border();
            }
        }
    }

    // Constructor to collect, read and store new or existing usernames on a file.
    MusicPlayer() {
        MainMenuDisplay();
    }
}