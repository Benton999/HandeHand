package com.handehand.app.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.handehand.app.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.*;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<User> findAll() {
		logger.info("Obtaining full User list");
		List<User> users = em.createQuery("select u from User u where 1 = 1 order by u.identifier").getResultList();
		logger.info("Total number of Users: "+users.size());
		return users;
	}

	/*@Transactional(readOnly = true)
	public List<Hotel> findHotels(SearchCriteria criteria) {

		String pattern = getSearchPattern(criteria);

		log.debug("search pattern: " + pattern);

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Hotel> hotelCriteriaQuery = criteriaBuilder.createQuery(Hotel.class);

		Root<Hotel> from = hotelCriteriaQuery.from(Hotel.class);

		Expression<String> city = from.get("city");
		Expression<String> zip = from.get("zip");
		Expression<String> address = from.get("address");
		Expression<String> name = from.get("name");
		Expression<Double> price = from.get("price");

		Predicate predicate = criteriaBuilder.or(
				criteriaBuilder.like(criteriaBuilder.lower(city), pattern),
				criteriaBuilder.like(criteriaBuilder.lower(zip), pattern),
				criteriaBuilder.like(criteriaBuilder.lower(address), pattern),
				criteriaBuilder.like(criteriaBuilder.lower(name), pattern));

		if (criteria.getMaximumPrice() > 0) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(price, criteria.getMaximumPrice()));
		}

		hotelCriteriaQuery.where(predicate);

		TypedQuery<Hotel> typedQuery = em.createQuery(hotelCriteriaQuery);

		if (criteria.getPage() > 0 && criteria.getPageSize() > 0)
			typedQuery.setMaxResults(criteria.getPageSize()).setFirstResult(criteria.getPage() * criteria.getPageSize());

		List<Hotel> hotels = typedQuery.getResultList();

		log.debug("returned " + hotels.size() + " results");
		return hotels;
	}

	@Transactional(readOnly = true)
	public Hotel findHotelById(Long id) {
		return em.find(Hotel.class, id);
	}

	@Transactional
	public Booking createBooking(Long hotelId, String username) {
		Hotel hotel = em.find(Hotel.class, hotelId);
		User user = findUser(username);
		Booking booking = new Booking(hotel, user);
		em.persist(booking);
		return booking;
	}



	@Override
	@Transactional
	public void persistBooking(Booking booking) {
		em.merge(booking);
	}

	@Transactional
	public void cancelBooking(Long id) {
		Booking booking = em.find(Booking.class, id);
		if (booking != null) {
			em.refresh(booking);
			em.remove(booking);
		}
	}*/

	// helpers

	@SuppressWarnings("unused")
	private String getSearchPattern(SearchCriteria criteria) {
		if (StringUtils.hasText(criteria.getSearchString())) {
			return "%"
					+ criteria.getSearchString().toLowerCase()
					.replace('*', '%') + "%";
		} else {
			return "'%'";
		}
	}

	public User findUser(String username) {
		return (User) em.createQuery(
				"select u from User u where u.username = :username")
				.setParameter("username", username).getSingleResult();
	}

	public User login(String u, String pw) {
		return findUser( u) ;
	 //	return (User) em.createQuery("select u from User u where u.username = :u and u.password = :p").setParameter("u", u).setParameter("p",pw).getSingleResult();
	}
}
