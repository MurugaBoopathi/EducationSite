package com.example.educationsite.utils;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author MPI2COB
 * @Date 1/2/2024
 */

@Slf4j
public class JwtUtils {

  private static HttpServletRequest getHttpServletRequest() {
    return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
  }

  /**
   * Check if the token exist in current request header.
   *
   * @param currentRequest HttpServletRequest
   * @param headerTypes    Type of header token
   * @return
   */
  private static String getToken(HttpServletRequest currentRequest, List<String> headerTypes) {
    return headerTypes.stream()
        .map(currentRequest::getHeader)
        .filter(Objects::nonNull)
        .findFirst()
        .orElse(null);
  }

}
