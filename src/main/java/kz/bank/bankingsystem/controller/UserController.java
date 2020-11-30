package kz.bank.bankingsystem.controller;

import kz.bank.bankingsystem.model.User;
import kz.bank.bankingsystem.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/all/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable(name = "id") Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/all/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") Integer id){
        userService.deleteUser(id);
    }
}
