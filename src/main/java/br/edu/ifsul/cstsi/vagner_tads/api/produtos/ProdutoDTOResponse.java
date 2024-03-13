package br.edu.ifsul.cstsi.vagner_tads.api.produtos;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Data
public class ProdutoDTOResponse {
    private Long id;
    private String nome;
    private BigDecimal valorDeVenda;
    private Integer estoque;

    public static ProdutoDTOResponse create(Produto p){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(p, ProdutoDTOResponse.class);
    }
}
