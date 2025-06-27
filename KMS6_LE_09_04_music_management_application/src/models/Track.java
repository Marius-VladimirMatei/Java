package models;

public class Track {
    private String id;
    private String title;
    private String mp3FileName;
    private int lengthSeconds;
    private String artistId;

    public Track(String id, String title, String mp3FileName, int lengthSeconds, String artistId) {
        this.id = id;
        this.title = title;
        this.mp3FileName = mp3FileName;
        this.lengthSeconds = lengthSeconds;
        this.artistId = artistId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMp3FileName() {
        return mp3FileName;
    }

    public int getLengthSeconds() {
        return lengthSeconds;
    }

    public String getArtistId() {
        return artistId;
    }

    public String toCSV() {
        return id + "," + title + "," + mp3FileName + "," + lengthSeconds + "," + artistId;
    }

    public static Track fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Track(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
    }
}
