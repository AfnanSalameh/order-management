package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class CustomerDto {
    private int Id;
    private String firstname;
    private String lastname;

    public CustomerDto(String firstname, String lastname) {
    }

    /*public CustomerDto(int Id) {
        this.Id = Id;
    }*/

    /*public CustomerDto(int Id, String firstname, String lastname) {
        this.Id = Id;
        this.firstname = firstname;
        this.lastname = lastname;
    }*/

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
