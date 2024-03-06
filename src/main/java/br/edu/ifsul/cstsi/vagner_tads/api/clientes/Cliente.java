package br.edu.ifsul.cstsi.vagner_tads.api.clientes;

import br.edu.ifsul.cstsi.vagner_tads.api.pedidos.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity(name = "Cliente")
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private Byte situacao;

    @OneToMany(mappedBy = "cliente")
    private Collection<Pedido> pedidos;
}
