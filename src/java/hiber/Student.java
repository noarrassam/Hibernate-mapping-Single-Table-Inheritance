/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiber;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author noorr
 */
@Entity
@DiscriminatorValue(value = "Student")
public class Student extends Person {

    public Student() {

    }

    public Student(String name, String address, String phone, String email) {
        super(name, address, phone, email);
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + getName() + ", address=" + getAddress() + ", phone=" + getPhone() + ", email=" + getEmail() + '}';
    }
}
