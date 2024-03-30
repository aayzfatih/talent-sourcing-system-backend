package hiroo.TalentSourcingSystem.webApi.controllers;

import hiroo.TalentSourcingSystem.business.abstracts.CandidateService;
import hiroo.TalentSourcingSystem.business.requests.CreateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateCandidateRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateStatusRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllCandidatesResponse;
import hiroo.TalentSourcingSystem.business.responses.GetCandidateByIdResponse;
import hiroo.TalentSourcingSystem.core.utilities.results.DataResult;
import hiroo.TalentSourcingSystem.core.utilities.results.Result;
import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/candidates")
@AllArgsConstructor
public class CandidatesController {
    private CandidateService candidateService;
    @GetMapping("/list")
    public  DataResult<GetAllCandidatesResponse> getAllCandidatesResponse(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "") Candidate.Status status){
        return this.candidateService.getAll(page,status,size);
    }
    @GetMapping("/list/{id}")
    public DataResult<GetCandidateByIdResponse> GetCandidateById(@PathVariable int id){
        return this.candidateService.getCandidateById(id);
    }
    @GetMapping("/status")
    public ResponseEntity<Candidate.Status[]>getStatusValues(){
        return ResponseEntity.ok(Candidate.Status.values());
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody CreateCandidateRequest createCandidateRequest){
       return this.candidateService.add(createCandidateRequest);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        return this.candidateService.delete(id);
    }
    @PutMapping("/{id}")
    public DataResult<UpdateCandidateRequest> update(@PathVariable int id,@RequestBody UpdateCandidateRequest updateCandidateRequest ){
      return this.candidateService.update(id,updateCandidateRequest);
    }
    @PutMapping("/update/{id}")
    public DataResult<Candidate> updateStatus(@PathVariable int id,@RequestBody UpdateStatusRequest updateStatusRequest){
       return this.candidateService.updateStatus(id,updateStatusRequest);
    }

}
