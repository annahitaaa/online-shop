package org.example.services;

import lombok.AllArgsConstructor;
import org.example.data.UsersDAO;
import org.example.data.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService{

    private UsersDAO usersDAO;

    @Transactional
    @Override
    public void addUser(Users user) {
        usersDAO.save(user);
    }
}
