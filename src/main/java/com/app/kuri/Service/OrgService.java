package com.app.kuri.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.kuri.Dto.OrgDto;
import com.app.kuri.Exception.OrgException;
import com.app.kuri.Model.Org;
import com.app.kuri.Repository.OrgRepository;

@Service
public class OrgService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrgRepository orgRepo;

    public Org createOrg(String schema, OrgDto org) {
        Org newOrg = modelMapper.map(org, Org.class);
        newOrg.setSchema(schema);
        return orgRepo.save(newOrg);
    }

    /**
     * Fetch Org if Id is matched else fetch all Orgs under the specified schema
     * @param schema mandatory
     * @param id optional
     * @return List of Orgs
     */
    public List<Org> getOrg(String schema, Long id) {
        if (schema != null) {
            if (id != null && id >= 0) {
                Org matchedOrg = orgRepo.findById(id).orElse(null);
                if (matchedOrg != null) {
                    if (!schema.equals(matchedOrg.getSchema())) {
                        throw new OrgException("Invalid schema");
                    }
                } else {
                    throw new OrgException("Invalid id");
                }
                return Arrays.asList(matchedOrg);
            }
            return orgRepo.findBySchema(schema).orElse(new ArrayList<>());
        }
        return new ArrayList<>();
    }

}
