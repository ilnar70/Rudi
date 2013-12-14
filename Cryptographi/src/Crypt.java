import java.io.*;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
public class Crypt extends Frame 
{
	public Crypt()
	{
		super("���������� RSA");
		this.setSize(450, 300);
		this.setResizable(false);
		setFont(new Font("Serif",Font.PLAIN,16));
		Panel pSchifr = new Panel();	
		pSchifr.setBounds(10, 30, 200, 300);
		Label l1 = new Label("����������", Label.LEFT);	
        l1.setBounds(40,10,100,20);						
        pSchifr.add(l1);	
        
        Label l2 = new Label("������� �: ", Label.LEFT);	
        l2.setBounds(10,50,100,20);						
        pSchifr.add(l2);	
        
        TextField tfE = new TextField();						//�������� ���������� ���� tfResult
        tfE.setBounds(130, 50, 50, 25);							//��������� ��������� � �������� tfResult
        pSchifr.add(tfE);			
        
        Label l3 = new Label("������� n*: ", Label.LEFT);	
        l3.setBounds(10,80,100,20);						
        pSchifr.add(l3);	
        
        TextField tfN = new TextField();						//�������� ���������� ���� tfResult
        tfN.setBounds(130, 80, 50, 25);							//��������� ��������� � �������� tfResult
        pSchifr.add(tfN);
        
        
        Label l17 = new Label("* n>255", Label.LEFT);	
        l17.setBounds(20,220,70,20);						
        pSchifr.add(l17);
        
        
        
        Label l4 = new Label("������� ����: ", Label.LEFT);	
        l4.setBounds(10,110,120,20);						
        pSchifr.add(l4);	
        
        TextField tfInputFile = new TextField();						//�������� ���������� ���� tfResult
        tfInputFile.setBounds(130, 110, 50, 25);							//��������� ��������� � �������� tfResult
        pSchifr.add(tfInputFile);			
        
        Label l5 = new Label("�������� ����: ", Label.LEFT);	
        l5.setBounds(10,140,120,20);						
        pSchifr.add(l5);	
        
        //Label l13 = new Label("�����������", Label.LEFT);	
        //l13.setBounds(10,230,120,20);						
        //pSchifr.add(l13);
        
        TextField tfOutputFile = new TextField();						//�������� ���������� ���� tfResult
        tfOutputFile.setBounds(130, 140, 50, 25);							//��������� ��������� � �������� tfResult
        pSchifr.add(tfOutputFile);
        
        Button bSchifr = new Button("�����������");			//�������� ������ bCalculate
        bSchifr.setBounds(30, 180, 130, 30);
        pSchifr.add(bSchifr);
        
        pSchifr.setLayout(null);	
        add(pSchifr);
		
        
        
        Panel pDeschifr = new Panel();	
        pDeschifr.setBounds(0, 0, 400, 300);
		Label l6 = new Label("������������", Label.CENTER);	
		l6.setBounds(40+210,10,120,20);						
        pDeschifr.add(l6);	
        
        Label l7 = new Label("������� d: ", Label.LEFT);	
        l7.setBounds(10+210,50,100,20);						
        pDeschifr.add(l7);	
        
        TextField tfD = new TextField();						//�������� ���������� ���� tfResult
        tfD.setBounds(130+210, 50, 50, 25);							//��������� ��������� � �������� tfResult
        pDeschifr.add(tfD);			
        
        Label l8 = new Label("������� n*: ", Label.LEFT);	
        l8.setBounds(10+210,80,100,20);						
        pDeschifr.add(l8);	
        
        TextField tfNdesh = new TextField();						//�������� ���������� ���� tfResult
        tfNdesh.setBounds(130+210, 80, 50, 25);							//��������� ��������� � �������� tfResult
        pDeschifr.add(tfNdesh);
        
        
        
        
        Label l9 = new Label("������� ����: ", Label.LEFT);	
        l9.setBounds(10+210,110,100,20);						
        pDeschifr.add(l9);	
        
        TextField tfInputFileDesch = new TextField();						//�������� ���������� ���� tfResult
        tfInputFileDesch.setBounds(130+210, 110, 50, 25);							//��������� ��������� � �������� tfResult
        pDeschifr.add(tfInputFileDesch);			
        
        Label l10 = new Label("�������� ����: ", Label.LEFT);	
        l10.setBounds(10+210,140,120,20);						
        pDeschifr.add(l10);	
        
        TextField tfOutputFileDesch = new TextField();						//�������� ���������� ���� tfResult
        tfOutputFileDesch.setBounds(130+210, 140, 50, 25);							//��������� ��������� � �������� tfResult
        pDeschifr.add(tfOutputFileDesch);
        
        Button bDeschifr = new Button("�����������");			//�������� ������ bCalculate
        bDeschifr.setBounds(30+210, 180, 130, 30);
        pDeschifr.add(bDeschifr);
        
        pDeschifr.setLayout(null);	
        add(pDeschifr);
        
        bSchifr.addActionListener(new ButtonClick(tfE,tfN,tfInputFile,tfOutputFile, true));	
        bDeschifr.addActionListener(new ButtonClick(tfD,tfNdesh,tfInputFileDesch,tfOutputFileDesch, false));	
        
		this.addWindowListener(new WindowAdapter()	//��������� ���������� ������� ��� ������� ����� ��� ��������� ������� ������ WindowEvent. 
        {	//��� ����� ������� ���������� ��������� �����, ���������� � ������-�������� WindowAdapter �
            public void windowClosing(WindowEvent ev)  	//��������� ����� windowClosing, ������� ����� ���������� ��� ������� ������ ALT+F4 
            { 											//��� ��� ������� ��������
                System.exit(0);							//��������� ������ ���������
            }	//����� ���� ������ windowClosing
        }); //����� ���� ����������� ���������� ������
		
		
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) throws IOException
	{
		
		new Crypt();
		
		/*
		FileInputStream dis = new FileInputStream("1.txt");
		
		//FileOutputStream dos = new FileOutputStream("2.txt");
		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("2.txt"));
		
		int nextByte = dis.read();
		while(nextByte!=-1)
		{
			int b = nextByte;
			
			if(b>0)
			{
				System.out.print("b= "+b);
				System.out.print(" ������= "+(char)b);
				int k = shifr(53,299,b);
				System.out.println(" k="+k);
				dos.writeInt(k);
				
			
			}
			nextByte = dis.read();
		}
		dis.close();
		dos.close();
		
		System.out.println("�����������:");
		DataInputStream dis2 = new DataInputStream(new FileInputStream("2.txt"));
		FileOutputStream dos2 = new FileOutputStream("3.txt");
		while(true)
		{
			try
			{
				int b = dis2.readInt();
				System.out.print("b= "+b);
				int k = deshifr(5,299,b);
				System.out.print(" k="+k);
				System.out.println(" ������= "+(char)k);
				dos2.write(k);
			}
			catch(IOException e)
			{
				System.out.println("���� ������� ���������.");
				break;
			}
		}
		dis2.close();
		dos2.close();
		
		
		/*FileInputStream dis = new FileInputStream("1.txt");
		
		//FileOutputStream dos = new FileOutputStream("2.txt");
		
		FileOutputStream dos = new FileOutputStream("2.txt");
		
		int nextByte = dis.read();
		while(nextByte!=-1)
		{
			byte b = (byte)nextByte;
			System.out.print("b= "+b);
			System.out.print(" ������= "+(char)b);
			int k = shifr(53,299,b);
			System.out.println(" k="+k);
			dos.write(k);
			nextByte = dis.read();
		}
		
		dis.close();
		dos.close();
		
		System.out.println("�����������:");
		FileInputStream dis2 = new FileInputStream("2.txt");
		FileOutputStream dos2 = new FileOutputStream("3.txt");
		
		nextByte = dis2.read();
		while(nextByte!=-1)
		{
			int b = nextByte;
			System.out.print("b= "+b);
			int k = deshifr(5,299,b);
			System.out.print(" k="+k);
			System.out.println(" ������= "+(char)k);
			dos2.write(k);		
			nextByte = dis2.read();
		}
		System.out.println("���� ������� ���������.");
		dis2.close();
		dos2.close();
		
		
		
		System.out.println("��� ��, ���!");
		*/
	}
	
	public static int shifr(int e, int n, int c)
	{
		BigInteger b;
		b = BigInteger.valueOf(c);
		b = b.pow(e);
		b = b.mod(BigInteger.valueOf(n));
		
		return b.intValue();
	}
	
	public static int deshifr(int d, int n, int c)
	{
		BigInteger b;
		b = BigInteger.valueOf(c);
		b = b.pow(d);
		b = b.mod(BigInteger.valueOf(n));
		return b.intValue();
	}

	public class ButtonClick implements ActionListener
	{
		TextField tfE;
		TextField tfD;
		TextField tfN;
		TextField tfInputFile;
		TextField tfOutputFile;
		Boolean bSchifr;
		public ButtonClick(TextField e, TextField n, TextField inputFile, TextField outputFile, boolean type)
		{
			this.bSchifr = type;
			if(type) 
				this.tfE = e;
			else 
				this.tfD = e;
			this.tfN = n;
			this.tfInputFile = inputFile;
			this.tfOutputFile = outputFile;
		}
		public void actionPerformed(ActionEvent arg0)
		{		
			if(bSchifr)
			{
				FileInputStream dis = null;
				try {
					dis = new FileInputStream(tfInputFile.getText());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//FileOutputStream dos = new FileOutputStream("2.txt");
				
				DataOutputStream dos = null;
				try {
					dos = new DataOutputStream(new FileOutputStream(tfOutputFile.getText()));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int nextByte = 0;
				try {
					nextByte = dis.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(nextByte!=-1)
				{
					int b = nextByte;
					
					if(b>0)
					{
						//System.out.print("b= "+b);
						//System.out.print(" ������= "+(char)b);
						int k = shifr(Integer.parseInt(tfE.getText()),Integer.parseInt(tfN.getText()),b);
						//System.out.println(" k="+k);
						try {
							dos.writeInt(k);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					
					}
					try {
						nextByte = dis.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else //����������
			{
				//System.out.println("�����������:");
				DataInputStream dis2 = null;
				try {
					dis2 = new DataInputStream(new FileInputStream(tfInputFile.getText()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FileOutputStream dos2 = null;
				try {
					dos2 = new FileOutputStream(tfOutputFile.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while(true)
				{
					try
					{
						int b = dis2.readInt();
						//System.out.print("b= "+b);
						int k = deshifr(Integer.parseInt(tfD.getText()),Integer.parseInt(tfN.getText()),b);
						//System.out.print(" k="+k);
						//System.out.println(" ������= "+(char)k);
						dos2.write(k);
					}
					catch(IOException e)
					{
						//System.out.println("���� ������� ���������.");
						break;
					}
				}
				try {
					dis2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					dos2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
