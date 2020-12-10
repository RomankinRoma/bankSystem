package kz.bank.bankingsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bank.bankingsystem.model.User;
import kz.bank.bankingsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller")
public class UserController {

    @Autowired
    private IUserService userService;

    @Operation(summary="Get All Users", tags = { "User Controller" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Все юзеры получены"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
    })
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @Operation(summary="Register(Create) User", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Регистрация прошла успешно"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @Operation(summary="Update User", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Данные обновлены"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
            @ApiResponse(responseCode = "404",description = "Путь не найден")
    })
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @Operation(summary="Get User by ID", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Юзер существует"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
            @ApiResponse(responseCode = "404",description = "Юзер не найден")
    })
    @RequestMapping(value = "/all/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable(name = "id") Long id){
        return userService.getUserById(id);
    }

    @Operation(summary="Get User by Phone number", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Юзер существует"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
            @ApiResponse(responseCode = "404",description = "Юзер не найден")
    })
    @RequestMapping(value = "/phoneNumber",method = RequestMethod.GET)
    public User getUserByPhoneNumber(@RequestParam String phoneNumber){
        return userService.getUserByPhoneNumber(phoneNumber);
    }

    @Operation(summary="Login", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Юзер существует"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
            @ApiResponse(responseCode = "404",description = "Юзер не найден")
    })
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@RequestParam String username,@RequestParam String password){
        return userService.login(username,password);
    }


    @Operation(summary="Delete User", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Успешно удален"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
            @ApiResponse(responseCode = "404",description = "Юзер не найден")
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
    }
}
