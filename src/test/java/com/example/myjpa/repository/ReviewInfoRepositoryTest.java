package com.example.myjpa.repository;

import com.example.myjpa.domain.Album;
import com.example.myjpa.domain.AlbumReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReviewInfoRepositoryTest {

    @Autowired
    private AlbumReviewInfoRepository albumReviewInfoRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Test
    public void crud(){

        AlbumReviewInfo albumReviewInfo = new AlbumReviewInfo();

        albumReviewInfo.setAlbum(addingAlbum());

        albumReviewInfo.setAverageReviewScore(4.5F);

        albumReviewInfo.setReviewCount(7);

        albumReviewInfoRepository.save(albumReviewInfo);

        System.out.println(" >>> " + albumReviewInfoRepository.findById(1L));
    }


    @Test
    public void crudRelationTest(){

        addingAlbumReviewInfo();

        Album result = albumReviewInfoRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getAlbum();

        System.out.println(" >>> " + result);
    }

    private Album addingAlbum(){

        Album album = new Album();

        album.setName("GLASSY");
        album.setArtistId(1L);
        album.setCategory("댄스");

        return albumRepository.save(album);
    }
    private void addingAlbumReviewInfo(){
        AlbumReviewInfo albumReviewInfo = new AlbumReviewInfo();

        albumReviewInfo.setAlbum(addingAlbum());
        albumReviewInfo.setAverageReviewScore(4.5F);
        albumReviewInfo.setReviewCount(24);

        albumReviewInfoRepository.save(albumReviewInfo);

        albumReviewInfoRepository.findAll().forEach(System.out::println);

    }
}