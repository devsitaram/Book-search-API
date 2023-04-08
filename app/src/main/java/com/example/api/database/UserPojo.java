package com.example.api.database;

public class UserPojo {
    @PrimaryKey
    @ColumnInfo(name="user_id")
    public int studentId;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "address")
    public String address;
    @ColumnInfo(name = "phone")
    public String phone;
}
