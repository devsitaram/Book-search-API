package com.example.api.database;


import com.example.api.books.helper.BooksPojo;

import java.util.List;

import retrofit2.http.Query;

@Dao
public class BooksDao {

    Completable insertAll(List<BooksPojo> booksPojo);

    @Query("Select * From student")
    Single<List<BooksPojo>> getAllStudent();

    @Query("Select * from student where student_id in (:studentId)")
    Single<List<BooksPojo>> getStudentId(String[] studentId);

    @Query("Select * From student Where student_name Like :name AND student_address Like :address")
    Single<List<BooksPojo>> getAllName(String name, String address);

    @Update
    Completable updateStudent(BooksPojo booksPojo);

    @Delete
    Completable deleteStudent(BooksPojo booksPojo);
}