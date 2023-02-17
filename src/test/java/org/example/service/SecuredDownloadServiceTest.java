package org.example.service;

import org.example.entities.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.example.entities.UserType.FREE;
import static org.example.entities.UserType.PREMIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SecuredDownloadServiceTest {

    DownloadService service;

    @Test
    @DisplayName( "should download successfully" )
    void download() {
        service = new SecuredDownloadService(
                new DefaultDownloadService(),
                new User(
                        UUID.fromString( "41734f38-f586-47cd-ba36-f7472154ee09" ),
                        PREMIUM
                )
        );
        var result = service.download( "American idiot" );

        assertEquals( "Downloading song: American idiot", result );
    }

    @Test
    @DisplayName( "should fail downloading" )
    void failDownload() {
        service = new SecuredDownloadService(
                new DefaultDownloadService(),
                new User(
                        UUID.fromString( "41734f38-f586-47cd-ba36-f7472154ee09" ),
                        FREE
                )
        );

        var result = service.download( "American idiot" );

        assertEquals( "Not allowed", result );
    }

}