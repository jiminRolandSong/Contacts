package contacts;

import java.time.LocalDateTime;

public class Person extends Phone {
    private String surname;
    private String birthDate;
    private String gender;


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public void show(){
        System.out.println(
           "Name: " + super.getName() +"\n" +
                   "Surname: " + this.getSurname() + "\n" +
                   "Birth date: " + this.getBirthDate() + "\n" +
                   "Gender: " + this.gender + "\n" +
                   "Number: " + super.getNumber() +"\n" +
                   "Time created: " + this.getInitial() + "\n" +
                   "Time last edit: " + this.getLastEdit()
        );
    }
    @Override
    public String getFull(){
        return super.getName() + " " + this.getSurname();
    }

    public String regexTool() {
        return (
                super.getName() +"\n" +
                        this.getSurname() + "\n" +
                        this.getBirthDate() + "\n" +
                        this.gender + "\n" +
                        super.getNumber() +"\n" +
                        this.getInitial() + "\n" +
                        this.getLastEdit()
        );
    }
}
