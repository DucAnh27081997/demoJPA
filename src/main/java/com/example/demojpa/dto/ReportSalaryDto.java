package com.example.demojpa.dto;

import com.example.demojpa.entity.User;
import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ReportSalaryDto implements Serializable {
    private String department;
    private String totalSaraly;

    public ReportSalaryDto(String department, String totalSaraly) {
        this.department = department;
        this.totalSaraly = totalSaraly;
    }
}
