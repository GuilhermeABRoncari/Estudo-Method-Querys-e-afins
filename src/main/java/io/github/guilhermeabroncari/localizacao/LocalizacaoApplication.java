package io.github.guilhermeabroncari.localizacao;

import io.github.guilhermeabroncari.localizacao.domain.entity.Cidade;
import io.github.guilhermeabroncari.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) throws Exception {
        listarCidades();
        listarCidadesByNome("BELO HORIZONTE");
        listarCidadesByHabitantes(10363514L);
        listarCidadesByNomeContaining("PORTO");
        listarCidadesByNomeStartingWith("N");
        listarCidadesByNomeEndingWith("R");
        listarCidadesByNomeLike("jan");
        listarCidadesByHabitantesLessThan(5000000L);
        listarCidadesByHabitantesGreaterThan(5000000L);
        listarCidadesByHabitantesGreaterThanAndNomeLike(5000000L, "bel");
    }

    @Transactional
    public void salvarCidade() {
        cidadeRepository.save(new Cidade(1L, "São Paulo", 12176866L));
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
        cidadeRepository.findByNomeLike("%"+nome+"%").forEach(System.out::println);
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

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

}
