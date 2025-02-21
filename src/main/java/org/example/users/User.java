package org.example.users;

public class User {

    private String date_birth;
    private String date_of_writing_the_first_message;
    private int etap;
    //private Long date_of_writing_the_first_message = 0L; // дата рождения
 //   private Long partner_date_of_birth = 0L; // дата рождения его





    {
        this.etap = 0;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
        etap = 1;
    }

    public int getEtap() {
        return etap;
    }

    public void setEtap(int etap) {
        this.etap = etap;
    }

    public void restart_etap() {
        etap = Users.ETAP_NOTH_DATE;
        date_birth = null;
    }

    public String getDate_of_writing_the_first_message() {
        return date_of_writing_the_first_message;
    }

    public void setDate_of_writing_the_first_message(String date_of_writing_the_first_message) {
        this.date_of_writing_the_first_message = date_of_writing_the_first_message;
    }

    @Override
    public String toString() {
        return "org.example.users.User{" +
                "date_birth='" + getDate_birth() + '\'' +
                ", date_of_writing_the_first_message='" + getDate_of_writing_the_first_message() + '\'' +
                ", etap=" + getEtap() +
                '}';
    }
}
