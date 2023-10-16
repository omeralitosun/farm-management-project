package com.omerali.farmmanagementproject.business.dtos.field.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFieldRequest {
    @NotBlank(message = "İsim alanı boş olamaz")
    private String name;
    @Min(value = 0, message = "Dönüm alanı en az 0 olmalıdır")
    private double decare;
}
