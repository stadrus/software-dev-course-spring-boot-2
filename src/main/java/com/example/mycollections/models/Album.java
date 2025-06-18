package com.example.mycollections.models;

public class Album extends LibraryItem {
    private String artist;
    private int track;

    public Album(String name, String artist, int year, int track) {
        super(name, year);
        this.artist = artist;
        this.track = track;
    }

    @Override
    public String toString() {
        return "Album{" +
                "track=" + track +
                ", artist='" + artist + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
}
