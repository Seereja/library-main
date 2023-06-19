package ru.sbercources.library;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import ru.sbercources.library.dto.AuthorDto;
import ru.sbercources.library.model.Author;

public interface AuthorTestData {

  AuthorDto AUTHOR_DTO_1 = new AuthorDto("authorFio1", "birthDate1", "description1", null);
  AuthorDto AUTHOR_DTO_2 = new AuthorDto("authorFio2", "birthDate2", "description2", null);
  AuthorDto AUTHOR_DTO_3 = new AuthorDto("authorFio3", "birthDate3", "description3", new HashSet<>(Arrays.asList(1L, 2L)));

  List<AuthorDto> AUTHOR_DTO_LIST = Arrays.asList(AUTHOR_DTO_1, AUTHOR_DTO_2);

  Author AUTHOR_1 = new Author("authorFio1", "lifePeriod1", "description1", null);
  Author AUTHOR_2 = new Author("authorFio2", "lifePeriod2", "description2", null);

  List<Author> AUTHOR_LIST = Arrays.asList(AUTHOR_1, AUTHOR_2);
}
