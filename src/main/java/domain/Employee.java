package domain;

import javafx.util.converter.LocalDateTimeStringConverter;

import java.util.Date;

public class Employee    {
    private int id;
    private String lastName;
    private String firstName;
    private String title;
    private Date birthDay;

    public Employee(int id, String lastName, String firstName, String title, Date birthDay) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.birthDay = birthDay;
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public int getAge(Date date){
        return  util.Utility.getAge(date);
    }
    public int getAge(){
        return getAge(this.birthDay);
    }

    @Override
    public String toString() {
        return "(ID)"+id +"/(Name)"+lastName+", "+firstName
                + "/(Birthday)"+util.Utility.dateFormat(birthDay)+ "/(Title)"+title
                +"/(Age)"+ getAge(birthDay);

    }
}
