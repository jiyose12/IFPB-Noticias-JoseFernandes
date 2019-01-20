package modelo;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Jos� Raimundo Fernandes Filho
 **********************************/
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class SetorNoticia {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}
			)
	private List<Noticia> noticias = new ArrayList<Noticia>();
	
	public SetorNoticia() {}
	public SetorNoticia(String descricao) {
		super();
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Noticia> getNoticias() {
		return noticias;
	}
	public void cadastrarNoticia(Noticia noticia) {
		this.noticias.add(noticia);
	}
	@Override
	public String toString() {
		
		String txt = "id= " + id + ", Setor= " + descricao + "]" + "Noticia ";
		
		if (noticias.isEmpty()) 
			txt += "Nenhuma noticia cadastrada ";
		else
			for (Noticia i: noticias)
				txt+= i.getTitulo() +", ";
		return txt;
	}
}
