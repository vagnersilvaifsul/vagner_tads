package br.edu.ifsul.cstsi.vagner_tads.api.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDTOResponse>> selectAll() {
        return ResponseEntity.ok(service.getProdutos());
    }

    @GetMapping("{id}")
    public String selectById(@PathVariable("id") Long id) {
        return "selectById " + id;
    }

    @GetMapping("/nome/{nome}")
    public String selectByNome(@PathVariable("nome") String nome) {
        return "selectByNome " + nome;
    }

    @PostMapping
    public String insert(@RequestBody Produto produto) {
        return "insert " + produto;
    }

    @PutMapping("{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Produto produto) {
        return "update " + id + " " + produto;
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) {
        return "delete " + id;
    }

}
