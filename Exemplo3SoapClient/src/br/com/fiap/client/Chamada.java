package br.com.fiap.client;

public class Chamada {

	public static void main(String[] args) {
		AlunoWeb port = new AlunoWebService().getAlunoWebPort();
		
		Aluno a = new Aluno();
		a.setNome("Marcelo Souza da Silva");
		
		Novo parametros = new Novo();
		parametros.setAluno(a);
		
		
		try {
			System.out.println(port.novo(parametros, "fabio", "123").getReturn());
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
	}
}
