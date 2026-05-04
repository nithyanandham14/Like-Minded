package com.likeminded.dto;

/**
 * @author nithy
 **/
import lombok.Data;

@Data
public class UserDashboardResponse {

    private int submissions;
    private int wins;
    private double earnings;
}
