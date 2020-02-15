package com.example.myKitchenManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Data;
//import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name="members")
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="member_id")
    private int userId;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "member_id", nullable = true, updatable = false, insertable = false)
//    protected Ingredient userIdInventory;

    @Column(name="singup_date")
    private java.sql.Timestamp signupDate;

    private String password;

    private Character gender;

    @Column(name="is_Vegetarian")
    private boolean isVegetarian;

    @Column(name="is_vegan")
    private boolean isVegan;

    @Column(name="is_lactose_intolerant")
    private boolean isLactoseIntolerant;

    @Column(name="is_gluten_free")
    private boolean isGlutenFree;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="nationality")
    private int nationality;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="nationality", nullable = true, updatable = false, insertable = false)
    private ListEntry nationalityListEntry;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="user_name", unique = true)
    private String userName;

    @OneToMany(mappedBy="userIdJoin", cascade = CascadeType.ALL)
    private List<Inventory> InventoryList;

    @OneToMany(mappedBy="userIdJoin", cascade = CascadeType.ALL)
    private List<MealPlan> MealPlanList;

    @OneToMany(mappedBy="contributorIdJoin", cascade = CascadeType.ALL)
    private List<Recipe> RecipeList;

    public Users() {

    }

    public List<MealPlan> getMealPlanList() {
        return MealPlanList;
    }

    public List<Inventory> getInventoryList() {
        return InventoryList;
    }

    public List<Recipe> getRecipeList(){ return RecipeList; }

    public Users(Timestamp signupDate, String password, Character gender, boolean isVegetarian, boolean isVegan, boolean isLactoseIntolerant, boolean isGlutenFree, String emailAddress, int nationality, String firstName, String lastName, String userName) {
        this.signupDate = signupDate;
        this.password = password;
        this.gender = gender;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isLactoseIntolerant = isLactoseIntolerant;
        this.isGlutenFree = isGlutenFree;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getSignupDate() {
        return signupDate;
    }

    public String getPassword() {
        return password;
    }

    public Character getGender() {
        return gender;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public boolean isLactoseIntolerant() {
        return isLactoseIntolerant;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getNationality() {
        return nationality;
    }

    public ListEntry getNationalityListEntry() {
        return nationalityListEntry;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setMemberId(int memberId) {
        this.userId = memberId;
    }

    public void setSignupDate(Timestamp signupDate) {
        this.signupDate = signupDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public void setLactoseIntolerant(boolean lactoseIntolerant) {
        isLactoseIntolerant = lactoseIntolerant;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setNationalityId(int nationality) {
        this.nationality = nationality;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
