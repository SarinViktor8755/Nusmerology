package org.example.users;

public class User {

    private String date_birth;
    private int etap;
    private Long date_of_writing_the_first_message = 0L;


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
        this.etap = 0;
        date_birth = null;
    }

    @Override
    public String toString() {
        return  "DB='" + getDate_birth() + ", etap=" + getEtap() + ", first_message=" + date_of_writing_the_first_message;
    }
}
