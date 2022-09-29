package com.hels.Techgyment.Services;

import com.hels.Techgyment.Entities.Enterprise;
import com.hels.Techgyment.Repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public EnterpriseService(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    public List<Enterprise> getEnterprises(){
        return this.enterpriseRepository.findAll();
    }

    public Enterprise getEnterprise(Long id){
        Optional<Enterprise> enterprise = this.enterpriseRepository.findById(id);
        return enterprise.orElse(null);
    }

    public Enterprise createEnterprise(Enterprise enterprise){
        return this.enterpriseRepository.save(enterprise);
    }

    public Enterprise updateEnterprise(Long id, Enterprise enterprise){
        Optional<Enterprise> bdData = this.enterpriseRepository.findById(id);

        if(bdData.isPresent()){
            Enterprise e = bdData.get();
            e.setId(enterprise.getId());
            e.setName(enterprise.getName());
            e.setNit((enterprise.getNit()));
            e.setPhone(enterprise.getPhone());
            e.setAddress(enterprise.getAddress());
            e.setCreatedAt(enterprise.getCreatedAt());
            e.setUpdatedAt(enterprise.getUpdatedAt());
            this.enterpriseRepository.save(e);
            return e;
        }
        return null;
    }

    public String deletEnterprise(Long id){
        try{
            this.enterpriseRepository.deleteById(id);
            return "The enterprise information was deleted successfully";
        } catch (Exception e){
            return "The enterprise information was not deleted";
        }
    }
}
