package io.github.guilhermeabroncari.localizacao.domain.repository.specs;

import io.github.guilhermeabroncari.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {
    public static Specification<Cidade> nomeEqual(String nome) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> idEqual(Long id){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }
    public static Specification<Cidade> habitantesEqual(Long qtd){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("habitantes"), qtd);
    }
    public static Specification<Cidade> habitantesGreaterThan(Long qtd) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("habitantes"), qtd);
    }

    public static Specification<Cidade> habitantesBetwenn(Long min, Long max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("habitantes"), min, max);
    }

    public static Specification<Cidade> nomeLike(String nome) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%" + nome + "%");
    }
}
