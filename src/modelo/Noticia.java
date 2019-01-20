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
public class Noticia {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String descricao;
	private Date data = new Date();
	private String nomefoto;
	@Enumerated(EnumType.STRING)
	private IndPublicar indpublicar;
	private int nrvisitas;
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}
			)
	private List<TipoNoticia> tipo = new ArrayList<TipoNoticia>();
//	@ManyToMany(fetch=FetchType.LAZY,
//			cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}
//			)
//	@JoinTable(
//	name="noticia_setornoticia",
//	joinColumns=@JoinColumn(name="noticia_id"),
//	inverseJoinColumns=@JoinColumn(name="setornoticia_id")
//			)
	@ManyToMany(mappedBy="noticias", fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}
			)
	private List<SetorNoticia> setor = new ArrayList<SetorNoticia>();
	
	//private List<NoticiasAnteriores> noticiasanteriores = new ArrayList<NoticiasAnteriores>();
	public Noticia() {}
	public Noticia(String titulo, String descricao, IndPublicar indpublicar, String datastr) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.indpublicar = indpublicar;
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

	public List<SetorNoticia> getSetor() {
		return setor;
	}

	public void adicionarSetor(SetorNoticia a) {
		setor.add(a);
	}
	
	public void removerSetor(SetorNoticia a) {
		setor.remove(a);
	}
	
	public void adicionarTipo(TipoNoticia a) {
		tipo.add(a);
	}
	
	public void removerTipo(TipoNoticia a) {
		tipo.remove(a);
	}
	
//	public void adicionarNoticiasAnteriores(Noticia a) {
//		noticiasanteriores.add(a);
//	}
//	
//	public void removerNoticiasAnteriores(Noticia a) {
//		noticiasanteriores.remove(a);
//	}

	public SetorNoticia localizarSetor(String nome){
		for(SetorNoticia a : setor){
			if(a.getDescricao().equals(nome))
				return a;
		}
		return null;
	}

	public int getTotalSetor(){
		return setor.size();
	}
	
	public void adicionarSetorNoticia(SetorNoticia t){
		t.cadastrarNoticia(this);
		this.setor.add(t);
	}

	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String txt = "Noticia [id= " + id + ", titulo= " + titulo + ", Conteudo= " + descricao + ", data= " + f.format(data)
				+ ", Caminho do Arquivo= " + nomefoto + ", indpublicar= " + indpublicar + ", nrvisitas= " + nrvisitas + "]" 
			
				+ "Tipo = ";
		if (tipo.isEmpty())
			txt+= "Nenhum tipo cadastrado";
			else
				for (TipoNoticia z: tipo)
					txt+= z.getDescricao()+", " +
			
				 "Setor = ";
		
		if (setor.isEmpty()) 
			txt += "Nenhum setor cadastrado ";
		else
			for (SetorNoticia i: setor)
				txt+= i.getDescricao() +", ";
		return txt;
	}

	
	
}
