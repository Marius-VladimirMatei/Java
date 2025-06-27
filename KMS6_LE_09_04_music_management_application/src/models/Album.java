package models;

public class Album {
    private String id;
    private String title;
    private String artistId;
    private String[] trackIds;

    public Album(String id, String title, String artistId, String[] trackIds) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.trackIds = trackIds;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistId() {
        return artistId;
    }

    public String[] getTrackIds() {
        return trackIds;
    }

    public String toCSV() {
        return id + "," + title + "," + artistId + "," + String.join(";", trackIds);
    }

    public static Album fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Album(parts[0], parts[1], parts[2], parts[3].split(";"));
    }
}