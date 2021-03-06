package org.mql.crowddonating.business.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.mql.crowddonating.business.IPublicServices;
import org.mql.crowddonating.dao.CaseRepository;
import org.mql.crowddonating.dao.SponsorRepository;
import org.mql.crowddonating.dao.EventRepository;
import org.mql.crowddonating.dao.DonationRepository;
import org.mql.crowddonating.dao.TypeRepository;
import org.mql.crowddonating.dao.UserRepository;
import org.mql.crowddonating.models.Association;
import org.mql.crowddonating.models.Case;
import org.mql.crowddonating.models.Domain;
import org.mql.crowddonating.models.Donation;
import org.mql.crowddonating.models.Donor;
import org.mql.crowddonating.models.Event;
import org.mql.crowddonating.models.Sponsor;
import org.mql.crowddonating.models.Type;
import org.mql.crowddonating.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PublicServicesBusiness implements IPublicServices {

	@Autowired
	private CaseRepository caseDao;

	@Autowired
	private TypeRepository typeDao;

	@Autowired
	private UserRepository userDao;

	@Autowired
	private SponsorRepository sponsorDao;

	@Autowired
	private EventRepository eventDao;

	@Autowired
	private DonationRepository donationDao;

	public Page<Case> getAllCases(int page, int size) {
		return caseDao.findAll(PageRequest.of(page, size));
	}

	public Case getCaseById(long id) {
		return caseDao.findById(id).get();
	}

	public Page<Case> getCasesByName(String name, int page, int size) {
		return caseDao.findByNameLike(name, PageRequest.of(page, size));
	}

	@Override
	public Case getCaseBySlug(String slug) {
		return caseDao.findBySlug(slug);
	}

	public List<Type> getAllTypes() {
		return typeDao.findAll();
	}

	@Override
	public Association addAssociation(Association association) {
		return userDao.save(association);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getAllEvents() {
		return eventDao.findAll();
	}

	@Override
	public Event getEventById(long id) {
		return eventDao.getOne(id);
	}

	@Override
	public List<Event> getEventByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sponsor> getAllSponsors() {
		return sponsorDao.findAll();
	}

	@Override
	public Sponsor getSponsorById(long id) {
		return sponsorDao.getOne(id);
	}

	@Override
	public List<Association> getAllAssociations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Association> getAssociationsByDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Association> getAssociationsByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getAssociationById(long id) {
		return userDao.findById(id).get();
	}

	@Override
	public List<Domain> getAllDomains() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getTypeById(long id) {
		return typeDao.getOne(id);
	}

	@Override
	public Page<Sponsor> getSponsorByName(String name, int page, int size) {
		return sponsorDao.findByNameLike(name, PageRequest.of(page, size));
	}

	public Donor addDonor(Donor donor) {
		return userDao.save(donor);
	}

	@Override
	public List<Donation> getCaseDonating(Case aCase) {
		return donationDao.findByACase(aCase);
	}

	@Override
	public Donation getDonationById(long id) {
		return donationDao.findById(id).get();
	}

	@Override
	public User findUserByUsername(String userName) {
		return userDao.findByUsername(userName);
	}

}
