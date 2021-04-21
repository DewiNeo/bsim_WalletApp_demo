package org.bsim.walletapp_demo.service.iservice;

import org.bsim.walletapp_demo.shared.dto.UserDTO;

import java.util.List;
public interface IUserInterface {
    List<UserDTO> getListUser();

    UserDTO addNewData(UserDTO user);

}
