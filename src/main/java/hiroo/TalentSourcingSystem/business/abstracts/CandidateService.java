package hiroo.TalentSourcingSystem.business.abstracts;

import hiroo.TalentSourcingSystem.business.requests.CreateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateStatusRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllCandidatesResponse;
import hiroo.TalentSourcingSystem.business.responses.GetCandidateByIdResponse;
import hiroo.TalentSourcingSystem.core.utilities.results.DataResult;
import hiroo.TalentSourcingSystem.core.utilities.results.Result;
import hiroo.TalentSourcingSystem.entities.concretes.Candidate;

public interface CandidateService {
    DataResult<GetAllCandidatesResponse>getAll  (int pageNumber, Candidate.Status status, int pageSize);
    DataResult<GetCandidateByIdResponse>getCandidateById(int id);
    Result add(CreateCandidateRequest createCandidateRequest);
    Result delete(int id);
    DataResult<Candidate> update(int id,UpdateCandidateRequest updateCandidateRequest);
    DataResult<Candidate>updateStatus(int id,UpdateStatusRequest updateStatusRequest);

}
