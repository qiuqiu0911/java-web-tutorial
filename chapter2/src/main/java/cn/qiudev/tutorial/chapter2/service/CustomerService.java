package cn.qiudev.tutorial.chapter2.service;

import cn.qiudev.tutorial.chapter2.helper.DatabaseHelper;
import cn.qiudev.tutorial.chapter2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 */
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);


    /**
     * 获取客户列表
     *
     * @return
     */
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户详情
     */
    public Customer getCustomer(Long id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insert(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(Long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(Long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
