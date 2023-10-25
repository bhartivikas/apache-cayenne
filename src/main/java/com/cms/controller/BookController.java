package com.cms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.BookDto;
import com.cms.dto.BookSearchResponseDto;
import com.cms.entity.CmsBook;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

	private final ObjectContext objectContext;

	@GetMapping("/{isbn}")
	public List<BookSearchResponseDto> getAllBooks(@PathVariable String isbn) {

		List<CmsBook> books = null;

		if (isbn != null && isbn.trim().length() > 0) {

			books = ObjectSelect.query(CmsBook.class)
					.where(CmsBook.ISBN.eq(isbn))
					.select(this.objectContext);

		} else {

			books = ObjectSelect.query(CmsBook.class).select(this.objectContext);
		}

		return books.stream()
				.map(book -> {
					var dto = new BookSearchResponseDto();
					dto.setIsbn(book.getIsbn());
					dto.setName(book.getName());
					dto.setCreatedAt(book.getCreatedAt());
					dto.setCreatedBy(book.getCreatedBy());
					dto.setUpdatedAt(book.getUpdatedAt());
					dto.setUpdatedBy(book.getUpdatedBy());

					return dto;
				})
				.collect(Collectors.toList());
	}

	@PostMapping
	public void addBooks(@RequestBody BookDto bookDto) {

		var book = this.objectContext.newObject(CmsBook.class);

		book.setIsbn(bookDto.getIsbn());
		book.setName(bookDto.getName());

		this.objectContext.commitChanges();

	}

}
