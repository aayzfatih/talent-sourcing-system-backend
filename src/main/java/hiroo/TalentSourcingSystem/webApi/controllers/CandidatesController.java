package hiroo.TalentSourcingSystem.webApi.controllers;

import hiroo.TalentSourcingSystem.business.abstracts.CandidateService;
import hiroo.TalentSourcingSystem.business.requests.CreateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateStatusRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllCandidatesResponse;
import hiroo.TalentSourcingSystem.core.utilities.results.DataResult;
import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/candidates")
@AllArgsConstructor
public class CandidatesController {
    private CandidateService candidateService;
    @GetMapping()
    public DataResult<List<GetAllCandidatesResponse>> getAllCandidatesResponses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return this.candidateService.getAll(page,size);
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
    @PutMapping("/{id}")
    public void update(@PathVariable int id,@RequestBody UpdateCandidateRequest updateCandidateRequest ){
        this.candidateService.update(id,updateCandidateRequest);
    }
    @PutMapping("/update/{id}")
    public void updateStatus(@PathVariable int id,@RequestBody UpdateStatusRequest updateStatusRequest){
        this.candidateService.updateStatus(id,updateStatusRequest);
    }

}
