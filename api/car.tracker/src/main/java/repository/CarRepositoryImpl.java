package repository;

import entity.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Car> findAll() {
        TypedQuery<Car> query = em.createNamedQuery("Vehicle.findAll", Car.class);
        System.out.println("Query is :"+query);
        System.out.println("Result is : "+query.getResultList());
        return query.getResultList();
    }

    @Override
    public Car findOne(String vin) {
        return em.find(Car.class, vin);
    }

    @Override
    public Car findByModel(String model) {
        TypedQuery<Car> query = em.createNamedQuery("Vehicle.findByModel", Car.class);
        query.setParameter("model", model);
        List<Car> resultList = query.getResultList();

        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Car create(Car c) {
        em.persist(c);
        return c;
    }

    @Override
    public Car update(Car c) {
        return em.merge(c);
    }

    @Override
    public void delete(Car c) {
        em.remove(c);
    }

	
}
