package org.bsim.walletapp_demo.service.impl;

import org.bsim.walletapp_demo.io.entity.UserEntity;
import org.bsim.walletapp_demo.io.irepository.UserRepository;
import org.bsim.walletapp_demo.service.iservice.IUserInterface;
import org.bsim.walletapp_demo.shared.dto.UserDTO;
import org.bsim.walletapp_demo.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service       //gbleh lupa
public class UserServiceImpl implements IUserInterface {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;


    @Override
    public List<UserDTO> getListUser() {
        return null;
    }

    @Override
    public UserDTO addNewData(UserDTO user) {
        user.setUserId(generateRandomPublicId.generateUserId(30));  //generate userID

        ModelMapper mapper = new ModelMapper(); //digunakan untuk mengtransfer data dari service ke repository

        //UserDTO -> user Entity
        UserEntity entity = mapper.map(user, UserEntity.class);
        //buat store data
        UserEntity storedData = userRepository.save(entity);

        //Mapping dari UserEntity kembali ke UserDTO (UserEntity -> UserDTO) //untuk return value
        UserDTO value = mapper.map(storedData, UserDTO.class);

        return value;
    }
}
