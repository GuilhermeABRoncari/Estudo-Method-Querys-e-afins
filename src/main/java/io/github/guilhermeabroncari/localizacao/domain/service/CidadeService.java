package io.github.guilhermeabroncari.localizacao.domain.service;

import io.github.guilhermeabroncari.localizacao.domain.entity.Cidade;
import io.github.guilhermeabroncari.localizacao.domain.repository.CidadeRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CidadeService {
    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository){

        this.cidadeRepository = cidadeRepository;
    }
    @Transactional
    public void salvarCidade(Cidade cidade) {
        cidadeRepository.save(cidade);
    }

    public void listarCidades() {
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public void listarCidadesByNome(String nome) {
        cidadeRepository.findByNome(nome).forEach(System.out::println);
    }

    public void listarCidadesByHabitantes(Long qtd) {
        cidadeRepository.findByHabitantes(qtd).forEach(System.out::println);
    }

    public void listarCidadesByNomeContaining(String nome) {
        cidadeRepository.findByNomeContaining(nome).forEach(System.out::println);
    }

    public void listarCidadesByNomeStartingWith(String nome) {
        cidadeRepository.findByNomeContaining(nome).forEach(System.out::println);
    }

    public void listarCidadesByNomeEndingWith(String nome) {
        cidadeRepository.findByNomeEndingWith(nome).forEach(System.out::println);
    }

    public void listarCidadesByNomeLike(String nome) {
        Pageable pageable = PageRequest.of(0, 3);
        cidadeRepository.findByNomeLike("%"+nome+"%",
                Sort.by("habitantes")
//                , pageable
                ).forEach(System.out::println);
    }
    public void listarCidadesByHabitantesLessThan(Long qtd){
        cidadeRepository.findByHabitantesLessThanEqual(qtd).forEach(System.out::println);
    }
    public void listarCidadesByHabitantesGreaterThan(Long qtd){
        cidadeRepository.findByHabitantesGreaterThanEqual(qtd).forEach(System.out::println);
    }
    public void listarCidadesByHabitantesGreaterThanAndNomeLike(Long qtd, String nome){
        cidadeRepository.findByHabitantesGreaterThanAndNomeLike(qtd, "%"+nome.toUpperCase()+"%").forEach(System.out::println);
    }
    public List<Cidade> filtroDinamico(Cidade cidade){

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);

        Example<Cidade> example = Example.of(cidade, matcher);
        return cidadeRepository.findAll(example);
    }

}
