package hiber;
// Generated 20-Apr-2021 2:18:11 PM by Hibernate Tools 4.3.1

import java.beans.Transient;
import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Person generated by hbm2java
 */
@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSON_TYPE", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String person_type;

    public String getPerson_type() {
        return person_type;
    }

    @Transient
    public String getDiscrimativeTYpe() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }

    public Person() {
        System.out.println("person data 2 " + name + address + phone + email);
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(String name, String address, String phone, String email) {
        System.out.println("person data" + name + address + phone + email);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", email=" + email + ", person_type=" + person_type + '}';
    }
}
