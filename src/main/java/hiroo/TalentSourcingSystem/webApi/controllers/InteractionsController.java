package hiroo.TalentSourcingSystem.webApi.controllers;

import hiroo.TalentSourcingSystem.business.abstracts.InteractionService;
import hiroo.TalentSourcingSystem.business.requests.CreateInteractionRequest;
import hiroo.TalentSourcingSystem.business.requests.UpdateInteractionRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllInteractionsResponse;
import hiroo.TalentSourcingSystem.business.responses.GetInteractionByCandidateIdResponse;
import hiroo.TalentSourcingSystem.core.utilities.results.DataResult;
import hiroo.TalentSourcingSystem.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/interactions")
@CrossOrigin
@AllArgsConstructor
public class InteractionsController {
    private InteractionService interactionService;

    @PostMapping()
    public Result add(@RequestBody CreateInteractionRequest createInteractionRequest){
        return this.interactionService.add(createInteractionRequest);
    }

    @GetMapping("/list")
    public DataResult<List<GetAllInteractionsResponse>>getAll(){
        return this.interactionService.getAll();
    }

    @GetMapping("/list/{id}")
    public DataResult<GetInteractionByCandidateIdResponse>getInteractionByCandidateIdResponseDataResult(@PathVariable int id){
        return this.interactionService.getCandidateInteraction(id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.interactionService.delete(id);
    }
    @PutMapping("/{id}")
    public DataResult<UpdateInteractionRequest>update(@PathVariable int id,@RequestBody UpdateInteractionRequest updateInteractionRequest){
        return this.interactionService.update(id,updateInteractionRequest);
    }
}
