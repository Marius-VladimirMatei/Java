package controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import models.Track;
import storage.Storage;

public class TrackController {
    private Map<String, Track> tracks = new HashMap<>();
    private Storage storage;

    public TrackController(Storage storage) {
        this.storage = storage;
        load();
    }

    public void addTrack(String id, String title, String mp3FileName, int lengthSeconds, String artistId) {
        tracks.put(id, new Track(id, title, mp3FileName, lengthSeconds, artistId));
        save();
    }

    public void deleteTrack(String id) {
        tracks.remove(id);
        save();
    }

    public Track getTrack(String id) {
        return tracks.get(id);
    }

    public Track[] getTracksByIds(String[] trackIds) {
        return Arrays.stream(trackIds)
                .map(this::getTrack)
                .filter(Objects::nonNull)
                .toArray(Track[]::new);
    }

    private void save() {
        String[] lines = tracks.values().stream().map(Track::toCSV).toArray(String[]::new);
        storage.save(lines);
    }

    private void load() {
        String[] lines = storage.load();
        for (String line : lines) {
            Track track = Track.fromCSV(line);
            tracks.put(track.getId(), track);
        }
    }
}