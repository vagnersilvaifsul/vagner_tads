package br.edu.ifsul.cstsi.vagner_tads.api.itens;

import br.edu.ifsul.cstsi.vagner_tads.api.pedidos.Pedido;
import br.edu.ifsul.cstsi.vagner_tads.api.produtos.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Item")
@Table(name = "itens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal quantidade;
    private BigDecimal totalItem;
    private Byte situacao;
    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id", nullable = false)
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    private Produto produto;
}
