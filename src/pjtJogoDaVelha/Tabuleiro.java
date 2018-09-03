package pjtJogoDaVelha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tabuleiro extends JFrame implements ActionListener{
	//atributos
	Boolean jogador = true; 			//	True = O  False = X
	JButton[][] btn = new JButton[3][3];// Matriz de botoes
	
	//CONSTRUTOR: Tabuleiro
	public Tabuleiro(){
		setTitle("Jogo da Velha");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 50);
		setLayout(null);
		init();
		regraVencedor();
		//regraVencedor();
		setVisible(true);
	}
	
	//FUNÇÃO: init
	//DESCRIÇÃO: inicializa objetos da tela JFrame
	private void init() 
	{
		/*	Espaçamento: 140px
		 * 	largura: 	 120px
		 * 	altura: 	 120px
		 * */
		//MATRIZ DE BOTOES
		for(int i=0; i<btn.length; i++) 
		{//linha
			for(int j=0; j<btn.length; j++)
			{//coluna
				btn[i][j] = new JButton();
				btn[i][j].setSize(120,120);
				btn[i][j].setLocation(50+(140*i), 30+(140*j));
				btn[i][j].setText(null);
				cliqueBotao(i, j);
				add(btn[i][j]);
			}
		}		
	}//fim init
	
	public void cliqueBotao(int i, int j) {
		btn[i][j].addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jogador) {
					btn[i][j].setText("X");
					btn[i][j].setEnabled(false);
					jogador = false;
				}else {
					btn[i][j].setText("O");
					btn[i][j].setEnabled(false);
					jogador = true;
				}
			}
		}						
	}//fim cliqueBotao
				);//fim evento
	
	//FUNÇÃO: regraVencedor
	public void regraVencedor() {
		for(int i=0; i < btn.length; i++) {
			for(int j=0; j < btn.length; j++) {
				if(btn[i][j].getText() != null) {//é nulo?
					//regra do trio de linha ex: XXX / OOO
					if(btn[i][j].getText() == btn[i][j+1].getText() && btn[i][j].getText() == btn[i][j+1].getText()) {
						//JOptionPane.showMessageDialog(this, "Você é o Vencedor!");
						System.out.println("ganhou");
					}else
					/*regra do trio de coluna*/
					if(btn[i][j].getText() == btn[i+1][j].getText() && btn[i][j].getText() == btn[i+2][j].getText() ) {
						//JOptionPane.showMessageDialog(this, "Você é o Vencedor!");
						System.out.println("ganhou");
					}
				}	
			}
		}
	}
}

	
	