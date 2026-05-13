package net.shashikantlohar.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.shashikantlohar.journalApp.entity.JournalEntry;
import net.shashikantlohar.journalApp.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);

    void deleteByUserName(String username);
}
