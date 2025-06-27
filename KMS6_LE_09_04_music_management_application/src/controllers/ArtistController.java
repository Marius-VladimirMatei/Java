package controllers;

import java.util.HashMap;
import java.util.Map;
import models.Artist;
import storage.Storage;

public class ArtistController {
    private Map<String, Artist> artists = new HashMap<>();
    private Storage storage;

    public ArtistController(Storage storage) {
        this.storage = storage;
        load();
    }

    public void addArtist(String id, String name) {
        artists.put(id, new Artist(id, name));
        save();
    }

    public void deleteArtist(String id) {
        artists.remove(id);
        save();
    }

    public Artist getArtist(String id) {
        return artists.get(id);
    }

    private void save() {
        String[] lines = artists.values().stream().map(Artist::toCSV).toArray(String[]::new);
        storage.save(lines);
    }

    private void load() {
        String[] lines = storage.load();
        for (String line : lines) {
            Artist artist = Artist.fromCSV(line);
            artists.put(artist.getId(), artist);
        }
    }
}