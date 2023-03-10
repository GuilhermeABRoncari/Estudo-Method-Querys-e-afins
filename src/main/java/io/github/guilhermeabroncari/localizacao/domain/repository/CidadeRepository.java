package io.github.guilhermeabroncari.localizacao.domain.repository;

import io.github.guilhermeabroncari.localizacao.domain.entity.Cidade;
import io.github.guilhermeabroncari.localizacao.domain.repository.projections.CidadeProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {
    @Query(nativeQuery = true, value = " SELECT * FROM TB_CIDADE AS C WHERE C.NOME = :NOME ")
    List<Cidade> findByNomeSqlNativo(@Param("NOME") String nome);
    @Query(nativeQuery = true, value = " SELECT C.ID_CIDADE AS ID, C.NOME FROM TB_CIDADE AS C WHERE C.NOME = :NOME ")
    List<CidadeProjections> findByNomeSqlNativoProjection(@Param("NOME") String nome);
    //busca pelo nome completo.
    List<Cidade> findByNome(String nome);
    //buscar pelo nome usando metodo like.
    @Query(" SELECT C FROM Cidade C WHERE UPPER(C.nome) LIKE UPPER(?1) ")
    List<Cidade> findByNomeLike(String nome, Sort sort);
    @Query(" SELECT C FROM Cidade C WHERE UPPER(C.nome) LIKE UPPER(?1) ")
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);
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
