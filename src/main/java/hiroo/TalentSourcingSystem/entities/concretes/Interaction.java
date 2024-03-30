package hiroo.TalentSourcingSystem.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "interaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interaction_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Column(name = "content")
    private String content;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "candidate_responded")
    private boolean candidateResponded;

}
