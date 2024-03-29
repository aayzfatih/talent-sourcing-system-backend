package hiroo.TalentSourcingSystem.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCandidatesResponse {
    private List<CandidateDto>content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;


}
