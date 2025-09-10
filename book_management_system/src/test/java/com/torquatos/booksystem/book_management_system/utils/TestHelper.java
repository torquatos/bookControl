package com.torquatos.booksystem.book_management_system.utils;

import com.torquatos.booksystem.book_management_system.entity.Book;

import java.util.Random;
import java.util.UUID;

import static java.lang.String.format;

public class TestHelper {
    public static Book buildBook() {
        String uuid = UUID.randomUUID().toString();
        return new Book (
        	"Name-" + uuid,
        	"Author-" + uuid,
        	"Genre-" + uuid,
        	"Publisher-" + uuid,
        	2025,
        	"Summary-" + uuid,
        	0.0,
        	"PersonalNotes-" + uuid
        	);
        	
       
    }

    public static Book buildBookWithId() {
        Random random = new Random();
        String uuid = UUID.randomUUID().toString();
        
        Book book = new Book (
            	"Name-" + uuid,
            	"Author-" + uuid,
            	"Genre-" + uuid,
            	"Publisher-" + uuid,
            	2025,
            	"Summary-" + uuid,
            	0.0,
            	"PersonalNotes-" + uuid
            	);
        
        book.setId(random.nextLong());
        return book;


    }
}
