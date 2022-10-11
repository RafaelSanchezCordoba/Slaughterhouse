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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regNum;
    @Column(nullable = false)
    private double weight;
    @Column(nullable = false)
    private String origin;
    @Column(nullable = false)
    private Date date;

}
