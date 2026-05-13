package net.shashikantlohar.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.shashikantlohar.journalApp.entity.ConfigJournalAppEntity;
import net.shashikantlohar.journalApp.entity.User;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}
