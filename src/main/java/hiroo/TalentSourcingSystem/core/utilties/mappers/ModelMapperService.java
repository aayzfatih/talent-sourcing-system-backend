package hiroo.TalentSourcingSystem.core.utilties.mappers;


import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
