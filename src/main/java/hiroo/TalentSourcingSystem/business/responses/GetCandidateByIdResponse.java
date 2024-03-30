package hiroo.TalentSourcingSystem.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCandidateByIdResponse {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String status;
}
