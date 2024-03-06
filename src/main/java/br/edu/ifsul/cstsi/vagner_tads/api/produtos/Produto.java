package br.edu.ifsul.cstsi.vagner_tads.api.produtos;

import br.edu.ifsul.cstsi.vagner_tads.api.itens.Item;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity(name = "Produto")
@Table(name = "produtos")
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valorDeCompra;
    private BigDecimal valorDeVenda;
    private String descricao;
    private Boolean situacao;
    private Integer estoque;
    @OneToMany(mappedBy = "produto")
    private Collection<Item> items;
}
