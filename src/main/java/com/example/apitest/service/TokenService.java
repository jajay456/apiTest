package com.example.apitest.service;

import com.example.apitest.dto.TokenRequest;
import com.example.apitest.dto.TokenResponse;
import com.example.apitest.entity.SsoUserEntity;
import com.example.apitest.dto.UserResponseDTO;
import com.example.apitest.repository.SsoUserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;
import java.util.ArrayList;
@Service
public class TokenService {

    private final SsoUserRepository repository;

    public TokenService(SsoUserRepository repository) {
        this.repository = repository;
    }

    public TokenResponse generateToken(TokenRequest req) {
        try {
            SsoUserEntity user = new SsoUserEntity();
            user.setRequestDate(LocalDateTime.now());
            user.setSsotype(req.getSsoType());
            user.setSystemid(req.getSystemId());
            user.setSystemname(req.getSystemName());
            user.setSystemtransactions(req.getSystemTransactions());
            user.setSystemprivileges(req.getSystemPrivileges());
            user.setSystemusergroup(req.getSystemUserGroup());
            user.setSystemlocationgroup(req.getSystemLocationGroup());
            user.setUserid(req.getUserId());
            user.setUserfullname(req.getUserFullName());
            user.setUserrdofficecode(req.getUserRdOfficeCode());
            user.setUserofficecode(req.getUserOfficeCode());
            user.setClientlocation(req.getClientLocation());
            user.setLocationmachinenumber(req.getLocationMachineNumber());
            user.setTokenid(req.getTokenId());

            repository.save(user);

            return new TokenResponse("I07000", "ทำรายการเรียบร้อย",
                    new TokenResponse.ResponseData(user.getUserid(), user.getTokenid()));
        } catch (Exception e) {
            return new TokenResponse("E000001", "ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้",
                    new TokenResponse.ResponseData(req.getUserId(), " "));
        }
    }

    public List<UserResponseDTO> getAllUsers() {
        List<SsoUserEntity> entities = repository.findAll();
        List<UserResponseDTO> dtos = new ArrayList<>();

        for (SsoUserEntity entity : entities) {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setUserId(entity.getUserid());
            dto.setUserFullName(entity.getUserfullname());
            dto.setSystemId(entity.getSystemid());
            dto.setTokenId(entity.getTokenid()); // หรือ maskToken()
            dtos.add(dto);
        }

        return dtos;
    }

}
