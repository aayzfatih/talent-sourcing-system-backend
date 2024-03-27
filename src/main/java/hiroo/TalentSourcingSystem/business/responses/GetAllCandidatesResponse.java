package hiroo.TalentSourcingSystem.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCandidatesResponse {
    private int id;
    private String name;
    private String surname;
    private int phoneNumber;
    private String email;
    private int status;

}
