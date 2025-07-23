package com.example.apitest.controller;
import com.example.apitest.dto.TokenRequest;
import com.example.apitest.dto.TokenResponse;
import com.example.apitest.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.apitest.dto.UserResponseDTO;
import java.util.List;

@RestController
@RequestMapping("/apitest")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/insert")
    @Operation(summary = "API สำหรับรับ Token และบันทึกลงฐานข้อมูล")
    public ResponseEntity<TokenResponse> generateToken(@RequestBody TokenRequest request) {
        if (request == null || request.getUserId() == null || request.getTokenId() == null) {
            return ResponseEntity.badRequest().body(
                    new TokenResponse("E000002", "ไม่พบข้อมูลการ POST",
                            new TokenResponse.ResponseData("", "")));
        }
        TokenResponse response = tokenService.generateToken(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getall")
    @Operation(summary = "ดึงข้อมูลผู้ใช้ทั้งหมด (DTO)")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(tokenService.getAllUsers());
    }
}

