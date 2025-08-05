import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;

// Class for Rock playlist
public class Rock implements MusicGenre {
    private long pausePosition = 0;

    // Method for resume feature -> resumes the song dependent on microsecond when song paused
    @Override
    public void Resume(Clip clip, File file) {
        if (!clip.isRunning()) {
            System.out.println("\nPlaying: " + file.getName());
            clip.setMicrosecondPosition(pausePosition);
            clip.start();
        } else { // or prompts user that the song is already playing
            System.out.println("The song is already playing :)");
            System.out.println("\nPlaying: " + file.getName());
        }
    }

    // Method for pausing feature -> stops the song and collects the microsecond at paused instance
    @Override
    public void Pause(Clip clip, File file) {
        if (clip.isRunning()) {
            System.out.println("Paused: " + file.getName());
            pausePosition = clip.getMicrosecondPosition();
            clip.stop();
        } else{ // or prompts if song is already paused
            System.out.println("The song is already paused :)");
        }
    }

    /*Method for enabling skipping feature -> restarts microsecond position
        (in case song was paused before), stops current song and closes song.*/
    @Override
    public void Skip(Clip clip, File file) {
        pausePosition = 0;
        System.out.println("Attempting to skip: " + file.getName());
        clip.stop();
        clip.close();
    }

    // Method to restart a song -> restarts microsecond position of song and starts song again.
    @Override
    public void Restart(Clip clip, File file) {
        System.out.println("Restarting: " + file.getName());
        MusicPlayer.Border();
        clip.stop();
        clip.setMicrosecondPosition(0);
        clip.start();
        System.out.println("\nPlaying: " + file.getName());
    }

    /* Method to quit a song -> restarts microsecond position (in case song was paused before),
    stops and closes song + goes back to playlist menu*/
    @Override
    public void Quit(Clip clip, File file) {
        pausePosition = 0;
        System.out.println("Quitting: " + file.getName());
        clip.stop();
        clip.close();
        MusicPlayer.Border();
        new EDM();
    }

    // Method to enable features + song automation while song plays
    public void Features(Clip clip, File file) {
        pausePosition = 0;
        final boolean[] songFinished = {false};

        // Provides songs to play automatically after previous song finishes
        clip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP && clip.getMicrosecondPosition() >= clip.getMicrosecondLength()) {
                songFinished[0] = true;
                MusicPlayer.Border();
                System.out.println("\nThe song has finished playing: " + file.getName());

            }
        });

        // Thread for user interaction with features
        Thread inputThread = new Thread(() -> {
            while (!songFinished[0]) {
                System.out.println("\nW -> Play");
                System.out.println("E -> Pause");
                System.out.println("S -> Skip");
                System.out.println("R -> Restart");
                System.out.println("Q -> Quit");
                System.out.print("Input desired feature: ");
                char feature = new Scanner(System.in).next().toUpperCase().trim().charAt(0);
                MusicPlayer.Border();

                switch (feature) {
                    case 'W':
                        Resume(clip, file);
                        break;
                    case 'E':
                        Pause(clip, file);
                        break;
                    case 'S':
                        Skip(clip, file);
                        songFinished[0] = true;
                        break;
                    case 'R':
                        Restart(clip, file);
                        break;
                    case 'Q':
                        Quit(clip, file);
                        songFinished[0] = true;
                        break;
                    default:
                        System.out.println("Invalid feature!!!");
                        System.out.println("\nPlaying: " + file.getName());
                }
            }
        });

        inputThread.start();

        // Delay when playing next song
        while (!songFinished[0]) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {}
        }

        clip.stop();
        clip.close();
    }

    // Constructor to loop through each song in Rock playlist + submenu to run playlist or quit.
    public Rock() {
        // Stores music file paths in a Files array
        try {
            files[0] = new File("music_file/rock/Arctic Monkeys - Do I Wanna Know？.wav");
            files[1] = new File("music_file/rock/Guns N' Roses - Sweet Child O' Mine.wav");
            files[2] = new File("music_file/rock/Nirvana - Smells Like Teen Spirit.wav");
            files[3] = new File("music_file/rock/Numb – Linkin Park.wav");
            files[4] = new File("music_file/rock/Queen – Bohemian Rhapsody.wav");

            System.out.println("\nROCK PLAYLIST");
            for (File name : files) {
                String fileName = name.getName();
                System.out.println(fileName);
            }
            System.out.print("\nDo you want to play this playlist? (Y/ANY KEY): ");
            String ans = new Scanner(System.in).nextLine().toUpperCase();

            if (ans.equals("Y")) {
                for (File file : files) {
                    MusicPlayer.Border();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    Resume(clip, file);
                    Features(clip, file);
                }
                new Rock();
            } else {
                MusicPlayer.Border();
                MusicPlayer.MainMenuDisplay();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}


