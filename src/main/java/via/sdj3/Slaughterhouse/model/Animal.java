package via.sdj3.Slaughterhouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int regNum;
    @Column(nullable = false)
    private double weight;
    @Column(nullable = false)
    private String origin;
    @Column(nullable = false)
    private Date date;

    public int getRegNum() {
        return regNum;
    }

    public double getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    public Date getDate() {
        return date;
    }

    public void setRegNum(int regNum) {
        this.regNum = regNum;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
