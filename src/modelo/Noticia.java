package modelo;
import java.text.SimpleDateFormat;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * José Raimundo Fernandes Filho
 **********************************/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Noticia {
	
	private int id;
	private String titulo;
	private String descricao;
	private Date data = new Date();
	private String nomefoto;
	private boolean indpublicar;
	private int nrvisitas;
	private TipoNoticia tipo;
	private List<SetorNoticia> setor = new ArrayList<SetorNoticia>();
	private List<Noticia> noticiasanteriores = new ArrayList<Noticia>();
	
	public Noticia(int id, String titulo, String descricao, TipoNoticia tipo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipo = tipo;
		
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

	public boolean isIndpublicar() {
		return indpublicar;
	}

	public void setIndpublicar(boolean indpublicar) {
		this.indpublicar = indpublicar;
	}

	public int getNrvisitas() {
		return nrvisitas;
	}

	public void setNrvisitas(int nrvisitas) {
		this.nrvisitas = nrvisitas;
	}

	public TipoNoticia getTipo() {
		return tipo;
	}

	public void setTipo(TipoNoticia tipo) {
		this.tipo = tipo;
	}

	public List<SetorNoticia> getSetor() {
		return setor;
	}

	public void adicionarSetor(SetorNoticia a) {
		setor.add(a);
	}
	
	public void removerSetor(SetorNoticia a) {
		setor.remove(a);
	}
	
	public void adicionarNoticiasAnteriores(Noticia a) {
		noticiasanteriores.add(a);
	}
	
	public void removerNoticiasAnteriores(Noticia a) {
		noticiasanteriores.remove(a);
	}

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
				+ (tipo.getDescricao() != null ? "Publicacao = " + tipo.getDescricao() : "nao indentificado ") + "Setor = ";
		
		if (setor.isEmpty()) 
			txt += "Nenhum setor cadastrado ";
		else
			for (SetorNoticia i: setor)
				txt+= i.getDescricao() +", ";
		return txt;
	}

	
	
}
