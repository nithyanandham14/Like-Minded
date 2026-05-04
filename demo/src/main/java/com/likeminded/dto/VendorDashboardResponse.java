package com.likeminded.dto;

/**
 * @author nithy
 **/

import lombok.Data;

@Data
public class VendorDashboardResponse {

    private int totalProblems;
    private int openProblems;
    private int solvedProblems;
    private double totalPaid;
}
