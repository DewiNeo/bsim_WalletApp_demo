package org.bsim.walletapp_demo.ui.controller;



import org.bsim.walletapp_demo.service.iservice.IUserInterface;
import org.bsim.walletapp_demo.shared.dto.UserDTO;
import org.bsim.walletapp_demo.ui.model.request.UserRequest;
import org.bsim.walletapp_demo.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
git log
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    IUserInterface userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponse> getUsers(){
        return null;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse addNewUser(@RequestBody UserRequest user){
        ModelMapper mapper = new ModelMapper();
        //UseRequest -> UserDTO
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        //panggil service kita
        UserDTO createdUser = userService.addNewData(userDTO);

        //karena dia mnta user response jadi kita hrus mapping dari userDTO -> UserResponse
        UserResponse response = mapper.map(createdUser, UserResponse.class);
        //udah dapat value dari response
        // trkhir kita tunggl return response saja
        return response;
    }

}
