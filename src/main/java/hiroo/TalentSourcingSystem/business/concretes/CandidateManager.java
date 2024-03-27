package hiroo.TalentSourcingSystem.business.concretes;

import hiroo.TalentSourcingSystem.business.abstracts.CandidateService;
import hiroo.TalentSourcingSystem.business.requests.CreateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateCandidateRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllCandidatesResponse;
import hiroo.TalentSourcingSystem.core.utilties.mappers.ModelMapperService;
import hiroo.TalentSourcingSystem.dataAccess.abstracts.CandidateRepository;
import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CandidateManager implements CandidateService {
    private CandidateRepository candidateRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllCandidatesResponse> getAll() {
        List<Candidate>candidates=this.candidateRepository.findAll();
        List<GetAllCandidatesResponse>responses=candidates.stream().map(candidate ->this.modelMapperService.forResponse()
                .map(candidate, GetAllCandidatesResponse.class) ).collect(Collectors.toList());
        return responses;
    }

    @Override
    public void add(CreateCandidateRequest createCandidateRequest) {
        Candidate candidate=this.modelMapperService.forRequest().map(createCandidateRequest,Candidate.class);
        this.candidateRepository.save(candidate);
    }

    @Override
    public void delete(int id) {
        this.candidateRepository.deleteById(id);
    }

    @Override
    public void update(UpdateCandidateRequest updateCandidateRequest) {
        Candidate candidate=this.modelMapperService.forResponse().map(updateCandidateRequest,Candidate.class);
        this.candidateRepository.save(candidate);
    }
}
