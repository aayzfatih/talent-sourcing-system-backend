package hiroo.TalentSourcingSystem.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInteractionByCandidateIdResponse {
    private int id;
    private String content;
    private LocalDateTime time;
    private boolean candidateResponded;
    private String candidateName;
    private String candidateSurname;

    private String candidateStatus;

}
