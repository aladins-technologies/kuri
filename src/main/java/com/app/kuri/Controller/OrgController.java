package com.app.kuri.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.kuri.Dto.OrgDto;
import com.app.kuri.Service.OrgService;
import com.app.kuri.Utils.ApiResponse;
import com.app.kuri.Utils.CustomHttpStatus;

import jakarta.validation.Valid;

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
        data.put("data", orgService.createOrg(schema, org));
        return ResponseEntity.ok(new ApiResponse(data, "org created", CustomHttpStatus.SUCCESS.asStatus()));
    }

    @GetMapping("/getOrg")
    public ResponseEntity<ApiResponse> getOrg(@RequestHeader("X-TenantSchema") String schema, @RequestParam(value = "id", required = false) Long id){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", orgService.getOrg(schema, id));
        return ResponseEntity.ok(new ApiResponse(data, "success", CustomHttpStatus.SUCCESS.asStatus()));
    }
}
