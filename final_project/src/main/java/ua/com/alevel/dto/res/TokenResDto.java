package ua.com.alevel.dto.res;

import java.util.Date;

public record TokenResDto(String token, Date expiryDate) {}
