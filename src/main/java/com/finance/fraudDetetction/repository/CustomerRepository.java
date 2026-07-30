package com.finance.fraudDetetction.repository;

import com.finance.fraudDetetction.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
// import org.springframework.jdbc.support.GeneratedKeyHolder;
// import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
// import java.sql.Timestamp;
// import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
//    private List<Customer> customers= new ArrayList<>();
//    public CustomerRepository(){
//        customers.add(new Customer(1, "Priyanshu", "HFOPB1010", "India"));
//        customers.add(new Customer(2, "Shruti", "HFOPB1020", "USA"));
//        customers.add(new Customer(3, "Radhika", "HFOPB1030", "Australia"));
//    }
//    public  List<Customer> getCustomers(){
//        return customers;
//    }
//    public Customer getCustomerById(int id){
//        return customers.stream().filter(customer -> customer.getId()==id).findFirst().orElse(null);
//    }

    private JdbcTemplate jdbcTemplate;
    private RowMapper<Customer> rowMapper=((rs, rowNum) -> new Customer(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("accountNumber"),
            rs.getString("registeredCountry")
    ));
    public CustomerRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Customer> getCustomers(){
        return jdbcTemplate.query("SELECT * FROM customer", rowMapper);
    }
    public Customer getCustomerById(int id){
        return jdbcTemplate.queryForObject("SELECT * from customer where id= ? " , rowMapper, id);
    }

    public void deleteCustomerbyId(int id){
        jdbcTemplate.query("DELETE FROM customer WHERE id= ?", rowMapper, id);
    }
    public void addCustomer(Customer customer){
//        KeyHolder keyHolder= new GeneratedKeyHolder();// just a placeholder for transaction id that gets created by mySQL auto INCREMENT set to true
        String sql= "INSERT INTO customers (id, name, txn_country, account_number, registered_country)"+" VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection->{
            PreparedStatement ps= connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(4, customer.getAccountNumber());
            ps.setString(3, customer.getRegisteredCountry());


            return ps;
        });


    }


}
