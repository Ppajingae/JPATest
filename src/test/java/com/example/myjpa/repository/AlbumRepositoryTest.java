package com.example.myjpa.repository;

import com.example.myjpa.domain.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Test
    public void testAlbum(){

        Album album = new Album();

        album.setName("GLASSY");
        album.setArtistId(1L);
        album.setCategory("발라드");

        albumRepository.save(album);

        albumRepository.findByArtistId(1L).forEach(System.out::println);
    }

}