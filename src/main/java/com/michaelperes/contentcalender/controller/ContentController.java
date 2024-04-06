package com.michaelperes.contentcalender.controller;


import com.michaelperes.contentcalender.model.Content;
import com.michaelperes.contentcalender.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


// This is in essence a class similar to views.py in Django for accepting requests for a specific url mentioned in the decorator.


// Usually a controller is controlling some sort of model, and in our case we are controlling model record content.
@RestController  // I want you to make a Controller for me in the Application Context.
@RequestMapping(value = "/api/content")
@CrossOrigin
public class ContentController {
    // All crud methods will be here.

    // Dependency Injection. Shown in this video, https://www.youtube.com/watch?v=TBlB2_4_Sqo, but not given.
    private final ContentCollectionRepository repository;

    @Autowired  // As you can see this constructor wants to use a repository argument.
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    // Make a request and find the contents in the system.

    // method = RequestMethod.GET
    @GetMapping("")  // Basically class request mapping + this mapping, specific to GetMapping.
    public List<Content> findAll() {
        return this.repository.findAll();
    }

    // CRUD Operation, or filtering or paging or sorting, this can be done here, but in essence we are at the specific
    // views.py handler for that specific part of url, only concerns is the idea that URL paths are not centralised causing confusion possible.

    @GetMapping("/{id}")
    public Content getSpecificContentById(@PathVariable Integer id){
        // How to we map the decorator GetMapping to the argument of the function, and that is with the @PathVariable.

        // But of course this specific content can be not found as it is an optional, so we can throw not found,
        // In this case, then we need to do something instead of simply returning, this.repository.findById(id);

        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!"));
    }


    // Create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create/")
    public void createContent(@Valid @RequestBody Content content){
        // Take the post body data and create content. But how is a Content object created from a request?!?!?
        // Answer handles with declaration, @RequestBody.
        this.repository.addContent(content);
    }

    // Update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}/update/")
    public void updateContent(@PathVariable Integer id, @RequestBody Content content){
        if (!this.repository.contentExistsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!");
        }
        this.repository.addContent(content);
    }


    // Delete
    // @ResponseStatus(HttpStatus.OK)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}/delete/")
    public void deleteContent(@PathVariable Integer id){
        // We delete the content from repository.
        if (!this.repository.contentExistsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!");
        }
        this.repository.deleteContentById(id);
    }
}
