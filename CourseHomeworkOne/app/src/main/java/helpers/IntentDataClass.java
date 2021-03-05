package helpers;

import android.os.Parcel;
import android.os.Parcelable;

public class IntentDataClass implements Parcelable {
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;
    private String email;

    public IntentDataClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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

    protected IntentDataClass(Parcel in) {
        name = in.readString();
        surname = in.readString();
        patronymic = in.readString();
        dateOfBirth = in.readString();
        email = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(patronymic);
        dest.writeString(dateOfBirth);
        dest.writeString(email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<IntentDataClass> CREATOR = new Creator<IntentDataClass>() {
        @Override
        public IntentDataClass createFromParcel(Parcel in) {
            return new IntentDataClass(in);
        }

        @Override
        public IntentDataClass[] newArray(int size) {
            return new IntentDataClass[size];
        }
    };


}
