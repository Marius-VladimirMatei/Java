package controllers;

import java.util.HashMap;
import java.util.Map;
import models.Album;
import storage.Storage;

public class AlbumController {
    private Map<String, Album> albums = new HashMap<>();
    private Storage storage;
    private TrackController trackController;

    public AlbumController(Storage storage, TrackController trackController) {
        this.storage = storage;
        this.trackController = trackController;
        load();
    }

    public void addAlbum(String id, String title, String artistId, String[] trackIds) {
        albums.put(id, new Album(id, title, artistId, trackIds));
        save();
    }

    public void deleteAlbum(String id) {
        Album album = albums.get(id);
        if (album != null) {
            String[] trackIds = album.getTrackIds();
            albums.remove(id);
            for (String trackId : trackIds) {
                trackController.deleteTrack(trackId);
            }
            save();
        }
    }

    public Album getAlbum(String id) {
        return albums.get(id);
    }

    private void save() {
        String[] lines = albums.values().stream().map(Album::toCSV).toArray(String[]::new);
        storage.save(lines);
    }

    private void load() {
        String[] lines = storage.load();
        for (String line : lines) {
            Album album = Album.fromCSV(line);
            albums.put(album.getId(), album);
        }
    }
}