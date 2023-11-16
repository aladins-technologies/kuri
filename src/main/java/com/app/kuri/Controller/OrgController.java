package com.app.kuri.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.kuri.Dto.OrgDto;
import com.app.kuri.Service.OrgService;
import com.app.kuri.Utils.ApiResponse;
import com.app.kuri.Utils.CustomHttpStatus;

@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the Application!";
    }

    @PostMapping("/createOrg")
    public ResponseEntity<ApiResponse> createOrg(@RequestHeader("X-TenantSchema") String schema, @Valid @RequestBody OrgDto org) {
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            data.put("data", orgService.createOrg(schema, org));
            return ResponseEntity.ok(new ApiResponse(data, "brand created", CustomHttpStatus.SUCCESS.asStatus()));
        } catch (Exception ex) {
         //   Sentry.captureException(ex);
            data.put("message", ex.getClass().getName() + ": " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
        }
    }
}
