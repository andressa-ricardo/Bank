package com.api.bank.entities;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import com.api.bank.enums.TypeAccount;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @NotNull
    @Size(max = 14)
    @CPF
    @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$")
    private String cpf;
    
    @NotNull @NotBlank @Email
    private String email;
    
    @Enumerated(EnumType.STRING)
    private TypeAccount typeAccount;
    
    @NotNull
    private String password;
}
