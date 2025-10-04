package org.gfg.Library_Management_Minor.service;

import org.gfg.Library_Management_Minor.model.Author;
import org.gfg.Library_Management_Minor.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthorData(String authorEmail) {
        return authorRepository.getAuthorByEmail(authorEmail);
    }
}
