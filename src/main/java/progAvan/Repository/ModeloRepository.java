package progAvan.Repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import progAvan.Model.Modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
    List<Modelo> findByEstadoIsTrue();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM Modelo WHERE marca_id = :marcaId", nativeQuery = true)
    List<Modelo> findByMarca(int marcaId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Modelo SET estado = false WHERE id = :modeloId", nativeQuery = true)
    void deshabilitarModelo(Integer modeloId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Modelo SET estado = false WHERE marca_id = :marcaId", nativeQuery = true)
    void deshabilitarModelosPorMarcaId(Integer marcaId);

}