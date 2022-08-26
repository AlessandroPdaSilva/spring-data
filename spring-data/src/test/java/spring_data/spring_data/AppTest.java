package spring_data.spring_data;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.SpringDataUsuario;
import model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppTest {
	
	@Autowired
	private SpringDataUsuario springDataUsuario;
	
	@Test
	public void testeSpring() {
		
		System.out.println("Spring iniciou com sucesso!!");
		
	}
	
	@Test
	public void testeInsert() {
		
		Usuario u = new Usuario();
		u.setNome("Pedro");
		u.setIdade(25);
		u.setEmail("pedro@gmail.com");
		u.setLogin("pedro");
		u.setSenha("123");
		
		springDataUsuario.save(u);
		
		System.out.println("Salva com sucesso !!");
		
	}
	
	
	@Test
	public void testeConsulta() {
		
		Optional<Usuario> u = springDataUsuario.findById(2L);
		Usuario usuario = u.get();
		
		System.out.println(usuario);
		
	}
	
	@Test
	public void testeConsultaTudo() {
		
		Iterable<Usuario> lista = springDataUsuario.findAll();
		
		for(Usuario u : lista) {
			System.out.println(u);
		}
		
	}

	@Test
	public void testeEditar() {
		
		Optional<Usuario> u = springDataUsuario.findById(2L);
		Usuario usuario = u.get();
		
		usuario.setNome("Maria Aparecida");
		usuario.setLogin("maria");
		usuario.setIdade(50);
		
		springDataUsuario.save(usuario);
		
		System.out.println("Editado com sucesso !!");
	}
	
	@Test
	public void testeDeletar() {
		
		springDataUsuario.deleteById(3L);
		 
		System.out.println("Deletado com sucesso !!");
	}
	
	@Test
	public void testePequisaPorNome() {
		
		List<Usuario> listaUsuario = springDataUsuario.pesquisarByNome("joao");
		
		for(Usuario u : listaUsuario) {
			System.out.println(u);
		}
		 
	}
	
	@Test
	public void testePequisaParam() {
		
		List<Usuario> listaUsuario = springDataUsuario.pesquisarByNomeAndIdade("joao",35);
		
		for(Usuario u : listaUsuario) {
			System.out.println(u);
		}
		 
	}
	
	@Test
	public void testeDeletarPorNome() {

		springDataUsuario.deletarPorNome("Pedro");
	
		System.out.println("Deletado com sucesso!!");
	}
	
	
	@Test
	public void testeEmailPorNome() {

		springDataUsuario.editarEmailPorNome("joaozinho@gmail.com", "Joao");
		
		System.out.println("Editado com sucesso!!");
	}
	
	
}
