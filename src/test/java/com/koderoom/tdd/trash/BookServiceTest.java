package com.koderoom.tdd.trash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    PagesService pagesService;

    @Test
    void test1() {
        String output = bookService.getBookDetails();
        Assertions.assertThat(output).isNotNull().isNotEmpty().isEqualTo("Hello Book Service");
    }

    @Test
    void test2() {
        Mockito.when(pagesService.getPageDetails()).thenReturn("200");
        String output = bookService.getBookPageDetails();
        Assertions.assertThat(output).isEqualTo("Hello 200");
    }
}