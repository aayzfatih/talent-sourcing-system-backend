package hiroo.TalentSourcingSystem.business.abstracts;

import hiroo.TalentSourcingSystem.business.requests.CreateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateStatusRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllCandidatesResponse;
import hiroo.TalentSourcingSystem.core.utilities.results.DataResult;

import java.util.List;

public interface CandidateService {
    DataResult<List<GetAllCandidatesResponse>> getAll(int pageNumber,int pageSize);
    void add(CreateCandidateRequest createCandidateRequest);
    void delete(int id);
    void update(int id,UpdateCandidateRequest updateCandidateRequest);
    void updateStatus(int id,UpdateStatusRequest updateStatusRequest);

}
