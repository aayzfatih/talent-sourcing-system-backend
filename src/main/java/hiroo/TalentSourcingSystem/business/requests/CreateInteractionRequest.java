package hiroo.TalentSourcingSystem.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInteractionRequest {
    private String content;
    private LocalDateTime time;
    private boolean candidateResponded;
    private int candidateId;


}
