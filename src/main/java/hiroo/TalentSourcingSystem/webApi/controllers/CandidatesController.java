package hiroo.TalentSourcingSystem.webApi.controllers;

import hiroo.TalentSourcingSystem.business.abstracts.CandidateService;
import hiroo.TalentSourcingSystem.business.requests.CreateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateCandidateRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllCandidatesResponse;
import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/candidates")
@AllArgsConstructor
public class CandidatesController {
    private CandidateService candidateService;
    @GetMapping()
    public List<GetAllCandidatesResponse>getAllCandidatesResponses(){
        return this.candidateService.getAll();
    }
    @GetMapping("/status")
    public ResponseEntity<Candidate.Status[]>getStatusValues(){
        return ResponseEntity.ok(Candidate.Status.values());
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateCandidateRequest createCandidateRequest){
        this.candidateService.add(createCandidateRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.candidateService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody UpdateCandidateRequest updateCandidateRequest){
        this.candidateService.update(updateCandidateRequest);
    }
}
