# INSTRUCTIONS 
1. Download the ZIP file and run the MusicLauncher.java class (acts as a Launcher) within a compatiable IDE for Java. <br><br>
   
2. You should have this on the terminal: <br><br>
  <img width="1751" height="465" alt="Screenshot 2025-08-06 174130" src="https://github.com/user-attachments/assets/b09aa443-71ea-4a9c-bf9c-9ab84ac74fff" /> <br><br>

3. Input a username. You will be prompt to start the music player program and the music genres menu. <br><br> 
<img width="1291" height="465" alt="Screenshot 2025-08-06 174459" src="https://github.com/user-attachments/assets/4a97dd50-1b43-48d5-8caf-0213e0a6c9dc" /> <br><br>

4. Choose a playlist and you will be shown 5 songs. Press 'Y' to start the playlist or any key to return to the music genre menu. <br><br>
   <img width="949" height="300" alt="Screenshot 2025-08-06 175626" src="https://github.com/user-attachments/assets/4fa0c8b8-5401-440f-999c-0ee95baaedf1" /> <br><br>

5. While song plays, you may access the audio features required. <br><br>
   <img width="805" height="264" alt="Screenshot 2025-08-06 180300" src="https://github.com/user-attachments/assets/72b77636-a59d-4257-ab01-89b0823e20be" /> <br><br>
<br><br>

# FEATURES
- Implements automatic song playing after finished songs.
- Features to resume, pause, skip, restart and quit songs. <br><br>
<br><br>

# CURRENT ISSUES TO FIX/FEATURES TO IMPLEMENT
- The ZIP file is large due to WAV music files within "music_file" (will be compressed to mp3 with lower bitrate) + changing code to implement libraries for mp3 compatibility.
- Some music files may not be found due to bad refactoring, leading to exception to quit music (music files will be refactored correctly).
- Better usage for usernames + username file in general (may introduce accounts with authentication + a relational database).
- Improve command line interface formatting and aesthetic during play.
- Could add music shuffling.
- During all menu selection, risk of broken input and bugs (improve input validation and exception handling through testing)

If there are any features or improvements I should add, contact me. I don't bite :)
