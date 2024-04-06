package com.michaelperes.contentcalender.repository;

import com.michaelperes.contentcalender.model.Content;
import com.michaelperes.contentcalender.model.Status;
import com.michaelperes.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    // Soon we will have a repository that actually talks to a database instead of an in-memory array.
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }


    // Get all content.
    public List<Content> findAll() {
        return content;
    }

    public void addContent(Content c) {
        content.removeIf(cont -> cont.id().equals(c.id()));
        content.add(c);
    }

    // Find a specific content field.
    public Optional<Content> findById(Integer id){
        // Find a specific Content based on ID, using the concept in Java called,
        // Optionals, which we need to understand better.
        // Options may or may not contain a non-null value, is no value is present,
        // object is considered empty and isPresent() is false.
        // Meaning we do not have to deal with nulls all the time, and null pointer exceptions.
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(
            1,
            "My First Model Record",
            "My Description",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        content.add(c);  // Add c content record to the list, as well as this,
        // this construct only happens one when making the repository class, which is a singleton and runs in the memory,
        // so will in effect mean only this record will be in the memory.

    }

    public boolean contentExistsById(Integer id) {
        // return content.stream().anyMatch(c -> c.id().equals(id));
        // We need to make ArrayList a stream to have these functionality, which has mapping etc.
        return content.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void deleteContentById(Integer id) {
        // Delete the content by ID.
        content.removeIf(c -> c.id().equals(id));
    }
}
