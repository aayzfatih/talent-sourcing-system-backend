package hiroo.TalentSourcingSystem.webApi.controllers;

import hiroo.TalentSourcingSystem.business.abstracts.InteractionService;
import hiroo.TalentSourcingSystem.business.requests.CreateInteractionRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllInteractionsResponse;
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

    @PostMapping("/add")
    public Result add(@RequestBody CreateInteractionRequest createInteractionRequest){
        return this.interactionService.add(createInteractionRequest);
    }

    @GetMapping("/list")
    public DataResult<List<GetAllInteractionsResponse>>getAll(){
        return this.interactionService.getAll();
    }
}
