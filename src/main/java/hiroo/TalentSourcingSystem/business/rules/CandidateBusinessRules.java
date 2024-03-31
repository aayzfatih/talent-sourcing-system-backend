package hiroo.TalentSourcingSystem.business.rules;

import hiroo.TalentSourcingSystem.core.utilities.exceptions.BusinessException;
import hiroo.TalentSourcingSystem.dataAccess.abstracts.CandidateRepository;
import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidateBusinessRules {

    private CandidateRepository candidateRepository;
    public void checkIfEmailExists(String email){
        if(this.candidateRepository.existsByEmail(email)){
            throw new BusinessException("Candidate email already exist");
        }
    }
}
