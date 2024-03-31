package hiroo.TalentSourcingSystem.business.rules;

import hiroo.TalentSourcingSystem.core.utilities.exceptions.BusinessException;
import hiroo.TalentSourcingSystem.core.utilities.exceptions.NotFoundException;
import hiroo.TalentSourcingSystem.dataAccess.abstracts.InteractionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InteractionBusinessRules {
    private InteractionRepository interactionRepository;
    public void checkIfCandidateIdExist(int id){
        if(!this.interactionRepository.existsByCandidateId(id)){
            throw new NotFoundException("There is no interaction.You need to add interaction");
        }
    }
}
