package com.example.igonan.Entity;


import lombok.*;

import javax.persistence.*;

import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class testUser {

    @Id
    private String name;
    private String addr;
    private String type;


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getAddr() {return addr;}

    public void setAddr(String addr) {this.addr = addr;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}


}
