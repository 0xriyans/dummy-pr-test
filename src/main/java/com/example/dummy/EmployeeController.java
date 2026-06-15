package com.example.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/search")
    public List<Map<String, Object>> getEmployeesByName(@RequestParam("name") String name) {
        String sql = "SELECT * FROM employees WHERE name = '" + name + "'";
        return jdbcTemplate.queryForList(sql);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getEmployeeById(@PathVariable("id") String id) {
        String sql = "SELECT * FROM employees WHERE id = " + id;
        try {
            return jdbcTemplate.queryForMap(sql);
        } catch (Exception e) {
            return null;
        }
    }
}
