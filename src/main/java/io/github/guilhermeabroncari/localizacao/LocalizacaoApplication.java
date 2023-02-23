package io.github.guilhermeabroncari.localizacao;

import io.github.guilhermeabroncari.localizacao.domain.entity.Cidade;
import io.github.guilhermeabroncari.localizacao.domain.repository.CidadeRepository;
import io.github.guilhermeabroncari.localizacao.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {
    @Autowired
    private CidadeService cidadeService;

    @Override
    public void run(String... args) throws Exception {
//        cidadeService.listarCidades();
//        cidadeService.listarCidadesByNome("BELO HORIZONTE");
//        cidadeService.listarCidadesByHabitantes(10363514L);
//        cidadeService.listarCidadesByNomeContaining("PORTO");
//        cidadeService.listarCidadesByNomeStartingWith("N");
//        cidadeService.listarCidadesByNomeEndingWith("R");
//        cidadeService.listarCidadesByNomeLike("a"); // <-- Pageble & Sort(por habitantes) aplicados.
//        cidadeService.listarCidadesByHabitantesLessThan(5000000L);
//        cidadeService.listarCidadesByHabitantesGreaterThan(5000000L);
//        cidadeService.listarCidadesByHabitantesGreaterThanAndNomeLike(5000000L, "bel");
        //usando Specification Methods
//        cidadeService.listarCidadesByNomeSpec("SALVADOR");
        var cidade = new Cidade(1L, null, null);
        cidadeService.listarCidadesSpecsFiltroDinamico(cidade);

    }



    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

}
