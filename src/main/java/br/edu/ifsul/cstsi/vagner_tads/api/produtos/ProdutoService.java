package br.edu.ifsul.cstsi.vagner_tads.api.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository rep;

    public List<ProdutoDTOResponse> getProdutos() {
        return rep.findAll().stream().map(ProdutoDTOResponse::create).collect(Collectors.toList());
    }
}
