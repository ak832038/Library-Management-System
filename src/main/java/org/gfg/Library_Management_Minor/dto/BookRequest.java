package org.gfg.Library_Management_Minor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.gfg.Library_Management_Minor.model.Author;
import org.gfg.Library_Management_Minor.model.Book;
import org.gfg.Library_Management_Minor.model.BookType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookRequest {

    @NotBlank(message = "Book title cannot be blank")
    private String bookTitle;

    @NotBlank(message = "Book number cannot be blank")
    private String bookNo;

    @NotBlank(message = "Author name cannot be blank")
    private String authorName;

    @NotBlank(message = "Author email cannot be blank")
    private String authorEmail;

    @NotNull(message = "Book type cannot be blank")
    private BookType bookType;

    @NotNull(message = "Security amount cannot be blank")
    private int securityAmount;

    public Author toAuthor() {
        return Author.builder()
                .authorName(this.authorName)
                .authorEmail(this.authorEmail)
                .build();
    }

    public Book toBook() {
        return Book.builder()
                .title(this.bookTitle)
                .bookNo(this.bookNo)
                .bookType(this.bookType)
                .securityAmount(this.securityAmount)
                .build();
    }
}
