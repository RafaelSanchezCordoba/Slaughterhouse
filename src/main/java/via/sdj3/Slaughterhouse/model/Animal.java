package via.sdj3.Slaughterhouse.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


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
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    public int getRegNum() {
        return regNum;
    }

    public double getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    public LocalDate getDate() {
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

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
