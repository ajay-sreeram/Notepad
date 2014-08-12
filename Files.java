import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.lang.*;
/*<applet code="Files" width=500 height=500></applet>*/
public class Files extends Frame implements ActionListener,WindowListener
{
String name,edits;
TextArea ta;
Font font;
public Files()
{
addWindowListener(this);
//setLayout(new FlowLayout(FlowLayout.LEFT));
setLayout(null);
name="";
MenuBar me=new MenuBar();
setMenuBar(me);
Menu file=new Menu("File");Menu edit=new Menu("Edit");Menu format=new Menu("Format");Menu cal=new Menu("Calculator");
MenuItem calc=new MenuItem("calculator");
MenuItem mf1=new MenuItem("new");
MenuItem mf2=new MenuItem("open");
MenuItem mf3=new MenuItem("save");
MenuItem mf4=new MenuItem("exit");
MenuItem mf5=new MenuItem("delete");
MenuItem mfo=new MenuItem("font");
file.add(mf1);file.add(mf2);file.add(mf3);file.add(mf5);file.add(mf4);
me.add(file);cal.add(calc);
mf1.addActionListener(this);mfo.addActionListener(this);
mf2.addActionListener(this);
mf3.addActionListener(this);
mf4.addActionListener(this);
mf5.addActionListener(this);
MenuItem me1=new MenuItem("cut");
MenuItem me2=new MenuItem("copy");
MenuItem me3=new MenuItem("paste");
MenuItem me4=new MenuItem("remove");

edit.add(me1);edit.add(me2);edit.add(me3);edit.add(me4);
me.add(edit);me.add(format);format.add(mfo);
me.add(cal);calc.addActionListener(this);
me1.addActionListener(this);
me2.addActionListener(this);
me3.addActionListener(this);
me4.addActionListener(this);
ta=new TextArea();
ta.setFont(new Font("cambria",Font.ITALIC,20));
ta.setBounds(15,50,1280,620);
add(ta);
}


public void actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
if(s.equals("open"))
{Open p=new Open(this);}
if(s.equals("new"))
{String a2="";ta.setText(a2);this.setTitle("Notepad");}
if(s.equals("exit")){System.exit(0);}
if(s.equals("save")){Save aj=new Save(this);}
if(s.equals("font")){Fontb1 ay=new Fontb1(this);}
if(s.equals("calculator")){Calculator srav=new Calculator();}
if(s.equals("delete")){Deletes del=new Deletes(this);}
if(s.equals("cut"))
{
edits=ta.getSelectedText();
int ct=ta.getCaretPosition();
StringBuffer sb=new StringBuffer(ta.getText());
sb.delete(ct,ct+edits.length());
ta.setText(sb.toString());
ta.setCaretPosition(ct);
}
if(s.equals("remove"))
{
int ct=ta.getCaretPosition()-ta.getSelectedText().length();
ta.setText(ta.getText().replace(ta.getSelectedText(),""));
ta.setCaretPosition(ct);
}
if(s.equals("copy")){edits=ta.getSelectedText();}
if(s.equals("paste"))
{
StringBuffer sb=new StringBuffer(ta.getText());
sb.insert(ta.getCaretPosition(),edits);
ta.setText(sb.toString());
/*ta.append(edits);*/
}


}
public void windowClosing(WindowEvent e){
if("Notepad".equals(this.getTitle())&&!("".equals(ta.getText())))
{
Confirmation csr=new Confirmation(this);
}
else
System.exit(0);}
public void windowClosed(WindowEvent e){}
public void windowOpened(WindowEvent e){}
public void windowActivated(WindowEvent e){}
public void windowDeactivated(WindowEvent e){}
public void windowIconified(WindowEvent e){}
public void windowDeiconified(WindowEvent e){}

public static void main(String args[])
{
Files f=new Files();
f.setVisible(true);
//f.setSize(1000,700);
f.setTitle("Notepad");
f.setBounds(20,20,1300,680);
}
}

//font starts
 class Fontb1 extends Frame implements ItemListener,FocusListener,Runnable,ActionListener,WindowListener
{
Label f;
TextField ft,fstylt,sizet;
List fl,fstyll,sizel;
Font fon1,fon2,fon3;
boolean flag=true;
boolean ch=false;
Label l1;
Button ok,cancel,confirm;
String st1,st2,st3;
String st="AaBbYyZz  ";
Files ff;
Fontb1(Files  ff)
{

//addWindowListener(new MyAdapter1(this));
addWindowListener(this);
this.ff=ff;
Color c=new Color(230,230,230);
setBackground(c);
f=new Label("Font:                                               Font Style:                          Size:");
setLayout(null);
ft=new TextField();
fstylt=new  TextField();
sizet=new TextField();
ft.setBounds(30,40,150,20);
fstylt.setBounds(200,40,120,20);
sizet.setBounds(340,40,60,20);
f.setBounds(30,10,390,20);
add(f);add(ft);add(fstylt);add(sizet);
fl=new  List(6);fstyll=new List(6);sizel=new List(6);
fl.add("Adobe arabic");fl.add("Adobe Caslon pro");fl.add("Adobe Fan Helti std");fl.add("Adobe Fang song std");fl.add("Adobe garamond pro");fl.add("Bell mt");fl.add("Berlin sans FB");fl.add("Bernard MT");fl.add("Cambria");fl.add("Can dara");fl.add("Elephant");fl.add("Dialog");fl.add("DialogInput");fl.add("SansSerief");fl.add("Serif");fl.add("Monospaced");
fstyll.add("REGULAR");fstyll.add("OBLIQUE");fstyll.add("BOLD");fstyll.add("BOLD OBLIC");
sizel.add("8");sizel.add("9");sizel.add("10");sizel.add("12");sizel.add("14");sizel.add("16");sizel.add("18");sizel.add("20");sizel.add("22");sizel.add("24");
fl.setBounds(30,60,150,120);fstyll.setBounds(200,60,120,120);sizel.setBounds(340,60,60,120);
fl.select(0);fstyll.select(0);sizel.select(0);
add(fl);add(fstyll);add(sizel);
Label l=new Label("Sample");
l.setBounds(200,190,50,20);
add(l);
//l1=new Label("AaBbYyZz");
fon1=new Font("Arial",Font.BOLD,22);
fon2=new Font("Serif",Font.ITALIC,24);
fon3=new Font("Dialog",Font.PLAIN,26);
//l1.setFont(fon1);l1.setBounds(230,220,160,70);add(l1);
Label script=new Label("Script:");
script.setBounds(216,310,50,20);add(script);
Choice sc=new Choice();
sc.add("western");sc.select(0);sc.setBounds(220,330,170,20);add(sc);
ok=new Button("Ok");
confirm=new Button("Confirm");
confirm.addActionListener(this);
ok.addActionListener(this);
cancel=new Button("Cancel");
cancel.addActionListener(this);
Color c4=new Color(200,200,200);
ok.setBackground(c4);
confirm.setBackground(c4);
cancel.setBackground(c4);
confirm.setBounds(140,360,75,30);add(confirm);
ok.setBounds(220,360,75,30);add(ok);
cancel.setBounds(300,360,75,30);add(cancel);
fl.addItemListener(this);fstyll.addItemListener(this);sizel.addItemListener(this);
ft.addFocusListener(this);fstylt.addFocusListener(this);sizet.addFocusListener(this);
sizet.addFocusListener(this);
Thread t=new Thread(this);
t.start();
this.setTitle("Font");
this.setVisible(true);
//this.setSize(424,400);
this.setBounds(450,200,424,400);
}
public void run()
{
for(;flag;)
{
char q;
q=st.charAt(0);
st=st.substring(1);
st=st+q;
try{
Thread.sleep(500);}
catch(InterruptedException e){}
repaint();
}
}
public void stop(){flag=false;}
public void actionPerformed(ActionEvent et)
{
if(et.getActionCommand().equals("Ok"))
{
ch=true;
st1=ft.getText();
st2=fstylt.getText();
st3=sizet.getText();
repaint();
}
if(et.getActionCommand().equals("Confirm"))
{
int ii=(fl.getSelectedIndex())%8;
switch(ii)
{
case 0:ff.font=fon1;break;
case 1:ff.font=fon2;break;
case 2:ff.font=fon3;break;
case 3:ff.font=new Font("DialogInput",Font.BOLD,22);break;
case 4:ff.font=new Font("SansSerief",Font.PLAIN,30);break;
case 5:ff.font=new Font("Serief",Font.PLAIN,20);break;
case 6:ff.font=new Font("Monospaced",Font.ITALIC,26);break;
case 7:ff.font=new Font("Dialog",Font.ITALIC,24);break;
}
ff.ta.setFont(ff.font);
this.setVisible(false);
}
if(et.getActionCommand().equals("Cancel"))
{
ch=false;
repaint();
}
}
public void focusGained(FocusEvent e)
{
ft.setText(fl.getSelectedItem());fstylt.setText(fstyll.getSelectedItem());sizet.setText(sizel.getSelectedItem());
}
public void focusLost(FocusEvent e)
{
	String aj=sizet.getText();
	if(aj.equals("8"))sizel.select(0);
	if(aj.equals("9"))sizel.select(1);
	if(aj.equals("10"))sizel.select(2);
	if(aj.equals("12"))sizel.select(3);
	if(aj.equals("14"))sizel.select(4);
	if(aj.equals("16"))sizel.select(5);
	if(aj.equals("18"))sizel.select(6);
	if(aj.equals("20"))sizel.select(7);
	if(aj.equals("22"))sizel.select(8);
	if(aj.equals("24"))sizel.select(9);
}

public void itemStateChanged(ItemEvent e)
{
ft.setText(fl.getSelectedItem());fstylt.setText(fstyll.getSelectedItem());sizet.setText(sizel.getSelectedItem());
int i=(fl.getSelectedIndex())%3;
/*switch(i)
{
case 0:l1.setFont(fon1);break;
case 1:l1.setFont(fon2);break;//fstyll.add("Narrow Italic",1);fstyll.add("Bold Italic",2);break;
case 2:l1.setFont(fon3);break;//fstyll.remove("Narrow Italic");fstyll.remove("Bold Italic");
}*/
repaint();
}
public void windowClosing(WindowEvent e){this.setVisible(false);}
public void windowClosed(WindowEvent e){}
public void windowOpened(WindowEvent e){}
public void windowActivated(WindowEvent e){}
public void windowDeactivated(WindowEvent e){}
public void windowIconified(WindowEvent e){}
public void windowDeiconified(WindowEvent e){}

public void paint(Graphics g)
{
if(ch)
{
g.setFont(new Font("Arial",Font.BOLD,16));
g.drawString("STYLE:"+st2,20,250);
g.drawString("SIZE:"+st3,20,280);
g.drawString("FONT:"+st1,20,310);

}
Color p=new Color(190,190,190);
g.setColor(p);
g.drawRect(200,200,190,100);
int i=(fl.getSelectedIndex())%8;
switch(i)
{
case 0:g.setFont(fon1);break;
case 1:g.setFont(fon2);break;//fstyll.add("Narrow Italic",1);fstyll.add("Bold Italic",2);break;
case 2:g.setFont(fon3);break;//fstyll.remove("Narrow Italic");fstyll.remove("Bold Italic");
case 3:g.setFont(new Font("DialogInput",Font.BOLD,30));break;
case 4:g.setFont(new Font("SansSerief",Font.PLAIN,30));break;
case 5:g.setFont(new Font("Serief",Font.PLAIN,30));break;
case 6:g.setFont(new Font("Monospaced",Font.ITALIC,30));break;
case 7:g.setFont(new Font("Dialog",Font.ITALIC,30));break;
}
g.setColor(Color.black);
g.drawString(st,210,260);
}
}
//Save starts
class Save extends Frame implements ActionListener,WindowListener
{
Button sb;
TextField stf;
Label sl;
Files sf;
Save(Files p)
{
//addWindowListener(new MyAdapter1(this));
setBackground(new Color(235,235,235));
addWindowListener(this);
setLocationRelativeTo(null);
sf=p;
setLayout(null);
this.setVisible(true);
//this.setSize(250,190);
this.setBounds(550,250,250,190);
this.setTitle("Save");
Button sb=new Button("save");sb.setBounds(100,120,55,30);
sl=new Label("Enter name(with type) to save");sl.setBounds(47,45,165,20);
stf=new TextField(15);stf.setBounds(55,80,145,25);
//setLayout(new FlowLayout());
add(sl);add(stf);add(sb);
sb.addActionListener(this);
}
public void actionPerformed(ActionEvent ap)
{
if(stf.getText().equals(""))
{
this.setVisible(false);
try{Thread.sleep(150);}catch(InterruptedException ee){}
this.setVisible(true);
}
else
{
sf.name=stf.getText();
File af=new File(sf.name);
if(af.exists())
{
	//sf.ta.setText("\t\t\tFILE ALREADY EXISTS");
	Frame ff=new Frame();
	ff.setLayout(null);
	ff.setBounds(550,250,250,150);
	ff.setTitle("Error");
	ff.setFont(new Font("arial",Font.ITALIC,20));
	Label ss=new Label("FILE ALREADY EXISTS");ss.setBounds(15,65,215,20);
	ff.add(ss);
	ff.setVisible(true);
	try{Thread.sleep(1000);}catch(InterruptedException ee){}
	ff.setVisible(false);
	
}
else
{
sf.setTitle(sf.name+"-"+"Notepad");
try{
	af.createNewFile();
	FileWriter fw=new FileWriter(sf.name);
	String mat=sf.ta.getText();
	int i=0,len;char sc='0';
	len=mat.length();
	while(i<len)
	{
	sc=mat.charAt(i);
	fw.write(sc);i++;
	}
	fw.close();
}
catch(IOException az){}
}

this.setVisible(false);
}
}
public void windowClosing(WindowEvent e){this.setVisible(false);}
public void windowClosed(WindowEvent e){}
public void windowOpened(WindowEvent e){}
public void windowActivated(WindowEvent e){}
public void windowDeactivated(WindowEvent e){}
public void windowIconified(WindowEvent e){}
public void windowDeiconified(WindowEvent e){}
public void paint(Graphics g)
{
g.setColor(new Color(170,170,170));
for(int l=0;l<6;l++)
g.drawRoundRect(20+l,35+l,210-2*l,140-2*l,20,20);
}
}


//Deletes starts
class Deletes extends Frame implements ActionListener,WindowListener
{
Button db;
TextField dtf;
Label dl;
Files df;
Deletes(Files p)
{
//addWindowListener(new MyAdapter1(this));
setBackground(new Color(235,235,235));
addWindowListener(this);
setLocationRelativeTo(null);
df=p;
setLayout(null);
this.setVisible(true);
//this.setSize(250,190);
this.setBounds(550,250,250,190);
this.setTitle("Delete");
Button db=new Button("Delete");db.setBounds(100,120,55,30);
dl=new Label("Enter name(with type) to delete");dl.setBounds(36,45,168,20);
dtf=new TextField(15);dtf.setBounds(55,80,145,25);
//setLayout(new FlowLayout());
add(dl);add(dtf);add(db);
db.addActionListener(this);
}
public void actionPerformed(ActionEvent ap)
{
if(dtf.getText().equals(""))
{
this.setVisible(false);
try{Thread.sleep(150);}catch(InterruptedException ee){}
this.setVisible(true);
}
else
{
df.name=dtf.getText();
File af=new File(df.name);
if(!af.exists())
{
	//sf.ta.setText("\t\t\tNO SUCH FILE  EXISTS");
	Frame ff=new Frame();
	ff.setLayout(null);
	ff.setBounds(550,250,250,150);
	ff.setTitle("Error");
	ff.setFont(new Font("arial",Font.ITALIC,20));
	Label ss=new Label("NO SUCH A FILE EXIST");ss.setBounds(15,65,225,20);
	ff.add(ss);
	ff.setVisible(true);
	try{Thread.sleep(1000);}catch(InterruptedException ee){}
	ff.setVisible(false);
	
}
else
{
	//df.setTitle("Notepad");
	af.delete();
	//df.ta.setText("");
	Frame ff=new Frame();
	ff.setLayout(null);
	ff.setBounds(550,250,290,150);
	ff.setTitle("Error");
	ff.setFont(new Font("arial",Font.ITALIC,20));
	Label ss=new Label("DELETED SUCCESSFULLY");ss.setBounds(15,65,255,20);
	ff.add(ss);
	ff.setVisible(true);
	try{Thread.sleep(1000);}catch(InterruptedException ee){}
	ff.setVisible(false);
	
}
this.setVisible(false);
}
}
public void windowClosing(WindowEvent e){this.setVisible(false);}
public void windowClosed(WindowEvent e){}
public void windowOpened(WindowEvent e){}
public void windowActivated(WindowEvent e){}
public void windowDeactivated(WindowEvent e){}
public void windowIconified(WindowEvent e){}
public void windowDeiconified(WindowEvent e){}
public void paint(Graphics g)
{
g.setColor(new Color(170,170,170));
for(int l=0;l<6;l++)
g.drawRoundRect(20+l,35+l,210-2*l,140-2*l,20,20);
}
}


//Confirmation Starts
class Confirmation extends Frame implements ActionListener,WindowListener
{
Button cb1,cb2,cb3;
Label cl1,cl2;
Files cf;
Confirmation(Files p)
{
//addWindowListener(new MyAdapter1(this));
setBackground(new Color(235,235,235));
addWindowListener(this);
setLocationRelativeTo(null);
cf=p;
setLayout(null);
this.setVisible(true);
//this.setSize(250,190);
this.setBounds(550,250,250,190);
this.setTitle("Confirmation");
cb1=new Button("Yes");cb1.setBounds(40,100,55,30);
cb2=new Button("No");cb2.setBounds(100,100,55,30);
cb3=new Button("Cancel");cb3.setBounds(160,100,55,30);

cl1=new Label("Do you really want to exit");cl1.setBounds(55,45,145,20);
cl2=new Label("without saving");cl2.setBounds(80,65,80,20);
add(cl1);add(cl2);add(cb1);add(cb2);add(cb3);
cb1.addActionListener(this);
cb2.addActionListener(this);
cb3.addActionListener(this);

}
public void actionPerformed(ActionEvent ap)
{
String stt=ap.getActionCommand();
if(stt.equals("Yes"))
{
System.exit(0);
}
else
{
	if(stt.equals("Cancel"))
	{this.setVisible(false);}
	else
	{
	Save p=new Save(cf);
	this.setVisible(false);
	}
}
}
public void windowClosing(WindowEvent e)
{
this.setVisible(false);
try{
Thread.sleep(100);}
catch(InterruptedException ee){}
this.setVisible(true);
}
public void windowClosed(WindowEvent e){}
public void windowOpened(WindowEvent e){}
public void windowActivated(WindowEvent e){}
public void windowDeactivated(WindowEvent e){}
public void windowIconified(WindowEvent e){}
public void windowDeiconified(WindowEvent e){}
public void paint(Graphics g)
{
g.setColor(new Color(170,170,170));
for(int l=0;l<6;l++)
g.drawRoundRect(20+l,35+l,210-2*l,140-2*l,20,20);
}
}

//Open starts
class Open extends Frame implements ActionListener,WindowListener
{
Files f;
Button b;
TextField tf;
Label ol;
Open(Files p)
{
setLocationRelativeTo(null);
//addWindowListener(new MyAdapter1(this));
addWindowListener(this);
//setLayout(new FlowLayout());
setBackground(new Color(235,235,235));
setLayout(null);
ol=new Label("Enter name of File(+type) to open");ol.setBounds(34,45,185,20);
this.setVisible(true);
//this.setSize(250,190);
this.setBounds(550,250,250,190);
this.setTitle("Open");
f=p;
b=new Button("OK");b.setBounds(100,120,55,30);
tf=new TextField(20);tf.setBounds(55,80,145,25);

add(ol);
add(tf);add(b);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(tf.getText().equals(""))
{
this.setVisible(false);
try{Thread.sleep(150);}catch(InterruptedException ee){}
this.setVisible(true);
}
else
{
f.name=tf.getText();
try{
	String mat="";
	File fl=new File(f.name);
	if(fl.exists()==false)
	{
	Frame ff=new Frame();
	ff.setLayout(null);
	ff.setBounds(550,250,250,150);
	ff.setTitle("Error");
	ff.setFont(new Font("arial",Font.ITALIC,20));
	Label ss=new Label("FILE NOT FOUND");ss.setBounds(47,65,185,20);
	ff.add(ss);
	ff.setVisible(true);
	try{Thread.sleep(800);}catch(InterruptedException ee){}
	ff.setVisible(false);
	}
	else
	{
	f.setTitle(f.name+"-"+"Notepad");
	FileReader fr=new FileReader(f.name);
	int ch=-1;
	do
	{	try{
		ch=fr.read();
		}
	catch(NumberFormatException ap){}
		if(ch!=-1)
		mat=mat+(""+(char)ch);
	}while(ch!=-1);
	f.ta.setText(mat);
	fr.close();
	}

}
catch(IOException az){}
this.setVisible(false);
}
}
public void windowClosing(WindowEvent e){this.setVisible(false);}
public void windowClosed(WindowEvent e){}
public void windowOpened(WindowEvent e){}
public void windowActivated(WindowEvent e){}
public void windowDeactivated(WindowEvent e){}
public void windowIconified(WindowEvent e){}
public void windowDeiconified(WindowEvent e){}
public void paint(Graphics g)
{
g.setColor(new Color(170,170,170));
for(int l=0;l<6;l++)
g.drawRoundRect(20+l,35+l,210-2*l,140-2*l,20,20);
}

}



//calculator starts
class Stackss
{
String num1,num2;
char ch1;
Stackss()
{
num1="";num2="";ch1='`';
}
void pushn(char n)
{
if(ch1=='`')
num1=num1+(""+n);
else
{num2=num2+(""+n);}
}
void pushc(char c)
{
if(c!='@')
{
	if(num2.equals(""))
	{ch1=c;}
	else
	{
	int n1,n2;
	n1=Integer.parseInt(num1);
	n2=Integer.parseInt(num2);
	switch(ch1)
	{
	case '+':n1=n1+n2;break;
	case '-':n1	=n1-n2;break;
	case '*':n1=n1*n2;break;
	case '/':if(n2==0){n1=0;break;}n1=n1/n2;
	}
	num1="";num2="";
	num1=""+n1;
	ch1=c;
	}
}
else
{num1="";num2="";ch1='`';}
}
String res()
{
if(!num2.equals(""))
{
	int n1,n2;
	n1=Integer.parseInt(num1);
	n2=Integer.parseInt(num2);
	switch(ch1)
	{
	case '+':n1=n1+n2;break;
	case '-':n1	=n1-n2;break;
	case '*':n1=n1*n2;break;
	case '/':n1=n1/n2;
	}
	num1="";num2="";
	num1=""+n1;
}
return num1;
}
String arr()
{
return num1+ch1+num2;
}
}
 class Calculator extends Frame implements ActionListener,WindowListener
{
 Button b[];
Panel pa;
TextField tf;
int i;String c;
Stackss st;
Calculator()
{
setLocationRelativeTo(null);
this.setTitle("Calculator");
//this.setSize(210,170);
this.setBounds(550,250,210,170);
this.setVisible(true);
//addWindowListener(new MyAdapter1(this));
addWindowListener(this);
setLayout(null);
st=new Stackss();
tf=new TextField(8);
pa=new Panel();
pa.setLayout(new GridLayout(4,4));
b=new Button[16];
b[0]=new Button("ON");b[1]=new Button("0");b[2]=new Button("=");b[3]=new Button("+");
b[4]=new Button("1");b[5]=new Button("2");b[6]=new Button("3");b[7]=new Button("-");
b[8]=new Button("4");b[9]=new Button("5");b[10]=new Button("6");b[11]=new Button("*");
b[12]=new Button("7");b[13]=new Button("8");b[14]=new Button("9");b[15]=new Button("/");
add(tf);
pa.add(b[0]);
for(i=1;i<16;i++)
{pa.add(b[i]);b[i].addActionListener(this);}
tf.setBounds(10,30,190,30);
b[0].addActionListener(this);
pa.setSize(300,300);
pa.setBounds(10,60,190,100);
add(pa);
}
public void actionPerformed(ActionEvent e)
{
c=e.getActionCommand();
char ch=c.charAt(0);
if(c.equals("ON"))ch='@';
if(ch!='=')
{
	if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='@')
	st.pushc(ch);
	else
	st.pushn(ch);
	tf.setText(st.arr());
}
else
tf.setText(st.res());
}
public void windowClosing(WindowEvent e){this.setVisible(false);}
public void windowClosed(WindowEvent e){}
public void windowOpened(WindowEvent e){}
public void windowActivated(WindowEvent e){}
public void windowDeactivated(WindowEvent e){}
public void windowIconified(WindowEvent e){}
public void windowDeiconified(WindowEvent e){}
}

/*class MyAdapter1 extends WindowAdapter
{
Object ob;
MyAdapter1(Object s)
{ob=s;}
public void windowClosing(WindowEvent qq)
{ob.setVisible(false);}
}*/