package org.example.service;

import org.example.entities.User;

import static org.example.entities.UserType.PREMIUM;

public class SecuredDownloadService implements DownloadService {
    private final DownloadService service;
    private final User user;

    public SecuredDownloadService( DownloadService service, User user ) {
        this.service = service;
        this.user = user;
    }

    @Override
    public String download( String songName ) {
        return user.getType().equals( PREMIUM )
                ? service.download( songName )
                : "Not allowed";
    }
}
