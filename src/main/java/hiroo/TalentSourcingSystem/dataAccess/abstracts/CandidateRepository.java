package hiroo.TalentSourcingSystem.dataAccess.abstracts;

import hiroo.TalentSourcingSystem.entities.concretes.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
    Page<Candidate>findCandidateByStatus(Candidate.Status status, Pageable pageable);
    boolean existsById(int id);
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}
