package com.app.kuri.Service;

import com.app.kuri.Dto.OrgDto;
import com.app.kuri.Exception.OrgException;
import com.app.kuri.Model.Org;
import com.app.kuri.Repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

    @Autowired
    private OrgRepository orgRepo;

    public Org transform(String schema, OrgDto org){
        return Org.builder()
            .orgName(org.getOrgName())
            .address(org.getAddress())
            .schema(schema)
            .build();
    }

    public Org createOrg(String schema, OrgDto org){
        if(org.getOrgName() == null || org.getOrgName().length() < 3){
            throw new OrgException("Please provide a valid name for Organization");
        } else if(org.getAddress() == null || org.getAddress().length() <= 5){
            throw new OrgException("Please provide a valid address for Organization");
        }

        return orgRepo.save(transform(schema, org));
    }
}
