package com.fiap.exemplos.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class AlunoWeb {
	
	@Resource
	WebServiceContext wsctx;
	
	private List<Aluno> alunos;
	
    public AlunoWeb(){
    	alunos = new ArrayList<Aluno>();
    }
    
    private boolean autenticado(String usuario, String senha){   	   	
    	if(usuario.equals("fabio") && senha.equals("123")) return true;
    	else return false;
    }
    
    @WebMethod
    public String novo(@WebParam(name="Aluno", header=false) Aluno a,
    		           @WebParam(name="Usuario", header=true) String usuario,
    				   @WebParam(name="Senha", header=true) String senha) throws Exception{
    	if(this.autenticado(usuario, senha)){
        	this.alunos.add(a);
        	return "Sucesso. Felicidade";    		
    	}
    	else{
    		throw new Exception("Usuário ou Senha Inválida");
    	}
    }
    
    @WebMethod
    public List<Aluno> listar(@WebParam(name="Usuario", header=true) String usuario,
			                  @WebParam(name="Senha", header=true) String senha) throws Exception{
    	if(this.autenticado(usuario, senha))	return this.alunos;
    	else throw new Exception("Usuário ou Senha Inválida");
    }
    
	
}
