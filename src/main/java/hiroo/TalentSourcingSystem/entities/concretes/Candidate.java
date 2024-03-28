package hiroo.TalentSourcingSystem.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "Candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private int id;

    @Column(name = "candidate_name")
    private String name;

    @Column(name = "candidate_surname")
    private String surname;

    @Column(name = "candidate_phoneNumber")
    private String phoneNumber;

    @Column(name = "candidate_email")
    private String email;
    @Column(name="candidate_status")
    private int status;

}
