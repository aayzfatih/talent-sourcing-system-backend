package hiroo.TalentSourcingSystem.business.concretes;

import hiroo.TalentSourcingSystem.business.abstracts.InteractionService;
import hiroo.TalentSourcingSystem.business.requests.CreateInteractionRequest;
import hiroo.TalentSourcingSystem.business.responses.GetAllInteractionsResponse;
import hiroo.TalentSourcingSystem.business.responses.GetInteractionByCandidateIdResponse;
import hiroo.TalentSourcingSystem.core.utilities.mappers.ModelMapperService;
import hiroo.TalentSourcingSystem.core.utilities.results.DataResult;
import hiroo.TalentSourcingSystem.core.utilities.results.Result;
import hiroo.TalentSourcingSystem.core.utilities.results.SuccessDataResult;
import hiroo.TalentSourcingSystem.core.utilities.results.SuccessResult;
import hiroo.TalentSourcingSystem.dataAccess.abstracts.InteractionRepository;
import hiroo.TalentSourcingSystem.entities.concretes.Interaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InteractionManager implements InteractionService {
    private InteractionRepository interactionRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result add(CreateInteractionRequest createInteractionRequest) {
        Interaction interaction=this.modelMapperService.forRequest().map(createInteractionRequest,Interaction.class);
        this.interactionRepository.save(interaction);
        return new SuccessResult("Interaction added");
    }

    @Override
    public DataResult<List<GetAllInteractionsResponse>> getAll() {
        List<Interaction>interactions=this.interactionRepository.findAll();
        List<GetAllInteractionsResponse>responses=interactions.stream()
                .map(interaction -> this.modelMapperService.forResponse().map(interaction, GetAllInteractionsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(responses,"All interaction listed");
    }

}
