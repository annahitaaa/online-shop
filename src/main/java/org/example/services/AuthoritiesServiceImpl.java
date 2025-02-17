package org.example.services;

import org.example.data.AuthoritiesDAO;
import org.example.data.entities.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    @Autowired
    private AuthoritiesDAO authoritiesDAO;

    @Transactional
    @Override
    public void addAuthorities(Authorities authorities) {
        authoritiesDAO.save(authorities);
    }
}
