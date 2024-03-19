package com.mrn.bookmakerapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class BookmarksDTO {
    private List<BookmarkDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;

    // using it in json as isFirst instead of fistPager
    @JsonProperty("isFirst")
    private boolean isFirstPage;

    // using it in json as isLast instead of lastPage
    @JsonProperty("isLast")
    private boolean isLastPage;
    private boolean hasNext;
    private boolean hasPrevious;

    public BookmarksDTO(Page<BookmarkDTO> bookmarkPage) {
        this.setData(bookmarkPage.getContent());
        this.setTotalElements(bookmarkPage.getTotalElements());
        this.setTotalPages(bookmarkPage.getTotalPages());
        this.setCurrentPage(bookmarkPage.getNumber() + 1); // we start at 0
        this.setFirstPage(bookmarkPage.isFirst());
        this.setLastPage(bookmarkPage.isLast());
        this.setHasNext(bookmarkPage.hasNext());
        this.setHasPrevious(bookmarkPage.hasPrevious());
    }
}
