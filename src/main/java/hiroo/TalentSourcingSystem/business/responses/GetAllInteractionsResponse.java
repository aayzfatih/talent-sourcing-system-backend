package hiroo.TalentSourcingSystem.business.responses;

import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInteractionsResponse {
    private int id;
    private String content;
    private LocalDateTime time;
    private boolean candidateResponded;
    private String candidateName;
    private int candidateId;
    private Candidate.Status candidateStatus;
}
