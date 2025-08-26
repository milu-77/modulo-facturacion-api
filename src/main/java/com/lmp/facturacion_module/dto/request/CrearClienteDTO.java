package com.lmp.facturacion_module.dto.request;

import com.lmp.facturacion_module.model.enums.CondicionDeVenta;
import com.lmp.facturacion_module.model.enums.CondicionIVA;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrearClienteDTO {
    @NotBlank(message = "El CUIT es obligatorio")
//    @Pattern(regexp = "^(\\d{2}-?\\d{8}-?\\d{1})$", message = "El CUIT debe tener 11 dígitos, con o sin guiones")
    private String cuit;
    @NotBlank(message = "La Razon Social es obligatorio")
    private String razonSocial;
    @NotBlank(message = "El Domicilio es obligatorio")
    private String domicilio;
    @NotBlank(message = "El Telefono es obligatorio")
    private String telefono;
    @NotBlank(message = "El Mail es obligatorio")
//    @Email(message = "El formato del mail no es válido")
    private String mail;
    @Enumerated(EnumType.STRING)
    private CondicionIVA condicionIVA;
    @Enumerated(EnumType.STRING)
    private CondicionDeVenta condicionDeVenta;



}
