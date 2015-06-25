package br.edu.ifg.tads.mtp.eventif.util;

import br.edu.ifg.tads.mtp.eventif.view.LoginView;

public class VerificaCamposCriarLogin {
	private LoginView login;
	public boolean getVerificaCamposCriarLogin(LoginView login){
		boolean verify = true;
		this.login = login;
		
		if(login.getTfLogin().getText().isEmpty()){
			verify = false;
		}else if(login.getTfSenha().getText().isEmpty()){
			verify = false;
		}
		return verify;
	}
	
}
