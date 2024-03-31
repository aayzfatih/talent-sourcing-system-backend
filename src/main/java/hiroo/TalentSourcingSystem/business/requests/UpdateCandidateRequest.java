package hiroo.TalentSourcingSystem.business.requests;

import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCandidateRequest {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private Candidate.Status status;
}
