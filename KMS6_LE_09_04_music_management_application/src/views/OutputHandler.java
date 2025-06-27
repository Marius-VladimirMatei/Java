package views;

import models.Album;
import models.Artist;
import models.Track;

public class OutputHandler {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayAlbumDetails(Album album, Artist artist, Track[] tracks) {
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
