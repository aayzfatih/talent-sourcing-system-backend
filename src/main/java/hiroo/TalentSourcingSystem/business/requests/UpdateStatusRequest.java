package hiroo.TalentSourcingSystem.business.requests;

import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SecondaryRow;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusRequest {
    private Candidate.Status status;
}
