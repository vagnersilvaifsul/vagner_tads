package br.edu.ifsul.cstsi.vagner_tads.api.pedidos;


import br.edu.ifsul.cstsi.vagner_tads.api.clientes.Cliente;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity(name = "Pedido")
@Table(name = "pedidos")
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pagamento;
    private String estado;
    private Date dataCriacao;
    private Date dataModificacao;
    private Byte situacao;
    private BigDecimal totalPedido;
    @ManyToOne
    @JoinColumn(name = "clientes_id", referencedColumnName = "id", nullable = false)
    private Cliente cliente;
}
