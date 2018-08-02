package com.bridgefy.samples.twitter.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.bridgefy.samples.twitter.entities.Chat;
import com.bridgefy.samples.twitter.entities.User;

import java.util.List;

@Dao
public interface ChatDao {

    @Query("SELECT * FROM chat")
    List<User> getAll();

    @Query("SELECT * FROM chat where FROMUUID LIKE  :FROMUUID ")
    User findByName(String FROMUUID);

    @Query("SELECT COUNT(*) from chat")
    int countUsers();

    @Insert
    void insertAll(Chat... chats);

    @Delete
    void delete(Chat chat);
}