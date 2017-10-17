package br.com.aluno;

public class Aluno {
	private String classe;
	private String categoria;
	
	public String definirClasse(int ano) {
			if(ano<=2000) {
				classe = "ADULTO";
			} else if(ano<=2003) {
				classe = "SUB 18";
			} else if(ano<=2005) {
				classe = "SUB 15";
			} else if(ano<=2007) {
				classe = "SUB 13";
			} else if(ano<=2009) {
				classe = "SUB 11";
			} else if(ano<=2011) {
				classe = "SUB 9";
			} 
			return classe;
	}
	public String definirCategoria(String classe, char sexo, double peso) {
		if(sexo == 'M') {
			if(classe.equals("SUB 9")) {
				if(peso<=23) {
					categoria = "S.LIGEIRO";
				} else if(peso<=26) {
					categoria = "LIGEIRO";
				} else if(peso<=29) {
					categoria = "M.LEVE";
				} else if(peso<=32) {
					categoria = "LEVE";
				} else if(peso<=36) {
					categoria = "M.M�DIO";
				} else if(peso<=40) {
					categoria = "M�DIO";
				} else if(peso<=45) {
					categoria = "M.PESADO";
				} else if(peso<=50) {
					categoria = "PESADO";
				} else {
					categoria = "S.PESADO";
				}
			} else if(classe.equals("SUB 11")){
				if(peso<=28) {
					categoria = "S.LIGEIRO";
				} else if(peso<=30) {
					categoria = "LIGEIRO";
				} else if(peso<=33) {
					categoria = "M.LEVE";
				} else if(peso<=36) {
					categoria = "LEVE";
				} else if(peso<=40) {
					categoria = "M.M�DIO";
				} else if(peso<=45) {
					categoria = "M�DIO";
				} else if(peso<=50) {
					categoria = "M.PESADO";
				} else if(peso<=55) {
					categoria = "PESADO";
				} else if(peso<=60){
					categoria = "S.PESADO";
				} else {
					categoria = "E.PESADO";
				}
			} else if(classe.equals("SUB 13")){
				if(peso<=28) {
					categoria = "S.LIGEIRO";
				} else if(peso<=31) {
					categoria = "LIGEIRO";
				} else if(peso<=34) {
					categoria = "M.LEVE";
				} else if(peso<=38) {
					categoria = "LEVE";
				} else if(peso<=42) {
					categoria = "M.M�DIO";
				} else if(peso<=47) {
					categoria = "M�DIO";
				} else if(peso<=52) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				}
			} else if(classe.equals("SUB 15")){
				if(peso<=36) {
					categoria = "S.LIGEIRO";
				} else if(peso<=40) {
					categoria = "LIGEIRO";
				} else if(peso<=44) {
					categoria = "M.LEVE";
				} else if(peso<=48) {
					categoria = "LEVE";
				} else if(peso<=53) {
					categoria = "M.M�DIO";
				} else if(peso<=58) {
					categoria = "M�DIO";
				} else if(peso<=64) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				}
			} else if(classe.equals("SUB 18")){
				if(peso<=50) {
					categoria = "S.LIGEIRO";
				} else if(peso<=55) {
					categoria = "LIGEIRO";
				} else if(peso<=60) {
					categoria = "M.LEVE";
				} else if(peso<=66) {
					categoria = "LEVE";
				} else if(peso<=73) {
					categoria = "M.M�DIO";
				} else if(peso<=81) {
					categoria = "M�DIO";
				} else if(peso<=90) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				}
			} else if(classe.equals("ADULTO")){
				if(peso<=55) {
					categoria = "S.LIGEIRO";
				} else if(peso<=60) {
					categoria = "LIGEIRO";
				} else if(peso<=66) {
					categoria = "M.LEVE";
				} else if(peso<=73) {
					categoria = "LEVE";
				} else if(peso<=81) {
					categoria = "M.M�DIO";
				} else if(peso<=90) {
					categoria = "M�DIO";
				} else if(peso<=100) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				}
			}
		} else if (sexo == 'F') {
			if(classe.equals("SUB 9")){
				if(peso<=23) {
					categoria = "S.LIGEIRO";
				} else if(peso<=26) {
					categoria = "LIGEIRO";
				} else if(peso<=29) {
					categoria = "M.LEVE";
				} else if(peso<=32) {
					categoria = "LEVE";
				} else if(peso<=36) {
					categoria = "M.M�DIO";
				} else if(peso<=40) {
					categoria = "M�DIO";
				} else if(peso<=45) {
					categoria = "M.PESADO";
				} else if(peso<=50) {
					categoria = "PESADO";
				} else{
					categoria = "S.PESADO";
				} 
			} else if(classe.equals("SUB 11")){
				if(peso<=28) {
					categoria = "S.LIGEIRO";
				} else if(peso<=30) {
					categoria = "LIGEIRO";
				} else if(peso<=33) {
					categoria = "M.LEVE";
				} else if(peso<=36) {
					categoria = "LEVE";
				} else if(peso<=40) {
					categoria = "M.M�DIO";
				} else if(peso<=45) {
					categoria = "M�DIO";
				} else if(peso<=50) {
					categoria = "M.PESADO";
				} else if(peso<=55) {
					categoria = "PESADO";
				} else{
					categoria = "S.PESADO";
				}
			}else if(classe.equals("SUB 13")){
				if(peso<=28) {
					categoria = "S.LIGEIRO";
				} else if(peso<=31) {
					categoria = "LIGEIRO";
				} else if(peso<=34) {
					categoria = "M.LEVE";
				} else if(peso<=38) {
					categoria = "LEVE";
				} else if(peso<=42) {
					categoria = "M.M�DIO";
				} else if(peso<=47) {
					categoria = "M�DIO";
				} else if(peso<=52) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				} 	
			} else if(classe.equals("SUB 15")){
				if(peso<=36) {
					categoria = "S.LIGEIRO";
				} else if(peso<=40) {
					categoria = "LIGEIRO";
				} else if(peso<=44) {
					categoria = "M.LEVE";
				} else if(peso<=48) {
					categoria = "LEVE";
				} else if(peso<=53) {
					categoria = "M.M�DIO";
				} else if(peso<=58) {
					categoria = "M�DIO";
				} else if(peso<=64) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				} 	
			} else if(classe.equals("SUB 18")){
				if(peso<=40) {
					categoria = "S.LIGEIRO";
				} else if(peso<=44) {
					categoria = "LIGEIRO";
				} else if(peso<=48) {
					categoria = "M.LEVE";
				} else if(peso<=52) {
					categoria = "LEVE";
				} else if(peso<=57) {
					categoria = "M.M�DIO";
				} else if(peso<=63) {
					categoria = "M�DIO";
				} else if(peso<=70) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				} 	
			} else if(classe.equals("ADULTO")){
				if(peso<=44) {
					categoria = "S.LIGEIRO";
				} else if(peso<=48) {
					categoria = "LIGEIRO";
				} else if(peso<=52) {
					categoria = "M.LEVE";
				} else if(peso<=57) {
					categoria = "LEVE";
				} else if(peso<=63) {
					categoria = "M.M�DIO";
				} else if(peso<=70) {
					categoria = "M�DIO";
				} else if(peso<=78) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				} 	
			}
		}
		return categoria;
	}
	
}































