package kz.bank.bankingsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.bank.bankingsystem.model.User;
import kz.bank.bankingsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "UserController",description = "REST API for User", tags = { "User" })
public class UserController {

    @Autowired
    IUserService userService;

    @ApiOperation(value="Get All User", tags = { "User" })
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @ApiOperation(value="Create User", tags = { "User" })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @ApiOperation(value="Update User", tags = { "User" })
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ApiOperation(value="Get User by ID", tags = { "User" })
    @RequestMapping(value = "/all/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable(name = "id") Long id){
        return userService.getUserById(id);
    }

    @ApiOperation(value="Delete User", tags = { "User" })
    @RequestMapping(value = "/all/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
    }
}
