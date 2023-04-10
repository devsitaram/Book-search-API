package com.example.api.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import com.example.api.books.Book;

import java.util.List;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Query;

@SuppressWarnings("AndroidUnresolvedRoomSqlReference")
@androidx.room.Dao
public interface BookDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    public Completable insertAllBook(List<Book> bookList);

//    @Query(value = "Select * From book")
//    Single<List<Book>> getAllBooks();
//
//    @Query("Select * from post where user_id in (:id)")
//    Single<List<UserPojo>> getPostId(String[] id);
//
//    @Query("Select * From post Where user_id Like :Id AND user_name Like :name AND user_email Like :email AND user_phoneNo Like :phoneNo")
//    Single<List<UserPojo>> getUserDetails(int id, String name, String email, String address, String phoneNo);

    @Update
    Completable updateUser(PostPojo postPojo);

    @Delete
    Completable deleteUser(PostPojo postPojo);
}