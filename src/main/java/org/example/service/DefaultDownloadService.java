package org.example.service;

public class DefaultDownloadService implements DownloadService {
    @Override
    public String download( String songName ) {
        return "Downloading song: " + songName;
    }
}
