package br.com.javaparaweb.capitulo3.conexao;

import org.hibernate.Session;

public class ConectaHibernateMySQL {
	public static void main(String[] args) {
		Session sessao = null;
		sessao = HibernateUtil.getSessionfactory().openSession();
		sessao.close();
	}
}
