package Control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validaciones {
	private JTextField Ingreso;
	private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	
	boolean active = false;
	
	public Validaciones() {
		//super();
		
	}
	//Validar el tamaño y los caracteres, solo permite numeros
	public void validacionSoloNum(JTextField ingresoNum, int Limite, JLabel resp) {
		
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean num = (value>=48 && value<=57) || value==127 || value==8;
				boolean del = value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						resp.setText("");
					} else {
						ingresoNum.setEditable(false);
						resp.setText("Limite alcanzado");
					}
			    }else {
					if (!num) {
						ingresoNum.setEditable(false);
						resp.setText("Solo se pueden ingresar numeros");
						
						//JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros");
						ke.consume();
						
					}else {
						ingresoNum.setEditable(true);
						resp.setText("");
					}
			    }
				
	        }
			
	    });
		
	}
	//Validar el tamaño y los caracteres, solo permite numeros
		public void validacionSoloNumDec(JTextField ingresoNum, int Limite, JLabel resp) {
			
			ingresoNum.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
					int value = ke.getKeyChar();
					boolean num = (value>=48 && value<=57) || value==127 || value==8 || value == 46;
					boolean del = value==8;
					if(ingresoNum.getText().length() >= Limite){
						
						System.out.println(value);
						if (del==true) {
							ingresoNum.setEditable(true);
							resp.setText("");
						} else {
							ingresoNum.setEditable(false);
							resp.setText("Limite alcanzado");
						}
				    }else {
						if (!num) {
							ingresoNum.setEditable(false);
							resp.setText("Solo se pueden ingresar numeros");
							
							//JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros");
							ke.consume();
							
						}else {
							ingresoNum.setEditable(true);
							resp.setText("");
						}
				    }
					
		        }
				
		    });
			
		}
	//Validar el tamaño y los caracteres, solo permite letras
	public void validacionSoloLetras(JTextField ingresoNum, int Limite, JLabel resp) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean letra = ((value>=65 && value<=90) || (value>=97 && value<=122)) ||value==127 || value==8 ||value==32||value==65535;
				boolean del = value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						resp.setText("");
					} else {
						ingresoNum.setEditable(false);
						resp.setText("Limite alcanzado");
					}
			    }else {
					if (!letra) {
						ingresoNum.setEditable(false);
						resp.setText("Solo se pueden ingresar letras mayusculas y minuscolas");
						System.out.println(value);
						//JOptionPane.showMessageDialog(null, "Solo se pueden ingresar letras mayusculas y minuscolas");
						ke.consume();
					}else {
						ingresoNum.setEditable(true);
						resp.setText("");
					}
				}
				
	         }
	    });
	}

	//Validar el tamaño y los caracteres, solo permite letras y numeros
	public void validacionSoloLetYNum(JTextField ingresoNum, int Limite, JLabel resp) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean letra = ((value>=65 && value<=90) || (value>=97 && value<=122)) ||value==127 || value==8 ||value==32||value==65535;
				boolean num = (value>=48 && value<=57) || value==127 || value==8;
				boolean del = value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						resp.setText("");
					} else {
						ingresoNum.setEditable(false);
						resp.setText("Limite alcanzado");
					}
			    }else {
					if (!letra && !num) {
						ingresoNum.setEditable(false);
						resp.setText("Solo se pueden ingresar letras mayusculas y minuscolas");
						System.out.println(value);
						//JOptionPane.showMessageDialog(null, "Solo se pueden ingresar letras mayusculas y minuscolas");
						ke.consume();
					}else {
						ingresoNum.setEditable(true);
						resp.setText("");
					}
				}
			
	         }
	    });
	}
	public void validacionFecha(JTextField ingresoNum, int Limite, JLabel resp) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean letra = (value>=65 && value<=90) || (value>=48 && value<=57) ||value==127 || value==8 || value==65535;
				boolean del = value==8;
				boolean guion = value==45 || value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						resp.setText("");
						
					} else {
						ingresoNum.setEditable(false);
						resp.setText("Limite alcanzado");
					}
			    }else {
					if (!letra) {
						
						String Mes= ingresoNum.getText();
						System.out.println("Posiciones: "+ingresoNum.getText().length()+" el guion activo: "+guion);
						if (ingresoNum.getText().length() == 4) {
							
							ingresoNum.setEditable(true);
							resp.setText("");
						} else if (ingresoNum.getText().length() == 7 && guion) {
							int sSubCadena = Integer.parseInt(Mes.substring(5,7));
							
							if (guion && (sSubCadena>=01 && sSubCadena<=12)) {
								System.out.println("Llego a la 4 posicion, se uso un guion y esta entre 1 y 12");
								ingresoNum.setEditable(true);
								resp.setText("");
							} else {
								System.out.println("Fallo");
								ingresoNum.setEditable(false);
								resp.setText("No existe el mes " + sSubCadena);
							}
						} else {
							ingresoNum.setEditable(false);
							resp.setText("Formato de la fecha: YYYY-MM-DD");
							ke.consume();
						}
						/*
						ingresoNum.setEditable(false);
						resp.setText("Solo se pueden ingresar numeros y letras mayusculas");
						//JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros y letras mayusculas");
						ke.consume();
						*/
					}else {
						String Mes= ingresoNum.getText();
						
						
						
						if (ingresoNum.getText().length() == 4 && !guion) {
							System.out.println("Llego a la 4 posicion");
							ingresoNum.setEditable(false);
							resp.setText("Formato de la fecha: YYYY-MM-DD");
						} else if (ingresoNum.getText().length() == 7 && !guion) {
							ingresoNum.setEditable(false);
							resp.setText("Formato de la fecha: YYYY-MM-DD");
						}else if (ingresoNum.getText().length() == 10) {
							int sSubCadena = Integer.parseInt(Mes.substring(7,10));
							
							if ((sSubCadena>=01 && sSubCadena<=31)) {
								System.out.println("Llego a la 4 posicion, se uso un guion y esta entre 1 y 12");
								ingresoNum.setEditable(true);
								resp.setText("");
							} else {
								System.out.println("Fallo");
								ingresoNum.setEditable(false);
								resp.setText("No existe el mes " + sSubCadena);
							}
						} else {
							ingresoNum.setEditable(true);
							resp.setText("");
						}
						
						//ingresoNum.setEditable(true);
						
						
						
						
						
					}
				}
				
	        }
			
	    });
		
	}
	//Validar el tamaño y los caracteres del RFC
	public void validacionRFC(JTextField ingresoNum, int Limite, JLabel resp) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean letra = (value>=65 && value<=90) || (value>=48 && value<=57) ||value==127 || value==8 || value==65535;
				boolean del = value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						resp.setText("");
						
					} else {
						ingresoNum.setEditable(false);
						resp.setText("Limite alcanzado");
					}
			    }else {
					if (!letra) {
						ingresoNum.setEditable(false);
						resp.setText("Solo se pueden ingresar numeros y letras mayusculas");
						//JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros y letras mayusculas");
						ke.consume();
					}else {
						ingresoNum.setEditable(true);
						resp.setText("");
					}
				}
				
	        }
			
	    });
		
	}
	public void validacionNoExt(JTextField ingresoNum, int Limite, JLabel resp) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean num =(value>=48 && value<=57) ||value==127 || value==8;
				boolean sinN =(value==115 || value == 47 || value ==110);
				boolean del = value==8;
				
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						resp.setText("");
						
					} else {
						ingresoNum.setEditable(false);
						resp.setText("Limite alcanzado");
					}
				}else {
					if (!num && !sinN) {
						ingresoNum.setEditable(false);
						resp.setText("Solo se pueden ingresar numeros o s/n");
						//JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros o s/n");
						ke.consume();
					}else if (ingresoNum.getText().length()>=3) {
						String cadena = ingresoNum.getText().substring(0, 3);
						
						if (cadena.equals("s/n")) {
							
							if (del==true) {
								ingresoNum.setEditable(true);
								resp.setText("");
							}else {
								ingresoNum.setEditable(false);
								resp.setText("ya se escribio s/n");
							}
							
						} else {
							ingresoNum.setEditable(true);
						}
					}else {
						ingresoNum.setEditable(true);
					}
				}
			}
	    });
	}
	//Validar el tamaño del correo
	public void validacionCorreoTamano(JTextField ingresoNum, int Limite, JLabel resp) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean del = value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						resp.setText("");
						
					} else {
						ingresoNum.setEditable(false);
						resp.setText("Limite alcanzado");
					}
			    }
	         }
	    });
	}
	//Validar los caracteres del correo
	public static boolean emailValidator(String email)
	{
		if (email == null) {
			return false;
		}

		Matcher matcher = EMAIL_PATTERN.matcher(email);
		return matcher.matches();
	}
	public boolean validacionCorreoCaracteres(String email, JLabel resp) {
		boolean correo = false;
		if (emailValidator(email)) {
			correo = true;
			resp.setText("");
		}
		else {
			resp.setText("El correo es incorrecto");
			//JOptionPane.showMessageDialog(null, "El correo es incorrecto");
		}
		return correo;
	}
}
