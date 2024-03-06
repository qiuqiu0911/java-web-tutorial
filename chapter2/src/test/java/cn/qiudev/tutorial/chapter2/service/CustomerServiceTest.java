package cn.qiudev.tutorial.chapter2.service;

import cn.qiudev.tutorial.chapter2.helper.DatabaseHelper;
import cn.qiudev.tutorial.chapter2.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }

    @Before
    public void init() throws Exception {
        // 初始化数据库
        String file = "sql/customer_init.sql";
        DatabaseHelper.executeSqlFile(file);

    }

    @Test
    public void getCustomerList() {
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomer() {
        Long id = 1L;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomer() {
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "customer100");
        fieldMap.put("concat", "John");
        fieldMap.put("telephone", "13512345678");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomer() {
        long id = 1L;
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("concat", "Eric");
        boolean result = customerService.updateCustomer(id, fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomer() {
        long id = 1L;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}