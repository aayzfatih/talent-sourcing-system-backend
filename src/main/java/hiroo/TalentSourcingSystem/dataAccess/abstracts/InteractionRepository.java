package hiroo.TalentSourcingSystem.dataAccess.abstracts;

import hiroo.TalentSourcingSystem.entities.concretes.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction,Integer> {
    Interaction findByCandidateId(int candidateId);
}
