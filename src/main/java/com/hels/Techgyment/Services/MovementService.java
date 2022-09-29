package com.hels.Techgyment.Services;

import com.hels.Techgyment.Entities.Movement;
import com.hels.Techgyment.Repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public List<Movement> getMovements(){
        return this.movementRepository.findAll();
    }

    public Movement getMovements(Long id){
        Optional<Movement> transaction = this.movementRepository.findById(id);
        return transaction.orElse(null);
    }

    public Movement createMovement(Movement movement){
        return this.movementRepository.save(movement);
    }

    public Movement updateMovement(Long id, Movement movement){
        Optional<Movement> bdData = this.movementRepository.findById(id);
        if(bdData.isPresent()){
            Movement m = bdData.get();
            m.setId(movement.getId());
            m.setConcept(movement.getConcept());
            m.setAmount(movement.getAmount());
            m.setEmployee(movement.getEmployee());
            m.setEnterprise(movement.getEnterprise());
            this.movementRepository.save(m);
            return m;
        }
        return null;
    }

    public String deleteMovement(Long id){
        try{
            this.movementRepository.deleteById(id);
            return "The transaction information was deleted successfully";
        } catch (Exception e){
            return "The transaction information was not deleted";
        }
    }
}
