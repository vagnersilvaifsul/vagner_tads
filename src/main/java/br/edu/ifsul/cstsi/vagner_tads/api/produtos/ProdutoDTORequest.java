package br.edu.ifsul.cstsi.vagner_tads.api.produtos;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Data
public class ProdutoDTORequest {
    private Long id;
    private String nome;
    private BigDecimal valorDeVenda;
    private Integer estoque;

    public static ProdutoDTORequest create(Produto p){
        var modelMapper = new ModelMapper();
        return modelMapper.map(p, ProdutoDTORequest.class);
    }
}
