package hiroo.TalentSourcingSystem.dataAccess.abstracts;

import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {

}
