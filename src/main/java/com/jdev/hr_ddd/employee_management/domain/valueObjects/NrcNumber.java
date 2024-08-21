package com.jdev.hr_ddd.employee_management.domain.valueObjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value // make fields private and final
@Embeddable
public class NrcNumber {

    @NotBlank
    String state;
    @NotBlank
    String township;
    @NotBlank @Size(min = 6, max = 6)
    String idNumber;

    // No-argument constructor required by JPA
    public NrcNumber() {
        this.state = null;
        this.township = null;
        this.idNumber = null;
    }

    public NrcNumber(String state, String township, String idNumber) {

        this.state = state;
        this.township = township;
        this.idNumber = idNumber;
    }

}
