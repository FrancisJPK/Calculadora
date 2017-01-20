//19-1-17-10:00 pm
/*hoy me desperte sin el conocimiento nesesario para hacer algo como esta calculadora, a base de buscar
 * y rebuscar herramientas, informacion etc., me abri paso a utilizar LAYOUTS, colores, fuentes, y alguna
 * que otra cosa mas... yo se que esto es una tonteria pero como principiante estoy contento de haber
 * logrado esto por mi cuenbta sin seguir un tutorial y guiandome por investigación de distintas áreas
 * y recibiendo influencia de los cursos que segui (actualmente sigo solo 1)*/

package Calculadora;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Calculadora extends JFrame implements ActionListener{
	
	
	private JButton[] numeros;
	private JButton[] operaciones;
	private JPanel padNum,padOp,lcd;
	private String[] simbolosOperaciones = {"+","_","/","X","RESET"};
	private JLabel numeroActual;
	private double a=0,b=0,resultado=0;
	private JLabel actual,aux1,aux2;
	private String operacion = "";
	private boolean igual = false;
	private JButton botonIgual;
	
	public Calculadora(){
		//no usamos layout para el contenido de la ventana porque usamos JPanel's
		setLayout(null);
		//Inicializamos los JPanel's y el numeroActual que se mostrara en la pantalla
		Color color1 = new Color(150, 200, 200);
		padNum = new JPanel(new GridLayout(4,3));
		padNum.setBackground(Color.BLACK);
		padOp = new JPanel(new GridLayout(6,1));
		padOp.setBackground(Color.BLACK);
		lcd = new JPanel();
		lcd.setBackground(color1);
		numeroActual = new JLabel("");
		numeroActual.setFont(new Font("Impact", Font.BOLD, 30));
		actual = new JLabel("A:");
		actual.setFont(new Font("Impact", Font.BOLD, 30));
		//aux1 = new JLabel(""+a);
		//aux2 = new JLabel(""+b);
		botonIgual = new JButton("=");
		//Inicializamos los botones del pad numerico-----------------------------------------------------------------
		Color color2 = new Color(200, 200, 200);
		numeros = new JButton[10];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = new JButton(""+(i));
			numeros[i].setBackground(color2);
			numeros[i].addActionListener(this);
			numeros[i].setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
			padNum.add(numeros[i]);
		}
		
		//inicializamos los botones del pad de operaciones------------------------------------------------------------
		operaciones = new JButton[simbolosOperaciones.length];
		for (int i = 0; i < simbolosOperaciones.length; i++) {
			operaciones[i] = new JButton(simbolosOperaciones[i]);
			operaciones[i].setBackground(color2);
			operaciones[i].addActionListener(this);
			operaciones[i].setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
			padOp.add(operaciones[i]);
		}
		botonIgual.addActionListener(this);
		botonIgual.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		padOp.add(botonIgual);
		
		//configuramos los pads y pantalla---------------------------------------------------------------------------
		padNum.setBounds(10, 120, 220, 220);
		padNum.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));//metodo para generar borde vacio
		add(padNum);
		padOp.setBounds(250, 120, 120, 220);
		padOp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		add(padOp);
		lcd.setBounds(10, 10, 360, 80);
		lcd.add(actual);
		lcd.add(numeroActual);
		/*
		pantalla.add(aux1);
		pantalla.add(aux2);
		*///estos eran de ayuda
		add(lcd);
	}
	
	//boton presionado-----------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e) {
		
		//detectar boton numerico------------------------------------------------------------------------------------
		for (int i = 0; i < numeros.length; i++) {
			if(operacion == ""){
				if(e.getSource()==numeros[i]){
					actual.setText("A:");
					numeroActual.setText(numeroActual.getText()+(i));
					a = Integer.parseInt(numeroActual.getText());
					//aux1.setText(""+a);
					
				}
			}else{
				if(e.getSource()==numeros[i]){
					numeroActual.setText(numeroActual.getText()+(i));
					b = Integer.parseInt(numeroActual.getText());
					//aux2.setText(""+b);
				}
			}
		}
		
		//detectar boton de operacion--------------------------------------------------------------------------------
		for (int i = 0; i < operaciones.length; i++) {
			if(e.getSource()==operaciones[i]||e.getSource()==botonIgual){
				if(e.getSource()!=botonIgual){
				operacion = operaciones[i].getText();
				}
				//si apreto igual:----------------------------------------------------------------------------------
				if(e.getSource()==botonIgual){
					igual=true;
				}else{
					igual=false;
				}
				if(igual==true&&resultado==0){
					if(operacion == "+"){
						actual.setText("Resultado:");
						resultado = a+b;
						numeroActual.setText(""+resultado);
						operacion = "";
						a = 0.0;
						b= 0.0;
						operacion = "";
					}
					if(operacion == "_"){
						actual.setText("Resultado:");
						resultado = a-b;
						numeroActual.setText(""+resultado);
						operacion = "";
						a = 0.0;
						b= 0.0;
						operacion = "";
					}
					if(operacion == "/"){
						actual.setText("Resultado:");
						resultado = a/b;
						numeroActual.setText(""+resultado);
						operacion = "";
						a = 0.0;
						b= 0.0;
						operacion = "";
					}
					if(operacion == "X"){
						actual.setText("Resultado:");
						resultado = a*b;
						numeroActual.setText(""+resultado);
						operacion = "";
						a = 0.0;
						b= 0.0;
						operacion = "";
					}
				}else if(igual==true&&resultado!=0.00000000){
					if(operacion == "+"){
						actual.setText("Resultado:");
						resultado = resultado+b;
						numeroActual.setText(""+resultado);
						operacion = "";
						a = 0.0;
						b= 0.0;
						operacion = "";
					}
					if(operacion == "_"){
						actual.setText("Resultado:");
						resultado = resultado-b;
						numeroActual.setText(""+resultado);
						operacion = "";
						a = 0.0;
						b= 0.0;
						operacion = "";
					}
					if(operacion == "/"){
						actual.setText("Resultado:");
						resultado = resultado/b;
						numeroActual.setText(""+resultado);
						operacion = "";
						a = 0.0;
						b= 0.0;
						operacion = "";
					}
					if(operacion == "X"){
						actual.setText("Resultado:");
						resultado = resultado*b;
						numeroActual.setText(""+resultado);
						operacion = "";
						a = 0.0;
						b= 0.0;
						operacion = "";
					}
				}
				
				//Si apreto otras operaciones:------------------------------------------------------------------------
				if(operacion == "+"){
					numeroActual.setText("");
					actual.setText("B:");
				}
				if(operacion == "_"){
					numeroActual.setText("");
					actual.setText("B:");
				}
				if(operacion == "/"){
					numeroActual.setText("");
					actual.setText("B:");
				}
				if(operacion == "X"){
					numeroActual.setText("");
					actual.setText("B:");
				}
				if(operacion == "Reset"){
					numeroActual.setText("");
					actual.setText("A:");
					a = 0.0;
					b= 0.0;
					resultado=0.0;
					operacion = "";
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Color co = new Color(205,205,205);
		Calculadora c = new Calculadora();
		c.setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.setVisible(true);
		c.setBounds(100,100,400,400);
		c.getContentPane().setBackground(co);
	}

	
	
}
