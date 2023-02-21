package io.github.guilhermeabroncari.localizacao.domain.repository;

import io.github.guilhermeabroncari.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    //busca pelo nome completo.
    List<Cidade> findByNome(String nome);
    //buscar pelo nome usando metodo like.
    @Query(" SELECT C FROM Cidade C WHERE UPPER(C.nome) LIKE UPPER(?1) ")
    List<Cidade> findByNomeLike(String nome);
    //busca começando por letra.
    List<Cidade> findByNomeStartingWith(String nome);
    //busca terminando por letra.
    List<Cidade> findByNomeEndingWith(String nome);
    //busca contentendo letras informadas pelo usuario.
    List<Cidade>findByNomeContaining(String nome);

    //variando os metodos de busca por habitantes.
    List<Cidade> findByHabitantes(Long qtd);
    List<Cidade> findByHabitantesLessThan(Long qtd);
    List<Cidade> findByHabitantesLessThanEqual(Long qtd);
    List<Cidade> findByHabitantesGreaterThan(Long qtd);
    List<Cidade> findByHabitantesGreaterThanEqual(Long qtd);

    //multiplos parametros de busca.
    List<Cidade> findByHabitantesGreaterThanAndNomeLike(Long qtd, String nome);
}
