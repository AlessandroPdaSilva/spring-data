package dao;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import model.Usuario;

public interface SpringDataUsuario extends CrudRepository<Usuario, Long>{
	
	@Lock(LockModeType.READ)
	@Transactional(readOnly = true)
	@Query("SELECT u FROM Usuario u WHERE u.nome LIKE %?1%")
	public List<Usuario> pesquisarByNome(String nome);
	
	@Lock(LockModeType.READ)
	@Transactional(readOnly = true)
	@Query("SELECT u FROM Usuario u WHERE u.nome LIKE %:nome% AND u.idade = :idade ")
	public List<Usuario> pesquisarByNomeAndIdade(@Param("nome") String nome, @Param("idade") int idade);

	@Modifying
	@Transactional(rollbackFor = NullPointerException.class)
	@Query("DELETE FROM Usuario u WHERE u.nome = ?1 ")
	public void deletarPorNome(String nome);
	
	@Modifying
	@Transactional
	@Query("UPDATE Usuario u set u.email = ?1 where u.nome = ?2")
	public void editarEmailPorNome(String email, String nome);
	
	
	default <S extends Usuario> S saveAtual(S entity) {
		
		// processar algo
		
		return save(entity);
	}
}
