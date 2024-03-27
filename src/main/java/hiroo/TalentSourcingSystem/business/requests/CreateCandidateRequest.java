package hiroo.TalentSourcingSystem.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateRequest {
    private String name;
    private String surname;
    private int phoneNumber;
    private String email;
    private int status;
}
