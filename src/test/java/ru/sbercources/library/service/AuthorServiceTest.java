package ru.sbercources.library.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.sbercources.library.AuthorTestData;
import ru.sbercources.library.dto.AuthorDto;
import ru.sbercources.library.mapper.AuthorMapper;
import ru.sbercources.library.model.Author;
import ru.sbercources.library.repository.AuthorRepository;
import ru.sbercources.library.repository.BookRepository;
import ru.sbercources.library.repository.PublishRepository;
import ru.sbercources.library.service.userDetails.CustomUserDetails;

class AuthorServiceTest {

  private GenericService<Author> authorService;

  private final AuthorRepository authorRepository = Mockito.mock(AuthorRepository.class);
  private final BookService bookService = Mockito.mock(BookService.class);
  private final BookRepository bookRepository = Mockito.mock(BookRepository.class);
  private final PublishRepository publishRepository = Mockito.mock(PublishRepository.class);

  @BeforeEach
  void init() {
    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(CustomUserDetails.builder().username("USER"), null, null);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    authorService = new AuthorService(authorRepository, bookRepository, bookService, publishRepository);
  }

  @Test
  void getAll() {
    Mockito.when(authorRepository.findAll()).thenReturn(AuthorTestData.AUTHOR_LIST);
    List<Author> authors = authorService.listAll();

    assertEquals(AuthorTestData.AUTHOR_LIST.size(), authors.size());
  }

  @Test
  void getOne() {
    Mockito.when(authorRepository.findById(1L)).thenReturn(Optional.of(AuthorTestData.AUTHOR_1));
    Author author = authorService.getOne(1L);

    assertEquals(AuthorTestData.AUTHOR_1, author);
  }

  @Test
  void create() {
    Mockito.when(authorRepository.save(AuthorTestData.AUTHOR_1)).thenReturn(AuthorTestData.AUTHOR_1);
    Author author = authorService.create(AuthorTestData.AUTHOR_1);

    assertEquals(AuthorTestData.AUTHOR_1, author);
  }

  @Test
  void update() {
    Mockito.when(authorRepository.save(AuthorTestData.AUTHOR_1)).thenReturn(AuthorTestData.AUTHOR_1);
    Author author = authorService.update(AuthorTestData.AUTHOR_1);

    assertEquals(AuthorTestData.AUTHOR_1, author);
  }
}
