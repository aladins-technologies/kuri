package com.app.kuri.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.kuri.Service.ContactService;
import com.app.kuri.Utils.ApiResponse;
import com.app.kuri.Utils.CustomHttpStatus;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Application!";
    }

    @GetMapping("/contactInfo")
    public ResponseEntity<ApiResponse> contactInfo(@RequestHeader("X-TenantSchema") String schema,
            @RequestParam(value = "id", required = false) Long id) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", contactService.getContactInfo(schema, id));
        return ResponseEntity.ok(new ApiResponse(data, "success", CustomHttpStatus.SUCCESS.asStatus()));
    }

    @Transactional
    @GetMapping("/customer")
    public ResponseEntity<ApiResponse> getCustomer(@RequestHeader("X-TenantSchema") String schema,
            @RequestParam(value = "id", required = false) Long id) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", contactService.getCustomer(schema, id));
        return ResponseEntity.ok(new ApiResponse(data, "success", CustomHttpStatus.SUCCESS.asStatus()));
    }

}
