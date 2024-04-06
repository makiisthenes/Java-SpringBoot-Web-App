package com.michaelperes.contentcalender.model;


// This will define models of our rest server, and for a quick recap on what a record is we will look into the YouTube video shown below,

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Content (
    Integer id,  // must have title, not null or empty or string, collection, array etc..
    @NotEmpty
    @NotBlank  // must have at least a character not just whitespace.
    String title,
    @NotEmpty
    String desc,
    Status status,
    Type contentType,  // Article, Video, Etc.
    LocalDateTime dateCreated,
    @FutureOrPresent
    LocalDateTime dateUpdated,
    String url

) { };
