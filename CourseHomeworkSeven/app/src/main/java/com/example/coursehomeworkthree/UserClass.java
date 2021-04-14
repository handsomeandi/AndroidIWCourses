package com.example.coursehomeworkthree;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserClass implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public long id;

    private String img_url;
    private String username;
    private String dateOfBirth;
    private String email;


    public UserClass() {
    }

    public UserClass(String img_url, String username, String dateOfBirth, String email) {
        this.img_url = img_url;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    protected UserClass(Parcel in) {
        img_url = in.readString();
        username = in.readString();
        dateOfBirth = in.readString();
        email = in.readString();
    }

    public static final Creator<UserClass> CREATOR = new Creator<UserClass>() {
        @Override
        public UserClass createFromParcel(Parcel in) {
            return new UserClass(in);
        }

        @Override
        public UserClass[] newArray(int size) {
            return new UserClass[size];
        }
    };

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(img_url);
        dest.writeString(username);
        dest.writeString(dateOfBirth);
        dest.writeString(email);
    }
}
