package myy803.springboot.OnlineBookStore.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;


@Entity
@Table(name="usersprofile")
public class UserProfile{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_name", unique=true)
    private String username;

    @Column(name="full_name")
    private String fullName;

    @Column(name="address")
    private String address;

    @Column(name="age")
    private int age;

    @Column(name="phone_number")
    private String phoneNumber;

    /*@Column(name="favouriteBookAuthors")
    private List<BookAuthor> favouriteBookAuthors;

    @Column(name="favouriteBookCategories")
    private List<BookCategory> favouriteBookCategories;*/

    //@Column(name="bookOffers")
   // private List<Book> bookOffers;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;




    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public int getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }



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

    /*public List<BookCategory> getPreferredBookCategories() {
        return favouriteBookCategories;
    }

    public void setPreferredBookCategories(List<BookCategory> favouriteBookCategories) {
        this.favouriteBookCategories = favouriteBookCategories;
    }

    public List<BookAuthor> getFavoriteAuthors() {
        return favouriteBookAuthors;
    }

    public void setFavoriteAuthors(List<BookAuthor> favouriteBookAuthors) {
        this.favouriteBookAuthors = favouriteBookAuthors;
    }*/

   /* @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/
}
