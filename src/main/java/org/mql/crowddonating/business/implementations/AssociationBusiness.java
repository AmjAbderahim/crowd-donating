package org.mql.crowddonating.business.implementations;

import org.mql.crowddonating.business.IAssociationBusiness;
import org.mql.crowddonating.dao.CaseRepository;
import org.mql.crowddonating.dao.EventRepository;
import org.mql.crowddonating.dao.TypeRepository;
import org.mql.crowddonating.models.*;
import org.mql.crowddonating.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AssociationBusiness extends UserBusiness implements IAssociationBusiness {

    @Autowired
    private CaseRepository caseDao;

    @Autowired
    private TypeRepository typeDao;

    @Autowired
    private EventRepository eventDao;

    public Case addCase(Case aCase) {
        aCase.setName(Utility.cleanupSpaces(aCase.getName()));
        aCase.setDescription(Utility.cleanupSpaces(aCase.getDescription()));
        aCase.setSlug(Utility.toSlug(aCase.getName()));
        return caseDao.save(aCase);
    }

    public Case updateCase(Case aCase) {
        aCase.setName(Utility.cleanupSpaces(aCase.getName()));
        aCase.setDescription(Utility.cleanupSpaces(aCase.getDescription()));
        return caseDao.save(aCase);
    }

    public void deleteCase(long id) {
        caseDao.deleteById(id);
    }

    public Type addType(Type type) {
        return typeDao.save(type);
    }

    public Type findTypeByLabel(String label) {
        return typeDao.findByLabel(label);
    }

    @Override
    public List<Donation> getDonationByCase(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Donor> getDonorByCase(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Event addEvent(Event event) {
        event.setTitle(Utility.cleanupSpaces(event.getTitle()));
        event.setDescription(Utility.cleanupSpaces(event.getDescription()));
        return eventDao.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        event.setTitle(Utility.cleanupSpaces(event.getTitle()));
        event.setDescription(Utility.cleanupSpaces(event.getDescription()));
        return eventDao.save(event);
    }

    @Override
    public void deleteEvent(long id) {
        eventDao.deleteById(id);
    }

    @Override
    public Domain addDomain(Domain domain) {
        // TODO Auto-generated method stub
        return null;
    }
}
