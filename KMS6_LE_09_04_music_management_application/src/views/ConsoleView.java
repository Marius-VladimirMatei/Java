package views;

import java.util.Scanner;
import models.Album;
import models.Artist;
import models.Track;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\nMusic Library Menu:");
        System.out.println("1. Add Artist");
        System.out.println("2. Add Track");
        System.out.println("3. Add Album");
        System.out.println("4. Delete Artist");
        System.out.println("5. Delete Track");
        System.out.println("6. Delete Album");
        System.out.println("7. Show Album Details");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showAlbumDetails(Album album, Artist artist, Track[] tracks) {
        System.out.println("\nAlbum: " + album.getTitle());
        System.out.println("Artist: " + (artist != null ? artist.getName() : "Unknown"));
        System.out.println("Tracks:");
        int totalSeconds = 0;
        for (Track track : tracks) {
            System.out.println("  - " + track.getTitle() + " (" + track.getMp3FileName() + ", " +
                    track.getLengthSeconds() / 60 + ":" + track.getLengthSeconds() % 60 + ")");
            totalSeconds += track.getLengthSeconds();
        }
        System.out.println("Total Playing Time: " + totalSeconds / 60 + ":" + totalSeconds % 60);
    }
}