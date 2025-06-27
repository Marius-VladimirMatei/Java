import controllers.AlbumController;
import controllers.ArtistController;
import controllers.TrackController;
import models.Album;
import models.Artist;
import models.Track;
import storage.Storage;
import views.InputHandler;
import views.Menu;
import views.OutputHandler;

public class Main {
    public static void main(String[] args) {
        Storage artistStorage = new Storage("artists.csv");
        Storage trackStorage = new Storage("tracks.csv");
        Storage albumStorage = new Storage("albums.csv");

        TrackController trackController = new TrackController(trackStorage);
        ArtistController artistController = new ArtistController(artistStorage);
        AlbumController albumController = new AlbumController(albumStorage, trackController);

        Menu menu = new Menu();
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        while (true) {
            menu.display();
            String choice = inputHandler.getInput("");

            try {
                switch (choice) {
                    case "1":
                        String artistId = inputHandler.getInput("Artist ID: ");
                        String artistName = inputHandler.getInput("Artist Name: ");
                        artistController.addArtist(artistId, artistName);
                        outputHandler.displayMessage("Artist added!");
                        break;
                    case "2":
                        String trackId = inputHandler.getInput("Track ID: ");
                        String trackTitle = inputHandler.getInput("Track Title: ");
                        String mp3File = inputHandler.getInput("MP3 File Name: ");
                        int length = Integer.parseInt(inputHandler.getInput("Length (seconds): "));
                        String trackArtistId = inputHandler.getInput("Artist ID: ");
                        trackController.addTrack(trackId, trackTitle, mp3File, length, trackArtistId);
                        outputHandler.displayMessage("Track added!");
                        break;
                    case "3":
                        String albumId = inputHandler.getInput("Album ID: ");
                        String albumTitle = inputHandler.getInput("Album Title: ");
                        String albumArtistId = inputHandler.getInput("Artist ID: ");
                        String trackIdsStr = inputHandler.getInput("Track IDs (comma-separated): ");
                        String[] trackIds = trackIdsStr.split(",");
                        albumController.addAlbum(albumId, albumTitle, albumArtistId, trackIds);
                        outputHandler.displayMessage("Album added!");
                        break;
                    case "4":
                        String delArtistId = inputHandler.getInput("Artist ID: ");
                        artistController.deleteArtist(delArtistId);
                        outputHandler.displayMessage("Artist deleted!");
                        break;
                    case "5":
                        String delTrackId = inputHandler.getInput("Track ID: ");
                        trackController.deleteTrack(delTrackId);
                        outputHandler.displayMessage("Track deleted!");
                        break;
                    case "6":
                        String delAlbumId = inputHandler.getInput("Album ID: ");
                        albumController.deleteAlbum(delAlbumId);
                        outputHandler.displayMessage("Album and associated tracks deleted!");
                        break;
                    case "7":
                        String showAlbumId = inputHandler.getInput("Album ID: ");
                        Album album = albumController.getAlbum(showAlbumId);
                        if (album == null) {
                            outputHandler.displayMessage("Album not found!");
                            break;
                        }
                        Artist artist = artistController.getArtist(album.getArtistId());
                        Track[] tracks = trackController.getTracksByIds(album.getTrackIds());
                        outputHandler.displayAlbumDetails(album, artist, tracks);
                        break;
                    case "8":
                        outputHandler.displayMessage("Goodbye!");
                        return;
                    default:
                        outputHandler.displayMessage("Invalid option!");
                }
            } catch (Exception e) {
                outputHandler.displayMessage("Error: " + e.getMessage());
            }
        }
    }
}
