package hiroo.TalentSourcingSystem.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInteractionRequest {
    @NotNull
    @NotBlank
    private String content;
    @NotNull
    @NotBlank
    private LocalDateTime time;
    @NotNull
    @NotBlank
    private boolean candidateResponded;
    @NotNull
    @NotBlank
    private int candidateId;


}
