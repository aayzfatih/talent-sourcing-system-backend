package hiroo.TalentSourcingSystem.business.abstracts;

import hiroo.TalentSourcingSystem.business.requests.CreateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateCandidateRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllCandidatesResponse;

import java.util.List;

public interface CandidateService {
    List<GetAllCandidatesResponse>getAll();
    void add(CreateCandidateRequest createCandidateRequest);
    void delete(int id);
    void update(UpdateCandidateRequest updateCandidateRequest);
}
