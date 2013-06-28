package com.android.monkeyrunner.recorder;

//import java.awt.Label;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.xml.soap.Text;

import org.python.modules.thread.thread;

import com.android.chimpchat.core.ChimpImageBase;
import com.android.chimpchat.core.IChimpImage;
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;

public class Frame extends JFrame implements ActionListener {

	class imgInfo {
		String name = null;
		boolean faild = false;

	}

	// private static List<imgInfo> standardImg = new
	// ArrayList<Frame1.imgInfo>();
	private static List<List> txtlist = new ArrayList<List>();
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private static String fileString = "";
	private static JButton jButton3 = null;
	// public static WritableWorkbook book = null;
	// public static WritableSheet sheet = null;
	private static int i = 0;
	private static int j = 0;
	// private Label mlabel = null;
	File[] files;
	File[] files1;
	File[] files2;
	private MonkeyRecorder f1 = null;
	private static ArrayList<String> filelist = new ArrayList<String>();

	boolean bool;
	String same = "";
	int num;

	private JButton getJButton() {
		fileString = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		//System.out.println("aaa" + fileString);
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(32, 22, 105, 35));
			jButton.setText("Դ�ļ�");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser(".");
					fileChooser
							.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnVal = fileChooser.showOpenDialog(fileChooser);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						System.out.println(fileChooser.getSelectedFile()
								.getAbsolutePath());// ���������ѡ����ļ��е�·��
						File root = new File(fileChooser.getSelectedFile()
								.getAbsolutePath());
						files = root.listFiles();
						for (File file : files) {
							j++;

							System.out.println("Դ�ļ�·����"
									+ fileChooser.getSelectedFile()
											.getAbsolutePath() + "��������Ŀ¼"
									+ file.getAbsolutePath());
						}
					}

				}
			});
		}
		return jButton;
	}

	private JButton getJButton1() {
		fileString = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(152, 22, 105, 35));
			jButton1.setText("�Ա��ļ�");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new Thread() {
						@Override
						public void run() {
							super.run();
							JFileChooser fileChooser = new JFileChooser(".");
							fileChooser
									.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
							int returnVal = fileChooser
									.showOpenDialog(fileChooser);
							if (returnVal == JFileChooser.APPROVE_OPTION) {
								System.out.println(fileChooser
										.getSelectedFile().getAbsolutePath());// ���������ѡ����ļ��е�·��
								File root = new File(fileChooser
										.getSelectedFile().getAbsolutePath());
								files1 = root.listFiles();
								for (File file : files1) {
									i++;
									System.out.println("�Ա��ļ�·����"
											+ fileChooser.getSelectedFile()
													.getAbsolutePath()
											+ "��������Ŀ¼" + file.getAbsolutePath());
								}
							}
						}
					}.start();

				}
			});

		}
		return jButton1;
	}

	private JButton getJButton2() {
		// fileString = Thread.currentThread().getContextClassLoader()
		// .getResource("").getPath();
		// System.out.println("we"+fileString);
		// System.out.println("www"+fileString.lastIndexOf("MonkeyRecoder"));
		// System.out.println("w"+fileString.indexOf("MonkeyRecoder"));
		// final String newfile = fileString.substring(fileString.indexOf(""),
		// fileString.lastIndexOf("MonkeyRecoder"));
		// System.out.println("ddd"+newfile);

		// fileString = Thread.currentThread().getContextClassLoader()
		// .getResource("").getPath();
		// System.out.println("we"+fileString);
		// System.out.println("www"+fileString.lastIndexOf("hjhjjj"));
		// System.out.println("w"+fileString.indexOf("hjhjjj"));
		// final String newfile = fileString.substring(fileString.indexOf(""),
		// fileString.lastIndexOf("hjhjjj"));
		// System.out.println("ddd"+newfile);

		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(152, 95, 105, 35));
			jButton2.setText("����ĵ�");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) {

							Select select = new Select();
							num = select.startNum;
//							System.out.println("aaaaaaa"+i);
							for(int num1 = 0;num1 < num;num1++){
							System.out.println("num1:"+num1);
							getImgLocations inage = new getImgLocations(Frame.this,num1);
							int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 400) / 2;
							int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 200) / 2;
							inage.setLocation(w, h);
							inage.setVisible(true);
							}
//							i = 0;
//							j = 0;
//							
//							files = null;
//							files1 = null;
//							files2 = null;
////							cutPicture();
//							JFileChooser fileChooser = new JFileChooser(".");
//							fileChooser
//									.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//							int returnVal = fileChooser
//									.showOpenDialog(fileChooser);
//							if (returnVal == JFileChooser.APPROVE_OPTION) {
//								String name = JOptionPane
//										.showInputDialog("�����ļ���");
//								if (name == null) {
//									System.out.println("the option is canceled ��");
//								} else if(name.equals("")){
//									JOptionPane.showMessageDialog(null,
//											"����ļ�������Ϊ�� ! ");
//								} else {
////									System.out.println("-------------------------------------");
//									// File file = new File(newfile+"e.txt");
//									FileWriter fw;
//									final String[] COLNAME_ARR = { "���",
//											"ѭ������",
//
//											"���" };
//									// final String[] COLNAME_ARR1 = { "���",
//									// "��һ��",
//									//
//									// "�ڶ���" };
//									// final String[] COLNAME_ARR2 = { "���",
//									// "��һ��",
//									//
//									// "�ڶ���" };
//									final int[] COLWIDTH_ARR = { 5, 15, 30 };// ��Ԫ����
//									final int[] COLWIDTH_ARR1 = { 5, 15, 30 };
//									final String[] FIELD_ARR = { "col1",
//											"col2", };// Ҫд��exceld���ֶ�
//									final String[] FIELD_ARR1 = { "col1",
//											"col2", };
//									final String[] FIELD_ARR2 = { "col1",
//											"col2", };
//									final String FILE_PATH = fileChooser
//											.getSelectedFile()
//											.getAbsolutePath();
//									// final String FILE_PATH1 =
//									// "E:"+File.separator;
//									final String FILE_NAME = name;
//									// final String FILE_NAME1 = "test1";
//									final String FILE_POSTFIX = ".xls";
//									// final String FILE_POSTFIX1 = ".xls";
//									JXLUtil.initExcel(FILE_PATH + FILE_NAME
//											+ FILE_POSTFIX, COLNAME_ARR,
//											COLWIDTH_ARR);
//									// JXLUtil.initExcel(FILE_PATH1+FILE_NAME1+FILE_POSTFIX1,
//									// COLNAME_ARR1, COLWIDTH_ARR1);
//									List<TmpVo> dataList = new ArrayList<TmpVo>();
//									List<TmpVo> dataList1 = new ArrayList<TmpVo>();
//									List<TmpVo> dataList2 = new ArrayList<TmpVo>();
//									List<TmpVo> dataList3 = new ArrayList<TmpVo>();
//									List<TmpVo> dataList4 = new ArrayList<TmpVo>();
//									// try {
//									// fw = new FileWriter(file);
//									// BufferedWriter bw = new
//									// BufferedWriter(fw);
//									int t = 0;
//									for (int s = 0; s < i; s++) {
//										boolean flag = true;
//										File root1 = new File(files1[s]
//												.getAbsolutePath());
//										files2 = root1.listFiles();
//										for (int k = 0; k < j; k++) {
//											IChimpImage image = ChimpImageBase
//													.loadImageFromFile(files[k]
//															.toString());
//											IChimpImage image1 = ChimpImageBase
//													.loadImageFromFile(files2[t]
//															.toString());
//											bool = image.sameAs(image1, 0.9);
//											if (bool == true) {
//												same = "��ȷ";
//											} else {
//												same = "����";
//												flag = false;
//											}
//
//											TmpVo vo = new TmpVo();
//											vo.setCol1((s + 1) + "-" + (k + 1));
//											vo.setCol2(same);
//											dataList.add(vo);
//											System.out.println("go");
//
//											t++;
//											if (t == (j)) {
//												t = 0;
//											}
//
//										}
//										System.out.println(flag);
//										if (flag == false) {
//											// System.out.println(flag);
//											TmpVo vo1 = new TmpVo();
//											vo1.setCol1("��" + (s + 1) + "��");
//											vo1.setCol2("ʧ��");
//											dataList1.add(vo1);
//										} else {
//											TmpVo vo1 = new TmpVo();
//											vo1.setCol1("��" + (s + 1) + "��");
//											vo1.setCol2("��ȷ");
//											dataList1.add(vo1);
//										}
//									}
//									TmpVo vo2 = new TmpVo();
//									vo2.setCol1("ÿ����ϸ���");
//									vo2.setCol2("���");
//									dataList2.add(vo2);
//									TmpVo vo3 = new TmpVo();
//									vo3.setCol1("  ");
//									vo3.setCol2("  ");
//									dataList3.add(vo3);
//									TmpVo vo4 = new TmpVo();
//									vo4.setCol1("������");
//									vo4.setCol2("���");
//									dataList4.add(vo4);
//									// JXLUtil.writeObjListToExcel(dataList1,
//									// FILE_PATH1+FILE_NAME1+FILE_POSTFIX1,
//									// FIELD_ARR1);
//									JXLUtil.writeObjListToExcel(dataList4,
//											FILE_PATH + FILE_NAME
//													+ FILE_POSTFIX, FIELD_ARR2);
//									JXLUtil.writeObjListToExcel(dataList1,
//											FILE_PATH + FILE_NAME
//													+ FILE_POSTFIX, FIELD_ARR2);
//
//									JXLUtil.writeObjListToExcel(dataList3,
//											FILE_PATH + FILE_NAME
//													+ FILE_POSTFIX, FIELD_ARR2);
//									JXLUtil.writeObjListToExcel(dataList2,
//											FILE_PATH + FILE_NAME
//													+ FILE_POSTFIX, FIELD_ARR2);
//
//									JXLUtil.writeObjListToExcel(dataList,
//											FILE_PATH + FILE_NAME
//													+ FILE_POSTFIX, FIELD_ARR);
//									JOptionPane.showMessageDialog(null,
//											"�������ɹ� ! ");
//									i = 0;
//									j = 0;
//									
//									files = null;
//									files1 = null;
//									files2 = null;
//									// } catch (IOException e1) {
//									// e1.printStackTrace();
//									// }
//
//								}
//
//							}


				}

			});
		}

		return jButton2;
	}

	private JButton getJButton3() {


		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(32, 95, 105, 35));
			jButton3.setText("��ͼƬ��");
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new Thread() {
						@Override
						public void run() {
							super.run();
							Select image = new Select(Frame.this);
							int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 400) / 2;
							int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 200) / 2;
							image.setLocation(w, h);
							image.setVisible(true);
						}
					}.start();

				}

			});
		}

		return jButton3;
	}
	public static void main(String[] args) {
		fileString = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frame thisClass = new Frame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	public Frame() {
		super();
		initialize();
	}

	public Frame(MonkeyRecorder f) {
		this();
		f1 = f;
	}

	private void initialize() {
		this.setSize(300, 180);
		this.setContentPane(getJContentPane());
		this.setTitle("������");
		this.setResizable(false);

	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);

			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
		}
		return jContentPane;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void cutPicture(int x,int y,int xx,int yy,int num){
		JFileChooser fileChooser = new JFileChooser(".");
		fileChooser
				.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser
				.showOpenDialog(fileChooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String name = JOptionPane
					.showInputDialog("�����ļ���");
			if (name == null) {
				System.out.println("the option is canceled ��");
			} else if(name.equals("")){
				JOptionPane.showMessageDialog(null,
						"����ļ�������Ϊ�� ! ");
			} else {
//				System.out.println("-------------------------------------");
				// File file = new File(newfile+"e.txt");
				final String[] COLNAME_ARR = { "���",
						"ѭ������",

						"���" };
				// final String[] COLNAME_ARR1 = { "���",
				// "��һ��",
				//
				// "�ڶ���" };
				// final String[] COLNAME_ARR2 = { "���",
				// "��һ��",
				//
				// "�ڶ���" };
				final int[] COLWIDTH_ARR = { 5, 15, 30 };// ��Ԫ����
				final int[] COLWIDTH_ARR1 = { 5, 15, 30 };
				final String[] FIELD_ARR = { "col1",
						"col2", };// Ҫд��exceld���ֶ�
				final String[] FIELD_ARR1 = { "col1",
						"col2", };
				final String[] FIELD_ARR2 = { "col1",
						"col2", };
				final String FILE_PATH = fileChooser
						.getSelectedFile()
						.getAbsolutePath();
				// final String FILE_PATH1 =
				// "E:"+File.separator;
				final String FILE_NAME = name;
				// final String FILE_NAME1 = "test1";
				final String FILE_POSTFIX = ".xls";
				// final String FILE_POSTFIX1 = ".xls";
				JXLUtil.initExcel(FILE_PATH +"/"+ FILE_NAME
						+ FILE_POSTFIX, COLNAME_ARR,
						COLWIDTH_ARR);
				// JXLUtil.initExcel(FILE_PATH1+FILE_NAME1+FILE_POSTFIX1,
				// COLNAME_ARR1, COLWIDTH_ARR1);
				List<TmpVo> dataList = new ArrayList<TmpVo>();
				List<TmpVo> dataList1 = new ArrayList<TmpVo>();
				List<TmpVo> dataList2 = new ArrayList<TmpVo>();
				List<TmpVo> dataList3 = new ArrayList<TmpVo>();
				List<TmpVo> dataList4 = new ArrayList<TmpVo>();
				// try {
				// fw = new FileWriter(file);
				// BufferedWriter bw = new
				// BufferedWriter(fw);
				int t = 0;
				for (int s = 0; s < i; s++) {
					boolean flag = true;
					File root1 = new File(files1[s]
							.getAbsolutePath());
					files2 = root1.listFiles();
					for (int k = 0; k < j; k++) {
						IChimpImage image = ChimpImageBase
								.loadImageFromFile(files[k]
										.toString());
						IChimpImage image1 = ChimpImageBase
								.loadImageFromFile(files2[t]
										.toString());
						IChimpImage image_0 =	image.getSubImage(x, y, xx, yy);
						
//						String nan = "D:/screenshot/";
//						image_0.writeToFile(nan+s+k+".png", "png");
						
						IChimpImage image_1 = image1.getSubImage(x, y, xx, yy);
						
//						String nan2 = "D:/screenshot/";
//						image_1.writeToFile(nan+s+k+".png", "png");
						
						bool = image_0.sameAs(image_1, 0.95);
						
						
						if((k == 0) && (s == 0)){
							String src = "D:/screenshot/";
							image_0.writeToFile(src+num+"src.png", "png");
							String des = "D:/screenshot/";
							image_1.writeToFile(des+num+"des.png", "png");
						}						
						
						if (bool == true) {
							same = "��ȷ";
						} else {
							same = "����";
							flag = false;
						}

						TmpVo vo = new TmpVo();
						vo.setCol1((s + 1) + "-" + (k + 1));
						vo.setCol2(same);
						dataList.add(vo);
						System.out.println("go");

						t++;
						if (t == (j)) {
							t = 0;
						}

					}
					System.out.println(flag);
					if (flag == false) {
						// System.out.println(flag);
						TmpVo vo1 = new TmpVo();
						vo1.setCol1("��" + (s + 1) + "��");
						vo1.setCol2("ʧ��");
						dataList1.add(vo1);
					} else {
						TmpVo vo1 = new TmpVo();
						vo1.setCol1("��" + (s + 1) + "��");
						vo1.setCol2("�ɹ�");
						dataList1.add(vo1);
					}
				}
				TmpVo vo2 = new TmpVo();
				vo2.setCol1("ÿ����ϸ���");
				vo2.setCol2("���");
				dataList2.add(vo2);
				TmpVo vo3 = new TmpVo();
				vo3.setCol1("  ");
				vo3.setCol2("  ");
				dataList3.add(vo3);
				TmpVo vo4 = new TmpVo();
				vo4.setCol1("������");
				vo4.setCol2("���");
				dataList4.add(vo4);
				// JXLUtil.writeObjListToExcel(dataList1,
				// FILE_PATH1+FILE_NAME1+FILE_POSTFIX1,
				// FIELD_ARR1);
				JXLUtil.writeObjListToExcel(dataList4,
						FILE_PATH +"/"+ FILE_NAME
								+ FILE_POSTFIX, FIELD_ARR2);
				JXLUtil.writeObjListToExcel(dataList1,
						FILE_PATH +"/"+ FILE_NAME
								+ FILE_POSTFIX, FIELD_ARR2);

				JXLUtil.writeObjListToExcel(dataList3,
						FILE_PATH +"/"+ FILE_NAME
								+ FILE_POSTFIX, FIELD_ARR2);
				JXLUtil.writeObjListToExcel(dataList2,
						FILE_PATH +"/"+ FILE_NAME
								+ FILE_POSTFIX, FIELD_ARR2);

				JXLUtil.writeObjListToExcel(dataList,
						FILE_PATH +"/"+ FILE_NAME
								+ FILE_POSTFIX, FIELD_ARR);
				JOptionPane.showMessageDialog(null,
						"�������ɹ� ! ");

				// } catch (IOException e1) {
				// e1.printStackTrace();
				// }

			}

		}
	
	}

}
