package com.example.myjpa.repository;

import com.example.myjpa.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByArtistId(Long id);
}
