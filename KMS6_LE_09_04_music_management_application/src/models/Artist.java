package models;

public class Artist {
    private String id;
    private String name;

    public Artist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toCSV() {
        return id + "," + name;
    }

    public static Artist fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Artist(parts[0], parts[1]);
    }
}