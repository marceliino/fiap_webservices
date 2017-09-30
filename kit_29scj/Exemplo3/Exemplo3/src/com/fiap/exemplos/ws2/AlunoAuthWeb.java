package com.fiap.exemplos.ws2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class AlunoAuthWeb {
	
	@Resource
	WebServiceContext wsctx;
	
	private List<Aluno> alunos;
	
    public AlunoAuthWeb(){
    	alunos = new ArrayList<Aluno>();
    }
    
    private boolean autenticado(){
    	MessageContext mctx = wsctx.getMessageContext();
    	Map http_headers = (Map)mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
    	
    	List usuarios = (List) http_headers.get("Username");
    	List senhas = (List) http_headers.get("Senha");
    	
    	if(usuarios==null||senhas==null) return false;
    	
    	String usuario = usuarios.get(0).toString();
    	String senha = senhas.get(0).toString();
    	
    	if(usuario.equals("fabio") && senha.equals("123")) return true;
    	else return false;
    }
    
    @WebMethod
    public String novo(Aluno a) throws Exception{
    	if(this.autenticado()){
        	this.alunos.add(a);
        	return "Sucesso. Felicidade";    		
    	}
    	else{
    		throw new Exception("Usuário ou Senha Inválida");
    	}
    }
    
    @WebMethod
    public List<Aluno> listar() throws Exception{
    	if(this.autenticado())	return this.alunos;
    	else throw new Exception("Usuário ou Senha Inválida");
    }
    
	
}
