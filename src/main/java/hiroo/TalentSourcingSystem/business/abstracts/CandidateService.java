package hiroo.TalentSourcingSystem.business.abstracts;

import hiroo.TalentSourcingSystem.business.requests.CreateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateStatusRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllCandidatesResponse;

import java.util.List;

public interface CandidateService {
    List<GetAllCandidatesResponse>getAll();
    void add(CreateCandidateRequest createCandidateRequest);
    void delete(int id);
    void update(int id,UpdateCandidateRequest updateCandidateRequest);
    void updateStatus(int id,UpdateStatusRequest updateStatusRequest);

}
