package myy803.springboot.OnlineBookStore.forms;

import java.util.List;

public class UserProfileFormData {
    private String fullName;
    private String address;
    private int age;
    private String phoneNumber;
    private List<String> favoriteCategories;
    private List<String> favoriteAuthors;

    
    // Getters and setters
    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getPreferredBookCategories() {
        return favoriteCategories;
    }

    public void setPreferredBookCategories(List<String> favoriteCategories) {
        this.favoriteCategories = favoriteCategories;
    }

    public List<String> getFavoriteAuthors() {
        return favoriteAuthors;
    }

    public void setFavoriteAuthors(List<String> favoriteAuthors) {
        this.favoriteAuthors = favoriteAuthors;
    }

}
