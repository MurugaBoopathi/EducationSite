package com.example.educationsite.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author Boopathi
 * @Date 1/2/2024
 */

@ControllerAdvice
public class RestExceptionHandler {

  //This class is to handle the exceptions in our application

  public static final String GENERAL_SERVER_ERROR = "Unexpected error occurred - please contact support";

  public static final String BAD_REQUEST = "Invalid data provided";

}
