package com.test.dao;
import com.test.model.Customer;
import java.util.*;
public interface CustomerDao {
public int saveCustomer(Customer obj);
public List<Customer> listallcustomers();
}
