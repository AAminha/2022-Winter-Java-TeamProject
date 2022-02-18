package recipe_project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ComboBox_CheckBox_Test extends JPanel {
	private static final long serialVersionUID = 1L; //����ȭ ���� �ڵ� - https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=kkson50&logNo=220564273220
	
	JPanel mainPn, Pn1, Pn2, Pn3, Pn4, Pn5; 
	JComboBox<String> combo1, combo2, combo3; 	//���ʴ�� ���ó, ������з�, �������з� �޺��ڽ� 
	JCheckBox b1, b2, b3, b4; 					//üũ�ڽ� 4��
	JLabel l; 									//�� - ����Ʈ �ڸ� ǥ���Ϸ��� �����Ŷ� ���߿� ���� ����
	JButton confirm_b; 							//Ȯ�� ��ư
	
	String[] store = {"������", "������"}; 			//�޺��ڽ� �ȿ� �� ���� �迭
	String[] sd = {"����", "������", "����", "��", "����"};
	String[] cs = {"�Ļ�", "����", "����"};
	
	ComboBox_CheckBox_Test(){
		//�г� ������ ���̾ƿ� ����
		this.setLayout(new GridLayout(2,1)); //��ü ������ ���̾ƿ� (2�� 1��)
		mainPn = new JPanel();
		mainPn.setBorder(new TitledBorder("���� ��õ"));
		
		Pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		Pn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		Pn3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		Pn4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		Pn5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		//�г� ���м� (���߿� ���� �ڵ�)
		Pn1.setBorder(new TitledBorder("���ó")); 
		Pn2.setBorder(new TitledBorder("�з�")); 
		Pn3.setBorder(new TitledBorder("�з�")); 
		Pn4.setBorder(new TitledBorder("���/��"));
		
		//�޺��ڽ� �ʱ�ȭ (�迭�� ������ �޺��ڽ��� �ִ� ����)
		combo1 = new JComboBox<String>(store);
		combo2 = new JComboBox<String>(sd);
		combo3 = new JComboBox<String>(cs);
		
		//��ư, ��, üũ�ڽ� �ʱ�ȭ
		confirm_b = new JButton("Ȯ��");
		l = new JLabel("����Ʈ ��Ÿ�� �ڸ�");
		
		b1 = new JCheckBox("");
		b2 = new JCheckBox("");
		b3 = new JCheckBox("");
		b4 = new JCheckBox("��� ����"); //�� ��ư�� ���� ���ϴ� ���� ��� �ƿ� "��� ����" ���� �ʱ�ȭ�߽��ϴ�
		
		//�� �гο� �޺��ڽ�, ��ư �ֱ�
		Pn1.add(combo1); 
		Pn2.add(combo2); 
		Pn3.add(combo3); 
		Pn4.add(b1); Pn4.add(b2); Pn4.add(b3); Pn4.add(b4);
		Pn5.add(confirm_b);
		
		//���� �гο� ������ �г� �ֱ�
		mainPn.add(Pn1); 
		mainPn.add(Pn2);
		mainPn.add(Pn3); 
		mainPn.add(Pn4);
		mainPn.add(Pn5);
		
		//��ü �гο� ���� �г�, �� �ֱ� (���� �г��� 1��, ���� 2������ ��)
		this.add(mainPn);
		this.add(l);
		
		menu1(combo1.getSelectedIndex());
		start();
	}
	
	public int menu1(int n) { //combo1(������, ������ �� ��1)���� �����ϴ� ���� ���� �г��� ���ü��� �����ϴ� �޼ҵ��Դϴ�. 
		switch(n) {
			case 0 : // ������ ���ý�
				Pn2.setVisible(true);
				Pn4.setVisible(false); //���߿� ������ üũ�ڽ� ���� �ϼ��Ǹ� true�� �ٲٱ� - �ϴ��� �� ���̰� �ص�
				
				Pn3.setVisible(false);
				menu3(combo2.getSelectedIndex());
				return n;
				
			case 1 : // ������ ���ý�
				Pn3.setVisible(true);
				Pn4.setVisible(true);
				
				Pn2.setVisible(false);
				menu2(combo3.getSelectedIndex());
				return n;
				
			default : return -1;
		}
	}
	
	public void menu2(int n) { //combo3(������ - �Ļ�, ����, ���� �� ��1)���� �����ϴ� ���� ���� üũ�ڽ��� ������ �ٲٴ� �޼ҵ��Դϴ�.
		switch(n) {
			case 0 : //�Ļ�
				b3.setVisible(true);
				
				b1.setText("��");
				b2.setText("��");
				b3.setText("��");
				
				return; 
				
			case 1 : //����
				b3.setVisible(true);
				
				b1.setText("���� 1");
				b2.setText("���� 2");
				b3.setText("���� 3");
				
				return; 
			
			case 2 : //����
				b1.setText("������ ��");
				b2.setText("��ŭ�� ��");
				
				b3.setVisible(false);
				return; 
				
			default : return; 
	}
	}
	
	public void menu3(int n) { //combo2(������ - ����, ������, ����, ��, ����)���� �����ϴ� ���� ���� üũ�ڽ��� ������ �ٲٴ� �޼ҵ��Դϴ�.
		// ������� üũ�ڽ� ������ ���� �� �־ ����׽��ϴ�.
	}
	
	public void confirm_click(int n) { //Ȯ�� ��ư Ŭ���� �޺��ڽ�, üũ�ڽ��� �ش��ϴ� ���� �����ͼ� ���� ������ �ٲٴ� �޼ҵ��Դϴ�.
		String m = "";
		
		switch(n) {
			case 0 : // ������ ���ý�
				m += (String)combo1.getSelectedItem() + " " + (String)combo2.getSelectedItem() + " ";
				
				//���߿� ������ üũ�ڽ� �� �����ͼ� �߰��ϴ� �ڵ� �� �ڸ�
				
				m += "�� �ش��ϴ� ����Ʈ ��Ÿ�� �ڸ�";
				l.setText(m);
				return;
				
			case 1 : // ������ ���ý�
				m += (String)combo1.getSelectedItem() + " " + (String)combo3.getSelectedItem() + " ";
				if(b1.isSelected()) m += b1.getText();
				if(b2.isSelected()) m += b2.getText();
				if(b3.isSelected()) m += b3.getText(); //b4�� "��� ����"��ư �̶� �� ������ �ʿ� X
				
				m += "�� �ش��ϴ� ����Ʈ ��Ÿ�� �ڸ�";
				l.setText(m); //�޺��ڽ�, üũ�ڽ����� ���õ� ������ ���������� �󺧿��� Ȯ�� 
				return;
				
			default : return;
		}
		
		
	}
	
	public void b_Initialization(int n) { //üũ�ڽ��� ���¸� �ʱ�ȭ�ϴ� �޼ҵ��Դϴ�.
		b1.setSelected(false); 
		b2.setSelected(false);
		b3.setSelected(false);
		if(n == 0) b4.setSelected(false); //�޺��ڽ��� �̺�Ʈ �߻��Ҷ��� �Ķ���͸� 0���� �༭ ������ ��ư���� �ʱ�ȭ 
	}
	
	public void b4_Initialization() { //"�������" ���� �� �ٽ� �ٸ� üũ�ڽ��� Ŭ���ϸ� "�������" ��ư���� üũ�� �����ǵ��� �ϴ� ������ �޼ҵ��Դϴ�.
		if(b1.isSelected() || b2.isSelected() || b3.isSelected()) 
			b4.setSelected(false);	
	}
	
	public void start() { //�޺��ڽ�, üũ�ڽ�, ��ư���� �߻��ϴ� Ŭ�� �̺�Ʈ�� ó���ϴ� �޼ҵ��Դϴ�.
		//���ó �޺��ڽ�
		combo1.addItemListener(e -> { 
			menu1(combo1.getSelectedIndex());
			b_Initialization(0);
		});	 
		
		//(������)�з� �޺��ڽ� 
		combo2.addItemListener(e -> { 
			menu3(combo2.getSelectedIndex()); 
			b_Initialization(0); 
		}); 
		
		//(������)�з� �޺��ڽ� 
		combo3.addItemListener(e -> { 
			menu2(combo3.getSelectedIndex()); 
			b_Initialization(0);	
		}); 
		
		confirm_b.addActionListener(e -> { confirm_click(menu1(combo1.getSelectedIndex())); }); //Ȯ�� ��ư
		
		b1.addActionListener(e -> { b4_Initialization(); }); //üũ�ڽ� 1/2/3�� �̺�Ʈ �߻��� "�������" ��ư(4)�� �ʱ�ȭ�մϴ�.
		b2.addActionListener(e -> { b4_Initialization(); });
		b3.addActionListener(e -> { b4_Initialization(); });
		b4.addActionListener(e -> { b_Initialization(1);} ); //üũ�ڽ����� "�������"(4)�� ���ý� ������ üũ�ڽ�(1/2/3)�� �ʱ�ȭ�˴ϴ�.
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("������ ��õ ���α׷�");
		frame.getContentPane().add(new ComboBox_CheckBox_Test());
		
		frame.setBounds(300, 200, 600, 450); //��: ���α׷� ����� ȭ�� �� x/y ��ǥ + ��: ���α׷� ���� ���� ���� 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
