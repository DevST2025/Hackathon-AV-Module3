package ra.model;

import ra.util.InputMethods;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void increaseId() {

    }

    public void inputData() {
        //Single Name
        System.out.print("Nhập tên ca sĩ: ");
        this.singerName = InputMethods.getString();

        //Age
        while (true) {
            System.out.print("Nhập tuổi ca sĩ: ");
            this.age = InputMethods.getInteger();
            if (this.age > 0) {
                break;
            } else {
                System.err.println("Tuổi phải lớn hơn 0");
            }
        }

        //Nationality
        System.out.print("Nhập quốc tịch: ");
        this.nationality = InputMethods.getString();

        //Gender
        boolean isExist = true;
        System.out.println("Chọn giới tính: ");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.print("Giới tính: ");
        do {
            int choise = InputMethods.getInteger();
            switch (choise) {
                case 1:
                    this.gender = true;
                    isExist = false;
                    break;
                case 2:
                    this.gender = false;
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 2 option trên");
            }
        } while (isExist);

        //Genre
        System.out.print("Nhập thể loại: ");
        this.genre = InputMethods.getString();
    }
    public void displayData() {
        System.out.println("Mã: "+singerId + " | Tên: "+ singerName);
        System.out.println("Tuổi: "+age + " | Quốc tịch: "+ nationality);
        System.out.println("Giới tính: "+ (gender?"Nam":"Nữ") + " | Thế loại nhạc: " +genre);
    }
}
