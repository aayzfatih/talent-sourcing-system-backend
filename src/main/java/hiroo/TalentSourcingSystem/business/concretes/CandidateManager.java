package hiroo.TalentSourcingSystem.business.concretes;

import hiroo.TalentSourcingSystem.business.abstracts.CandidateService;
import hiroo.TalentSourcingSystem.business.requests.CreateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateStatusRequest;
import hiroo.TalentSourcingSystem.business.responses.CandidateDto;
import hiroo.TalentSourcingSystem.business.responses.GetAllCandidatesResponse;
import hiroo.TalentSourcingSystem.business.responses.GetCandidateByIdResponse;
import hiroo.TalentSourcingSystem.core.utilities.mappers.ModelMapperService;
import hiroo.TalentSourcingSystem.core.utilities.results.*;
import hiroo.TalentSourcingSystem.dataAccess.abstracts.CandidateRepository;
import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CandidateManager implements CandidateService {
    private CandidateRepository candidateRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<GetAllCandidatesResponse>getAll (int pageNumber, Candidate.Status status, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Candidate>candidates;
        if(status!=null){
            candidates=candidateRepository.findCandidateByStatus(status,pageable);
        }else{
            candidates=candidateRepository.findAll(pageable);
        }
        List<Candidate> listOfCandidates = candidates.getContent();
        List<CandidateDto> response = listOfCandidates.stream()
                .map(candidate -> modelMapperService.forResponse().map(candidate, CandidateDto.class))
                .collect(Collectors.toList());
        GetAllCandidatesResponse responses=new GetAllCandidatesResponse();
        responses.setContent(response);
        responses.setPageNo(candidates.getNumber());
        responses.setPageSize(candidates.getSize());
        responses.setTotalElements(candidates.getTotalElements());
        responses.setTotalPages(candidates.getTotalPages());
        responses.setLast(candidates.isLast());

        return new SuccessDataResult<GetAllCandidatesResponse>(responses,"Get all candidates");
    }

    @Override
    public DataResult<GetCandidateByIdResponse> getCandidateById(int id) {
        if(this.candidateRepository.existsById(id)){
            Candidate candidate=candidateRepository.findById(id).orElseThrow();
            GetCandidateByIdResponse response=this.modelMapperService.forResponse().map(candidate,GetCandidateByIdResponse.class);
            return new SuccessDataResult<GetCandidateByIdResponse>(response,"Candidate of ID:"+candidate.getId());
        }
        else {
            return new ErrorDataResult<>(null,"No candidates with ID:"+id+" were found");
        }

    }

    @Override
    public Result add(CreateCandidateRequest createCandidateRequest) {
        Candidate candidate=this.modelMapperService.forRequest().map(createCandidateRequest,Candidate.class);
        this.candidateRepository.save(candidate);
        return new SuccessResult("Candidate added");
    }

    @Override
    public Result delete(int id) {
        this.candidateRepository.deleteById(id);
        return new SuccessResult("Candidate deleted");
    }

    @Override
    public DataResult<Candidate> update(int id,UpdateCandidateRequest updateCandidateRequest) {
        Candidate candidate=this.candidateRepository.findById(id).orElseThrow();
        candidate.setName(updateCandidateRequest.getName());
        candidate.setSurname(updateCandidateRequest.getSurname());
        candidate.setEmail(updateCandidateRequest.getEmail());
        candidate.setPhoneNumber(updateCandidateRequest.getPhoneNumber());
        candidate.setStatus(updateCandidateRequest.getStatus());
        this.candidateRepository.save(candidate);
        return new SuccessDataResult<Candidate>(candidate,"The candidate with ID "+candidate.getId()+" has been updated");
    }

    @Override
    public DataResult<Candidate> updateStatus(int id, UpdateStatusRequest updateStatusRequest) {
        Candidate candidate=this.candidateRepository.findById(id).orElseThrow();
        candidate.setStatus(updateStatusRequest.getStatus());
        this.candidateRepository.save(candidate);
        return new SuccessDataResult<Candidate>(candidate,"The status of the candidate with ID "+candidate.getId()+" has been updated");
    }


}
