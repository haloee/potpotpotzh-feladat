package hu.pte.mik.prog4.service;
import hu.pte.mik.prog4.entity.TravelEntity;
import hu.pte.mik.prog4.repository.TravelRepository;

import java.util.List;
public class TravelService {
    private final TravelRepository travelRepository;

    public TravelService() {
        this.travelRepository = new TravelRepository();
    }

    public List<TravelEntity> listAll() {
        return this.travelRepository.listAll();
    }

    public TravelEntity save(TravelEntity travel) {
        return this.travelRepository.save(travel);
    }

    public TravelEntity update(TravelEntity travel) {
        return this.travelRepository.update(travel);
    }

    public TravelEntity findById(Long id) {
        return this.travelRepository.findTravelById(id);
    }

    public Double getTravelling(String travelId) {
        return this.travelRepository.getUticel(travelId);
    }
}
