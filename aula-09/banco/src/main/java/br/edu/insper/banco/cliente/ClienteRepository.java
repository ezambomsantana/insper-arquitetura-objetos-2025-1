package br.edu.insper.banco.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByCpf(String cpf);

    Page<Cliente> findByRendaGreaterThan(float renda, Pageable pageable);

    @Query("SELECT c FROM Cliente c " +
            "WHERE (:nome IS NULL OR c.nome = :nome) " +
            "AND (:renda IS NULL OR c.renda >= :renda) ")
    Page<Cliente> buscarClientePorNomeERenda(@Param("nome") String agencia,
                                              @Param("renda") Float saldo,
                                                Pageable pageable);


}
