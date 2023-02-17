package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultDownloadServiceTest {
    DownloadService service;

    @BeforeEach
    void setup() {
        service = new DefaultDownloadService();
    }

    @Test
    @DisplayName( "should download successfully" )
    void download() {
        var result = service.download( "American idiot" );

        assertEquals( "Downloading song: American idiot", result );
    }
}