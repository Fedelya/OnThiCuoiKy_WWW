package vn.edu.iuh.fit.trananhtien.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.trananhtien.backend.models.Flight;
import vn.edu.iuh.fit.trananhtien.backend.repositories.FlightRepository;

@Service
public class FlightService {
    @Autowired
    public FlightRepository flightRepository;

    public Page<Flight> findAll(int pageNo, int pageSize, String sortBy,
                                String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return flightRepository.findAll(pageable);
    }
}
