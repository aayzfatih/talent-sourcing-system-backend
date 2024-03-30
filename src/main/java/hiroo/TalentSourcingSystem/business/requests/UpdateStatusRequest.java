package hiroo.TalentSourcingSystem.business.requests;

import hiroo.TalentSourcingSystem.core.utilities.results.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusRequest {
    private Candidate.Status status;
}
