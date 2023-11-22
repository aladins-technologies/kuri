package com.app.kuri.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.kuri.Dto.ContactDto;
import com.app.kuri.Exception.OrgException;
import com.app.kuri.Model.Org;

@Service
public class ContactService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrgService orgService;

    public ContactDto getContactInfo(String schema, Long orgId) {
        List<Org> orgList = orgService.getOrg(schema, orgId);
        if (orgList == null || orgList.size() != 1) {
            throw new OrgException("Please specify a valid Organization");
        }
        return modelMapper.map(orgList.get(0), ContactDto.class);
    }
}
