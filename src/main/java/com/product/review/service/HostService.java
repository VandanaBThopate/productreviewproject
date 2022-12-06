package com.product.review.service;

import com.product.review.entity.Host;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HostService {
    public Host registerUser(Host host);
    public Host fetchUserByEmail(String email);
    public List<Host> getAllUsers();
    public Host fetchUserByEmailAndPassword(String email, String password);

    public List<Host> findHostsWithSorting(String field);
    public Page<Host> findHostsWithPagination(int offset, int pageSize);
    public Page<Host> findHostsWithPaginationAndSorting(int offset,int pageSize,String field);




}
