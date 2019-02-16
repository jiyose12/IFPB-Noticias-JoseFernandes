package modelo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * José Raimundo Fernandes Filho
 **********************************/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class BackupNoticia {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String descricao;
	private Date data = new Date();
	private String nomefoto;
	private String tiponoticia;
	@Enumerated(EnumType.STRING)
	private IndPublicar indpublicar;
	private int nrvisitas;
//	@ManyToMany(fetch=FetchType.LAZY,
//			cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}
//			)
//	@JoinTable(
//	name="noticia_setornoticia",
//	joinColumns=@JoinColumn(name="noticia_id"),
//	inverseJoinColumns=@JoinColumn(name="setornoticia_id")
//			)
	
	//private List<NoticiasAnteriores> noticiasanteriores = new ArrayList<NoticiasAnteriores>();
	public BackupNoticia() {}
	public BackupNoticia(String titulo, String descricao, String tiponoticia, String datastr) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.tiponoticia = tiponoticia;
		try {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			this.data = f.parse(datastr);
		} 
		catch (ParseException e) 
		{ throw new RuntimeException("data invalida");}
		
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getNomefoto() {
		return nomefoto;
	}

	public void setNomefoto(String nomefoto) {
		this.nomefoto = nomefoto;
	}

	public IndPublicar isIndpublicar() {
		return indpublicar;
	}

	public void setIndpublicar(IndPublicar indpublicar) {
		this.indpublicar = indpublicar;
	}

	public int getNrvisitas() {
		return nrvisitas;
	}

	public void setNrvisitas(int nrvisitas) {
		this.nrvisitas = nrvisitas;
	}

//	public TipoNoticia getTipo() {
//		return tipo;
//	}
//
//	public void setTipo(TipoNoticia tipo) {
//		this.tipo = tipo;
//	}

//	public void adicionarNoticiasAnteriores(Noticia a) {
//		noticiasanteriores.add(a);
//	}
//	
//	public void removerNoticiasAnteriores(Noticia a) {
//		noticiasanteriores.remove(a);
//	}

	

	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String txt = "Noticia [id= " + id + ", titulo= " + titulo + ", Conteudo= " + descricao + ", data= " + f.format(data)
				+ ", Caminho do Arquivo= " + nomefoto + ", indpublicar= " + indpublicar + ", nrvisitas= " + nrvisitas + "]"; 
			
		return txt;
	}

	
	
}
