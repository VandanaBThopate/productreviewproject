package com.product.review.controller;

import com.product.review.entity.Host;
import com.product.review.exception.HostNotFoundException;
import com.product.review.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
@CrossOrigin(origins = {"http://localhost:9090", "http://localhost:4200"},allowedHeaders = "*")
@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    @PostMapping("/register")
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> saveUser(@RequestBody Host host) {
        String tempEmail = host.getEmail();
        if(tempEmail != null && !"".equals(tempEmail) ) {
            if(hostService.fetchUserByEmail(tempEmail) != null ) {
                throw new HostNotFoundException("No user found with given email");

            }

        }
        hostService.registerUser(host);
        return new ResponseEntity<>("User added Successfully", HttpStatus.OK);
    }
    @PostMapping("/login")
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> loginAUser(@RequestBody Host host) {
        String tempEmail = host.getEmail();
        String tempPass = host.getPassword();
        if(tempEmail != null && tempPass != null) {
            if(hostService.fetchUserByEmailAndPassword(tempEmail, tempPass) == null) {
                throw new HostNotFoundException("Bad Credentials: User Not Registered");
            }
        }
        return new ResponseEntity<>("User Login Successful", HttpStatus.OK);

    }
    @GetMapping("/all/users")
    public List<Host> fetchAllUsers() {
        return hostService.getAllUsers();
    }

    @GetMapping("/sortHost/{field}")
    public List<Host> findHostsWithSorting(@PathVariable String field) {
        return hostService.findHostsWithSorting(field);
    }
    @GetMapping("/paginationHost/{offset}/{pageSize}")
    public Page<Host> findHostsWithPagination(@PathVariable int offset,@PathVariable int pageSize) {
        return hostService.findHostsWithPagination(offset, pageSize);
    }
    @GetMapping("/pageHost/{offset}/{pageSize}/{field}")
    public Page<Host> findHostsWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        return hostService.findHostsWithPaginationAndSorting(offset, pageSize, field);
    }
}
