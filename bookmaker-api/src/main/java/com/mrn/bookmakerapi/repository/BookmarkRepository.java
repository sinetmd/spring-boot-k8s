package com.mrn.bookmakerapi.repository;

import com.mrn.bookmakerapi.domain.Bookmark;
import com.mrn.bookmakerapi.domain.BookmarkDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    // we are loading the data itself from bookmark and take only the bookmarkdto properties
    // and return them as bookmarkdto
    @Query("SELECT new com.mrn.bookmakerapi.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) FROM Bookmark b")
    Page<BookmarkDTO> findBookmarks(Pageable pageable);
}
