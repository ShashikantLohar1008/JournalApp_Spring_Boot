package net.shashikantlohar.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.shashikantlohar.journalApp.entity.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
