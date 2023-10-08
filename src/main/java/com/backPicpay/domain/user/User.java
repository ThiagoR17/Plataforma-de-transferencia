package com.backPicpay.domain.user;


import com.backPicpay.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@Entity(name = "usuarios")
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobreNome;

    @Column(unique = true)
    private String documento;
    @Column(unique = true)
    private String email;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data){
        this.nome = data.nome();
        this.sobreNome = data.sobreNome();
        this.balance = data.balance();
        this.userType = data.userType();
        this.email = data.email();
        this.documento = data.documento();

    }

}
