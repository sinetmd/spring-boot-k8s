package com.mrn.bookmakerapi.mapper;

import com.mrn.bookmakerapi.domain.Bookmark;
import com.mrn.bookmakerapi.domain.BookmarkDTO;
import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {
    public BookmarkDTO toDTO(Bookmark bookmark) {
        BookmarkDTO dto = new BookmarkDTO();
        dto.setId(bookmark.getId());
        dto.setTitle(bookmark.getTitle());
        dto.setUrl(bookmark.getUrl());
        dto.setCreatedAt(bookmark.getCreatedAt());

        return dto;
    }
}
