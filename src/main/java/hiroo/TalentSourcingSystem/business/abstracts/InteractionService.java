package hiroo.TalentSourcingSystem.business.abstracts;

import hiroo.TalentSourcingSystem.business.requests.CreateInteractionRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllInteractionsResponse;
import hiroo.TalentSourcingSystem.business.responses.GetInteractionByCandidateIdResponse;
import hiroo.TalentSourcingSystem.core.utilities.results.DataResult;
import hiroo.TalentSourcingSystem.core.utilities.results.Result;

import java.util.List;

public interface InteractionService {
    Result add(CreateInteractionRequest createInteractionRequest);
    DataResult<List<GetAllInteractionsResponse>>getAll();

}
