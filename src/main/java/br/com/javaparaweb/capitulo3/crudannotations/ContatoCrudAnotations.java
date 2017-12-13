package br.com.javaparaweb.capitulo3.crudannotations;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.javaparaweb.capitulo3.conexao.HibernateUtil;

public class ContatoCrudAnotations {
	private Session sessao;
	
	public ContatoCrudAnotations(Session sessao) {
		this.sessao = sessao;
	}
	
	public void salvar(Contato contato) {
		sessao.save(contato);
	}
	
	public void atualizar(Contato contato) {
		sessao.update(contato);
		
	}
	
	public void excluir(Contato contato) {
		sessao.delete(contato);
	}
	
	public List<Contato> listar(){
		Query consulta = sessao.createQuery("from Contato");
		return consulta.list();
	}
	
	public Contato buscaContato(int valor) {
		Query consulta = sessao.createQuery("from Contato where codigo = :parametro");
		consulta.setInteger("parametro", valor);
		return (Contato) consulta.uniqueResult();
	}
	
	public static void main(String[] arg) {
		
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		org.hibernate.Transaction transacao = sessao.beginTransaction();
		ContatoCrudAnotations contatoCrud = new ContatoCrudAnotations(sessao);
		
		Contato contato= new Contato();
		
		contato = contatoCrud.buscaContato(2);
		
		
		sessao.close();
		
		
		
	}
}
